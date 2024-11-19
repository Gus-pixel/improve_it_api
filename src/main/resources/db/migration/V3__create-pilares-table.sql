CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS "pilar" (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    nome_pilar VARCHAR(20) NOT NULL,
    status BOOLEAN NOT NULL
);
