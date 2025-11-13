
CREATE TABLE tipo_cliente (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT,
    CONSTRAINT chk_tipo_cliente_nombre_min CHECK (LENGTH(nombre) >= 3)
);

CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    documento VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE,
    direccion TEXT,
    tipo_cliente_id INTEGER NOT NULL,
    CONSTRAINT fk_cliente_tipo_cliente FOREIGN KEY (tipo_cliente_id)
        REFERENCES tipo_cliente(id) ON DELETE RESTRICT,
    CONSTRAINT chk_cliente_nombre_min CHECK (LENGTH(nombre) >= 3),
    CONSTRAINT chk_cliente_apellido_min CHECK (LENGTH(apellido) >= 3)
);

CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    denominacion VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT,
    CONSTRAINT chk_categoria_denominacion_min CHECK (LENGTH(denominacion) >= 3)
);

CREATE TABLE producto (
    id SERIAL PRIMARY KEY,
    categoria_id INTEGER NOT NULL,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT,
    precio REAL NOT NULL,
    fecha_creacion DATE DEFAULT CURRENT_DATE,
    CONSTRAINT fk_producto_categoria FOREIGN KEY (categoria_id)
        REFERENCES categoria(id) ON DELETE RESTRICT,
    CONSTRAINT chk_producto_nombre_min CHECK (LENGTH(nombre) >= 3),
    CONSTRAINT chk_producto_precio_positivo CHECK (precio > 0)
);

CREATE TABLE forma_pago (
    id SERIAL PRIMARY KEY,
    descripcion VARCHAR(100) NOT NULL UNIQUE,
    CONSTRAINT chk_forma_pago_descripcion_min CHECK (LENGTH(descripcion) >= 3)
);

CREATE TABLE factura (
    id SERIAL PRIMARY KEY,
    numero_factura VARCHAR(50) NOT NULL UNIQUE,
    cliente_id INTEGER NOT NULL,
    forma_pago_id INTEGER NOT NULL,
    fecha_emision TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total NUMERIC(12, 2) NOT NULL DEFAULT 0,
    observaciones TEXT,
    CONSTRAINT fk_factura_cliente FOREIGN KEY (cliente_id)
        REFERENCES cliente(id) ON DELETE RESTRICT,
    CONSTRAINT fk_factura_forma_pago FOREIGN KEY (forma_pago_id)
        REFERENCES forma_pago(id) ON DELETE RESTRICT,
    CONSTRAINT chk_factura_total_positivo CHECK (total >= 0)
);

CREATE TABLE linea_factura (
    id SERIAL PRIMARY KEY,
    factura_id INTEGER NOT NULL,
    producto_id INTEGER NOT NULL,
    cantidad DOUBLE PRECISION NOT NULL,
    subtotal DOUBLE PRECISION NOT NULL,
    CONSTRAINT fk_linea_factura_factura FOREIGN KEY (factura_id)
        REFERENCES factura(id) ON DELETE CASCADE,
    CONSTRAINT fk_linea_factura_producto FOREIGN KEY (producto_id)
        REFERENCES producto(id) ON DELETE RESTRICT,
    CONSTRAINT chk_linea_cantidad_positiva CHECK (cantidad > 0),
    CONSTRAINT chk_linea_subtotal_positivo CHECK (subtotal >= 0)
);

CREATE SEQUENCE factura_seq START WITH 1;