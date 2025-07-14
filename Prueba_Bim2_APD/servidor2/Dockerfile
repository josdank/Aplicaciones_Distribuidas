FROM python:3.10-slim
WORKDIR /app
COPY . .
RUN apt-get update && apt-get install -y gcc default-libmysqlclient-dev pkg-config && rm -rf /var/lib/apt/lists/*
RUN pip install Flask==2.3.2 Flask-MySQLdb==1.0.1
EXPOSE 5000
CMD ["python", "app.py"]