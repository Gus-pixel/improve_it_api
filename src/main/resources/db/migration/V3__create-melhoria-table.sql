CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE "melhoria" (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    desc_problema VARCHAR(255) NOT NULL,
    desc_melhoria VARCHAR(255) NOT NULL,
    data TIMESTAMP NOT NULL,
    status BOOLEAN NOT NULL,
    aprovacao BOOLEAN NOT NULL,
    id_usuario UUID,
    id_pilar UUID,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_pilar) REFERENCES pilar(id)
);

