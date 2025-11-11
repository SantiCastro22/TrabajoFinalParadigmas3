-- Tipos de Cliente
INSERT INTO tipo_cliente (nombre, descripcion) VALUES
('CONSUMIDOR FINAL', 'Clientes que compran para consumo personal');

-- Formas de Pago
INSERT INTO forma_pago (descripcion) VALUES
('CONTADO'),
('DEBITO');

-- Categorías
INSERT INTO categoria (denominacion, descripcion) VALUES
('ELECTRONICA', 'Productos electrónicos y tecnológicos'),
('ALIMENTOS', 'Productos alimenticios y bebidas');

-- Clientes de ejemplo
INSERT INTO cliente (documento, nombre, apellido, fecha_nacimiento, direccion, tipo_cliente_id) VALUES
('12345678', 'Juan', 'Perez', '1985-05-15', 'Av. Principal 123, La Rioja', 1),
('87654321', 'María', 'González', '1990-08-22', 'Calle Secundaria 456, La Rioja', 1);

-- Productos de ejemplo
INSERT INTO producto (categoria_id, nombre, descripcion, precio, fecha_creacion) VALUES
(1, 'Notebook Dell Inspiron', 'Notebook Dell Inspiron 15 - 8GB RAM - 256GB SSD', 850000.00, CURRENT_DATE),
(2, 'Aceite de Oliva 500ml', 'Aceite de oliva extra virgen', 3500.00, CURRENT_DATE);

-- Factura de ejemplo
INSERT INTO factura (numero_factura, cliente_id, forma_pago_id, total, observaciones)
VALUES ('F-202411-000001', 1, 1, 0, 'Primera factura ejemplo');

-- Líneas de factura de ejemplo
INSERT INTO linea_factura (factura_id, producto_id, cantidad, subtotal) VALUES
(1, 1, 1, 850000.00),
(1, 2, 2, 7000.00);
