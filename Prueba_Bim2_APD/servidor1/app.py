from flask import Flask, render_template, request, redirect, url_for
from flask_mysqldb import MySQL
import os

app = Flask(__name__)

# Configuración de la base de datos desde variables de entorno (con valores por defecto)
app.config['MYSQL_HOST'] = os.getenv("MYSQL_HOST", "maestro1")
app.config['MYSQL_USER'] = os.getenv("MYSQL_USER", "root")
app.config['MYSQL_PASSWORD'] = os.getenv("MYSQL_PASSWORD", "root")
app.config['MYSQL_DB'] = os.getenv("MYSQL_DB", "db_informacion")
app.config['MYSQL_PORT'] = int(os.getenv("MYSQL_PORT", 3306))

# Inicializar la conexión con MySQL
mysql = MySQL(app)

@app.route('/', methods=['GET', 'POST'])
def formulario():
    if request.method == 'POST':
        # Obtener los datos del formulario
        nombre = request.form.get('nombre')
        correo = request.form.get('correo')
        experiencia = request.form.get('experiencia')
        formacion = request.form.get('formacion')

        # Insertar en la base de datos
        try:
            cur = mysql.connection.cursor()
            cur.execute(
                "INSERT INTO datos (nombre, correo, experiencia, formacion) VALUES (%s, %s, %s, %s)",
                (nombre, correo, experiencia, formacion)
            )
            mysql.connection.commit()
            cur.close()
        except Exception as e:
            print(f"Error al insertar en la base de datos: {e}")
            return "Error al procesar los datos."

        return redirect(url_for('formulario'))

    return render_template('index.html')

if __name__ == "__main__":
    app.run(host='0.0.0.0')
