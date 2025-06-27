
CREATE SEQUENCE seq_persona_id START 1 INCREMENT 1;
CREATE SEQUENCE seq_cliente_id START 1 INCREMENT 1;
CREATE SEQUENCE seq_cuenta_id START 1 INCREMENT 1;
CREATE SEQUENCE seq_movimiento_id START 1 INCREMENT 1;

CREATE TABLE persona (
    id INT PRIMARY KEY DEFAULT NEXTVAL('seq_persona_id'),
    nombre VARCHAR(100),
    genero VARCHAR(10),
    edad INT,
    identificacion VARCHAR(50) UNIQUE,
    direccion VARCHAR(255),
    telefono VARCHAR(20)
);

CREATE TABLE cliente (
    id INT PRIMARY KEY DEFAULT NEXTVAL('seq_cliente_id'),
    persona_id INT UNIQUE REFERENCES persona(id) ON DELETE CASCADE,
    cliente_id VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    estado BOOLEAN NOT NULL
);

CREATE TABLE cuenta (
    id INT PRIMARY KEY DEFAULT NEXTVAL('seq_cuenta_id'),
    numero_cuenta VARCHAR(50) UNIQUE NOT NULL,
    tipo_cuenta VARCHAR(20),
    saldo_inicial DECIMAL(12,2) NOT NULL,
    estado BOOLEAN NOT NULL,
    cliente_id INT REFERENCES cliente(id) ON DELETE CASCADE
);

CREATE TABLE movimiento (
    id INT PRIMARY KEY DEFAULT NEXTVAL('seq_movimiento_id'),
    cuenta_id INT REFERENCES cuenta(id) ON DELETE CASCADE,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipo_movimiento VARCHAR(50),
    valor DECIMAL(12,2),
    saldo DECIMAL(12,2)
);

INSERT INTO persona (id, nombre, genero, edad, identificacion, direccion, telefono)
VALUES 
(NEXTVAL('seq_persona_id'), 'Jose Lema', 'Masculino', 30, 'ID001', 'Otavalo sn y principal', '098254785'),
(NEXTVAL('seq_persona_id'), 'Marianela Montalvo', 'Femenino', 28, 'ID002', 'Amazonas y NNUU', '097548965'),
(NEXTVAL('seq_persona_id'), 'Juan Osorio', 'Masculino', 35, 'ID003', '13 junio y Equinoccial', '098874587');

INSERT INTO cliente (id, persona_id, cliente_id, "password", estado)
VALUES 
(NEXTVAL('seq_cliente_id'), 1, 'CLI001', '1234', true),
(NEXTVAL('seq_cliente_id'), 2, 'CLI002', '5678', true),
(NEXTVAL('seq_cliente_id'), 3, 'CLI003', '1245', true);

INSERT INTO cuenta (id, numero_cuenta, tipo_cuenta, saldo_inicial, estado, cliente_id)
VALUES 
(NEXTVAL('seq_cuenta_id'), '478758', 'Ahorro', 2000.00, true, 1),
(NEXTVAL('seq_cuenta_id'), '225487', 'Corriente', 100.00, true, 2),
(NEXTVAL('seq_cuenta_id'), '495878', 'Ahorros', 0.00, true, 3),
(NEXTVAL('seq_cuenta_id'), '496825', 'Ahorros', 540.00, true, 2),
(NEXTVAL('seq_cuenta_id'), '585545', 'Corriente', 1000.00, true, 1);

-- Movimientos (suponiendo IDs de cuentas generados en orden 1 al 5)
INSERT INTO movimiento (id, cuenta_id, tipo_movimiento, valor, saldo, fecha)
VALUES 
(NEXTVAL('seq_movimiento_id'), 1, 'Retiro', -575.00, 1425.00, '2022-02-10'),
(NEXTVAL('seq_movimiento_id'), 2, 'Deposito', 600.00, 700.00, '2022-02-10'),
(NEXTVAL('seq_movimiento_id'), 3, 'Deposito', 150.00, 150.00, '2022-02-09'),
(NEXTVAL('seq_movimiento_id'), 4, 'Retiro', -540.00, 0.00, '2022-02-08');



commit;