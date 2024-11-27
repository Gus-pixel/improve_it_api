-- noinspection SqlNoDataSourceInspectionForFile

CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS "usuario" (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    usuario VARCHAR(20) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    nome VARCHAR(50),
    cargo BOOLEAN NOT NULL,
    status BOOLEAN NOT NULL
);
