-- noinspection SqlNoDataSourceInspectionForFile

CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS "user" (
    id UUID gen_random_uuid() PRIMARY KEY,
    username VARCHAR(20) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    nome VARCHAR(20),
    email VARCHAR(50) NOT NULL,
    status BOOLEAN NOT NULL
);
