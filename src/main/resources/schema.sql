-- ==========================================
-- SCHEMA: Creación de la tabla planeta
-- Base de datos: planetas_db
-- ==========================================

CREATE TABLE IF NOT EXISTS planeta (
    id             SERIAL PRIMARY KEY,
    nombre         VARCHAR(80)       NOT NULL,
    diametro       DOUBLE PRECISION  NOT NULL,
    masa           DOUBLE PRECISION  NOT NULL,
    distancia_sol  DOUBLE PRECISION  NOT NULL,
    habitantes     BIGINT            NOT NULL,
    tiene_lunas    BOOLEAN           NOT NULL
);
