CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS "formulario" {
    id UUID DEFAULT get_random_uuid() PRIMARY KEY,
    titulo VARCHAR(30) NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    status BOOLEAN NOT NULL,
    id_setor UUID,
    FOREIGN KEY (id_setor) REFERENCES setor(id)
}