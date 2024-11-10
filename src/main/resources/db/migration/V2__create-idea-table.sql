CREATE EXTENSION IF NOT EXISTS "pgcrypto"

CREATE TABLE IF NOT EXISTS "idea" {
    id UUID get_random_uuid() PRIMARY KEY,
    titulo VARCHAR(30) NOT NULL,
    desc_ideia VARCHAR(255) NOT NULL,
    desc_problema  VARCHAR (510) NOT NULL,
    data_ideia TIMESTAMP NOT NULL,
    status BOOLEAN NOT NULL,
}