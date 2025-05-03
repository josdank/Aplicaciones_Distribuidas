import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.neighbors import KNeighborsClassifier
import os

# 1. Cargar el dataset con manejo de rutas
script_dir = os.path.dirname(os.path.abspath(__file__))
csv_path = os.path.join(script_dir, "premier-player-23-24.csv")

try:
    df = pd.read_csv(csv_path, encoding='latin1')
except FileNotFoundError:
    print(f"\nERROR: Archivo no encontrado en: {csv_path}")
    print("Archivos disponibles:", os.listdir(script_dir))
    exit()

# 2. Filtrar jugadores FW (delanteros)
df_fw = df[df["Pos"].str.upper().str.contains("FW|FORWARD|FWD", na=False, regex=True)].copy()

if df_fw.empty:
    print("\nNo hay jugadores FW. Posiciones disponibles:", df["Pos"].unique())
    exit()

# 3. Crear categorías con manejo de duplicados
df_fw["Total_Contrib"] = df_fw["Gls"] + df_fw["Ast"]

try:
    # Intentar con cuantiles
    df_fw["Categoria"] = pd.qcut(df_fw["Total_Contrib"], 
                            q=[0, 0.25, 0.75, 1], 
                            labels=["Malo", "Normal", "Bueno"],
                            duplicates='drop')
except ValueError:
    # Si falla, usar rangos fijos
    bins = [-1, 5, 15, 100]  # Ajustar según análisis real
    df_fw["Categoria"] = pd.cut(df_fw["Total_Contrib"], 
                            bins=bins, 
                            labels=["Malo", "Normal", "Bueno"])

# 4. Mostrar distribución
print("\nDistribución de categorías:")
print(df_fw["Categoria"].value_counts())

# 5. Preparar datos para el modelo
X = df_fw[["Gls", "Ast"]]
y = df_fw["Categoria"]

# 6. Dividir y normalizar datos
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
scaler = StandardScaler()
X_train = scaler.fit_transform(X_train)
X_test = scaler.transform(X_test)

# 7. Entrenar y evaluar modelo
knn = KNeighborsClassifier(n_neighbors=5)
knn.fit(X_train, y_train)
accuracy = knn.score(X_test, y_test)
print(f'\nPrecisión del modelo: {accuracy:.2f}')

# 8. Sistema de predicción interactivo
print("\nIngresa las estadísticas de un nuevo delantero:")
goles = float(input("Goles en la temporada: "))
asistencias = float(input("Asistencias en la temporada: "))

nuevo_jugador = scaler.transform([[goles, asistencias]])
prediccion = knn.predict(nuevo_jugador)[0]

if prediccion == "Bueno":
    msg = "Delantero Estrella: Percentil 75+ (G+A > {})".format(
        df_fw[df_fw["Categoria"] == "Bueno"]["Total_Contrib"].min()
    )
elif prediccion == "Normal":
    msg = "Deltantero Promedio: Entre {} y {} G+A".format(
        df_fw[df_fw["Categoria"] == "Normal"]["Total_Contrib"].min(),
        df_fw[df_fw["Categoria"] == "Normal"]["Total_Contrib"].max()
    )
else:
    msg = "Mal Delantero: Menos de {} G+A".format(
        df_fw[df_fw["Categoria"] == "Malo"]["Total_Contrib"].max()
    )

print(f"\n{msg}")
print(f"Detalles: {goles} Goles | {asistencias} Asistencias | Total: {goles + asistencias}")
