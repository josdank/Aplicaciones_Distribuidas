from flask import Flask, render_template
from flask_mysqldb import MySQL
import os

app = Flask(__name__)

# Configuración de conexión con el esclavo MySQL
app.config['MYSQL_HOST'] = os.getenv("MYSQL_HOST", "esclavo1")
app.config['MYSQL_USER'] = os.getenv("MYSQL_USER", "root")
app.config['MYSQL_PASSWORD'] = os.getenv("MYSQL_PASSWORD", "root")
app.config['MYSQL_DB'] = os.getenv("MYSQL_DB", "db_informacion")
app.config['MYSQL_PORT'] = int(os.getenv("MYSQL_PORT", 3306))

mysql = MySQL(app)

@app.route('/')
def mostrar_datos():
    try:
        cur = mysql.connection.cursor()
        cur.execute("SELECT * FROM datos")
        datos = cur.fetchall()
        cur.close()
        return render_template('ver.html', datos=datos)
    except Exception as e:
        print(f"Error al consultar la base de datos: {e}")
        return "Error al mostrar los datos."

if __name__ == "__main__":
    app.run(host='0.0.0.0')
