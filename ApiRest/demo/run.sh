#!/bin/bash

# Script para compilar y ejecutar la aplicación
# Uso: ./run.sh

echo "================================"
echo "   API REST - Plataforma Gamificación"
echo "================================"
echo ""

echo "1️⃣  Limpiando el proyecto..."
mvn clean

echo ""
echo "2️⃣  Compilando el proyecto..."
mvn install

echo ""
echo "3️⃣  Iniciando la aplicación Spring Boot..."
echo ""
echo "La aplicación se ejecutará en: http://localhost:8080"
echo "H2 Console disponible en: http://localhost:8080/h2-console"
echo ""

mvn spring-boot:run

# Si quieres que se abra el navegador automáticamente, descomenta la siguiente línea:
# open http://localhost:8080/api/health  # macOS
# start http://localhost:8080/api/health # Windows
# xdg-open http://localhost:8080/api/health # Linux
