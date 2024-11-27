CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS "resposta" (
id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
nota INT NOT NULL,
id_questao UUID NOT NULL,
id_formulario UUID NOT NULL

);

