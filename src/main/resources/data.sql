-- ==========================================
-- DATA: Inserción de datos iniciales
-- Mínimo 10 registros de planetas
-- ==========================================

-- Limpiar datos existentes para evitar duplicados al reiniciar
TRUNCATE TABLE planeta RESTART IDENTITY;

-- Planetas del Sistema Solar + planetas ficticios/exoplanetas
INSERT INTO planeta (nombre, diametro, masa, distancia_sol, habitantes, tiene_lunas)
VALUES
    ('Mercurio',   4879.4,    3.3011e23,   57.9e6,    0,           false),
    ('Venus',      12104.0,   4.8675e24,   108.2e6,   0,           false),
    ('Tierra',     12742.0,   5.972e24,    149.6e6,   8100000000,  true),
    ('Marte',      6779.0,    6.4171e23,   227.9e6,   0,           true),
    ('Júpiter',    139820.0,  1.8982e27,   778.5e6,   0,           true),
    ('Saturno',    116460.0,  5.6834e26,   1432.0e6,  0,           true),
    ('Urano',      50724.0,   8.6810e25,   2867.0e6,  0,           true),
    ('Neptuno',    49244.0,   1.02413e26,  4515.0e6,  0,           true),
    ('Plutón',     2376.6,    1.303e22,    5906.4e6,  0,           true),
    ('Kepler-442b',23908.0,   8.20e25,     1.206e12,  0,           false),
    ('Proxima b',  14320.0,   7.60e24,     3.97e10,   0,           false),
    ('Gliese 667C',9540.0,    3.80e24,     6.84e10,   0,           false);
