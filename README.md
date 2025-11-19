# Sistema de Ventas y Facturación

Proyecto final para la catedra Paradigmas y Lenguajes 3 
permite la gestión de ventas, clientes, productos y facturación.

**Stack:** Java, Swing, PostgreSQL, Docker.

---

## Puesta en Marcha (Docker)

### 1. Configuración
1.  **Clonar:**
    ```bash
    git clone <URL_DEL_REPOSITORIO>
    cd tpfinalventas
    ```
2.  **Crear `.env`:**
    Crea un archivo `.env` en la raíz del proyecto:
    ```env
    POSTGRES_HOST=localhost
    POSTGRES_PORT=5432
    POSTGRES_DB=ventas_db
    POSTGRES_USER=tu_user
    POSTGRES_PASSWORD=tu_password
    ```

### 3. Ejecución
1.  **Levantar servicios:**
    ```bash
    docker-compose up -d --build
    ```
2.  **Ejecutar la aplicación:**
    Abre el proyecto en tu IDE y ejecuta la clase principal.

---

## Comandos utiles de Docker
*   `docker-compose start` - Inicia los contenedores.
*   `docker-compose stop` - Detiene los contenedores.
*   `docker-compose down -v` - Detiene y elimina contenedores y volúmenes.

---

## Base de Datos Local (Alternativa)

1.  Asegúrate de que PostgreSQL esté corriendo.
2.  Crea una base de datos y un usuario que coincidan con el `.env`.
3.  Ejecutar los scripts de la  carpeta db-config
