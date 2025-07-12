
# 🗺️ Deber 3 - Mapa Interactivo del Ecuador (Aplicaciones Distribuidas)

Este proyecto corresponde al Deber N° 3 de la asignatura **Aplicaciones Distribuidas**, en el cual se desarrolló una aplicación Flask que despliega un **mapa interactivo del Ecuador** y permite consultar información de cada provincia de forma dinámica, conectándose a un backend balanceado con Docker.

---

## ✅ Objetivos del proyecto

- Mostrar un mapa del Ecuador utilizando Leaflet.js.
- Visualizar una lista interactiva de las provincias del país.
- Consumir información desde un backend Flask balanceado (con Docker).
- Mostrar los datos principales de cada provincia:
  - Nombre
  - Capital
  - Área
  - Población estimada
- Incluir funcionalidades modernas como:
  - Búsqueda en tiempo real por nombre de provincia.
  - Marcador dinámico sobre la provincia seleccionada.
  - Zoom automático al seleccionar una provincia.
  - Botón para reiniciar el mapa a la vista original.
  - Diseño moderno y responsivo tipo profesional.

---

## 🧱 Tecnologías utilizadas

- **Frontend**
  - [Flask](https://flask.palletsprojects.com/)
  - [Leaflet.js](https://leafletjs.com/)
  - HTML5 + CSS3
  - JavaScript moderno (ES6)
- **Backend**
  - Flask REST API (expuesta desde un servidor balanceado)
- **Infraestructura**
  - Docker (para contenedores backend y balanceador)
  - NGINX (balanceador de carga en Docker)
  - Git + GitHub

---

## 🖥️ Estructura del frontend

```
flask_mapa_ecuador/
├── app.py
├── templates/
│   └── index.html
├── static/
│   ├── css/
│   │   └── style.css
│   ├── js/
│   │   └── map.js
├── requirements.txt
├── Dockerfile
└── README.md
```

---

## 📌 Funcionalidades clave

- ✅ Vista del mapa centrado en Ecuador.
- ✅ Botón 📋 para mostrar/ocultar la lista de provincias.
- ✅ Botón 🧭 para reiniciar la vista del mapa (zoom out).
- ✅ Lista de provincias generada desde la API `/provincias`.
- ✅ Input de búsqueda para filtrar provincias por nombre.
- ✅ Selección de una provincia:
  - Centra el mapa en su ubicación.
  - Coloca un pin marcador.
  - Muestra su capital, área y población.
- ✅ Compatible con pantallas pequeñas (diseño responsivo).

---

## 🔌 Cómo ejecutar el frontend

### 1. Instalar dependencias

```bash
pip install -r requirements.txt
```

### 2. Ejecutar el servidor Flask

```bash
python app.py
```

Accede en el navegador: [http://localhost:5000](http://localhost:5000)

---

## 🐳 Ejecución con Docker

### Construir la imagen

```bash
docker build -t flask-mapa-ecuador .
```

### Ejecutar el contenedor

```bash
docker run -p 5000:5000 flask-mapa-ecuador
```

---

## 🔁 Fuente de datos

Los datos de las provincias son obtenidos mediante una petición HTTP (`/provincias`) a un **servidor Flask** que se encuentra detrás de un balanceador de carga (NGINX). Este backend fue desarrollado por el compañero de equipo como parte del mismo deber.

---

## ✍️ Autor

- **Nombre:** Josdank (o tu nombre completo aquí)
- **Materia:** Aplicaciones Distribuidas (TDSD523)
- **Profesor:** Ing. Sergio Granizo, MSc.
- **Escuela:** ESFOT – Escuela Politécnica Nacional
- **Período:** 2025-A

---

## 📸 Captura de la aplicación

![Captura del mapa](https://github.com/user-attachments/assets/809085ea-e51f-4db0-af6f-442c813b4126)

---

## ✅ Estado del proyecto

✔️ Funcional  
✔️ Dockerizado  
✔️ Integrado con backend balanceado  
✔️ Estilo profesional  
✔️ Listo para entrega

---
