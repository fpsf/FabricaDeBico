CREATE TABLE Usuario
(
    id bigint,
    nome varchar(32),
    senha varchar(128),
    email varchar(64),
    telefone varchar(16)
);

CREATE TABLE Bico
(
	id bigint,
	titulo varchar(64),
	pagamento varchar(128),
	descricao varchar(512),
	usuario_id bigint
);

CREATE TABLE BicoUsuario
(
  id_usuario BIGINT NOT NULL,
  id_bico BIGINT NOT NULL,
  PRIMARY KEY (id_usuario, id_bico),
  CONSTRAINT usuario_fk FOREIGN KEY (id_usuario) REFERENCES Usuario(id)
  ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT bico_fk FOREIGN KEY (id_bico) REFERENCES Bico(id)
  ON DELETE CASCADE ON UPDATE RESTRICT
);

# Bcrypt (12 rounds) == admin
# $2y$12$j2RnQ1vFbOYqbTj/ez0aruzoOLiqQsOnDJafhhN4vqPYA6NsTDddu

INSERT INTO Usuario VALUES
(
	1,
	'admin',
	'$2a$12$j2RnQ1vFbOYqbTj/ez0aruzoOLiqQsOnDJafhhN4vqPYA6NsTDddu',
	'admin@admin.com',
	'4002-8922'
);

# Bcrypt (12 rounds) == guest
# $2y$12$9Q0veQHD1Qx4hyhb3N5T.e50YcAKDrXcIGwjnDjRE852RefDKVQbC

INSERT INTO Usuario VALUES
(
	2,
	'guest',
	'$2y$12$9Q0veQHD1Qx4hyhb3N5T.e50YcAKDrXcIGwjnDjRE852RefDKVQbC',
	'guest@guest.com',
	'1234-5678'
);
