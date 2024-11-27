ALTER TABLE usuario
ADD COLUMN id_setor UUID;

ALTER TABLE usuario
ADD CONSTRAINT fk_usuario_setor
FOREIGN KEY (id_setor)
REFERENCES setor (id);