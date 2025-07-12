from flask import Flask, render_template, jsonify
import requests

app = Flask(__name__)

# IP o dominio del balanceador de carga
API_BACKEND_URL = "https://4c61e295ca06.ngrok-free.app/provincias"

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/provincias')
def obtener_provincias():
    response = requests.get(API_BACKEND_URL)
    return jsonify(response.json())

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)
