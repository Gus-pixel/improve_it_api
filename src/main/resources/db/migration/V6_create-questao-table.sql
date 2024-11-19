CREATE EXTENSION IF NOT EXISTS "pgcrypto"

CREATE TABLE IF NOT EXISTS "questao" {
    id UUID DEFAULT get_random_uuid() PRIMARY KEY,
    texto_pergunta VARCHAR(255) NOT NULL,
    nota integer NOT NULL,
    status BOOLEAN NOT NULL,
    id_formulario UUID,
    FOREIGN KEY (id_formulario) REFERENCES formulario(id),

    }