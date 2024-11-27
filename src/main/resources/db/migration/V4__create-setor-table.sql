-- noinspection SqlNoDataSourceInspectionForFile

CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE setor (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    nome VARCHAR(20),
    status BOOLEAN
);
