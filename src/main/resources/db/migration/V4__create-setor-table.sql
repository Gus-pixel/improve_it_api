-- noinspection SqlNoDataSourceInspectionForFile

CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE setor {
    id_setor UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    nome_setor VARCHAR(20)
}