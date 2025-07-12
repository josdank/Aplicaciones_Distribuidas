let map = L.map('map').setView([-1.8312, -78.1834], 6);
let currentMarker = null;

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '© OpenStreetMap contributors'
}).addTo(map);

const coordenadas = {
    "Azuay": [-2.9006, -79.0045],
    "Bolívar": [-1.6133, -79.0024],
    "Cañar": [-2.5600, -78.9384],
    "Carchi": [0.5022, -77.9960],
    "Chimborazo": [-1.6743, -78.6569],
    "Cotopaxi": [-0.9333, -78.6167],
    "El Oro": [-3.2581, -79.9579],
    "Esmeraldas": [0.9682, -79.6517],
    "Galápagos": [-0.9538, -90.9656],
    "Guayas": [-2.1962, -79.8862],
    "Imbabura": [0.3517, -78.1223],
    "Loja": [-3.9931, -79.2042],
    "Los Ríos": [-1.1494, -79.4600],
    "Manabí": [-1.0546, -80.4529],
    "Morona Santiago": [-2.2425, -78.2150],
    "Napo": [-0.9932, -77.8126],
    "Orellana": [-0.4546, -76.9878],
    "Pastaza": [-1.4923, -77.9910],
    "Pichincha": [-0.1807, -78.4678],
    "Santa Elena": [-2.2297, -80.8592],
    "Santo Domingo": [-0.2541, -79.1717],
    "Sucumbíos": [0.0881, -76.8880],
    "Tungurahua": [-1.2543, -78.6229],
    "Zamora Chinchipe": [-4.0679, -78.9544]
};

let provincias = [];

fetch('/provincias')
    .then(res => res.json())
    .then(data => {
        provincias = data;
        renderProvincias(data);
    });

function renderProvincias(data) {
    const list = document.getElementById('provincia-list');
    list.innerHTML = '';

    data.forEach(prov => {
        const btn = document.createElement('button');
        btn.textContent = prov.nombre;
        btn.classList.add('provincia-btn');
        btn.addEventListener('click', () => {
            mostrarInfo(prov);
            centrarYMarcar(prov);
        });
        list.appendChild(btn);
    });
}

function mostrarInfo(provincia) {
    document.getElementById('nombre-provincia').textContent = provincia.nombre;
    document.getElementById('capital-provincia').textContent = provincia.capital;
    document.getElementById('area-provincia').textContent = provincia.area_km2;
    document.getElementById('poblacion-provincia').textContent = provincia.poblacion_estimada;
}

function centrarYMarcar(provincia) {
    const coords = coordenadas[provincia.nombre];
    if (!coords) return;

    if (currentMarker) {
        map.removeLayer(currentMarker);
    }

    currentMarker = L.marker(coords).addTo(map);
    map.setView(coords, 9);
}

// Buscar
document.getElementById('search-input').addEventListener('input', function () {
    const valor = this.value.toLowerCase();
    const filtradas = provincias.filter(p =>
        p.nombre.toLowerCase().includes(valor)
    );
    renderProvincias(filtradas);
});

// Reiniciar mapa
document.getElementById('reset-map').addEventListener('click', () => {
    if (currentMarker) {
        map.removeLayer(currentMarker);
        currentMarker = null;
    }
    map.setView([-1.8312, -78.1834], 6);
});

// Mostrar/Ocultar lista
document.getElementById('toggle-list').addEventListener('click', () => {
    const lista = document.getElementById('provincia-list');
    lista.style.display = lista.style.display === 'none' ? 'block' : 'none';
});
