@echo off
REM Script para compilar y ejecutar la aplicación en Windows
REM Uso: run.bat

echo.
echo ================================
echo    API REST - Plataforma Gamificaci=C3=B3n
echo ================================
echo.

echo 1. Limpiando el proyecto...
call mvn clean
if errorlevel 1 goto error

echo.
echo 2. Compilando el proyecto...
call mvn install
if errorlevel 1 goto error

echo.
echo 3. Iniciando la aplicación Spring Boot...
echo.
echo La aplicaci=C3=B3n se ejecutar=C3=A1 en: http://localhost:8080
echo H2 Console disponible en: http://localhost:8080/h2-console
echo Presiona Ctrl+C para detener la aplicaci=C3=B3n
echo.

call mvn spring-boot:run
goto end

:error
echo.
echo ERROR: Hubo un problema durante la compilaci=C3=B3n
echo Verifica que Maven est=C3=A9 instalado correctamente
pause
exit /b 1

:end
echo.
echo Aplicaci=C3=B3n finalizada
pause
