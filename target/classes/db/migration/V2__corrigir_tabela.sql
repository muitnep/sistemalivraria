ALTER TABLE emprestimo
    DROP CONSTRAINT fk_cliente;

ALTER TABLE emprestimo
    DROP CONSTRAINT fk_livro;

CREATE TABLE livrodto
(
    autor_id     BIGINT NOT NULL,
    titulo       VARCHAR(255),
    categoria_id BIGINT,
    preco        DOUBLE PRECISION,
    CONSTRAINT pk_livrodto PRIMARY KEY (autor_id)
);

ALTER TABLE livro
    ADD data_atualizacao TIMESTAMP WITHOUT TIME ZONE;

ALTER TABLE livro
    ADD id_autor BIGINT;

ALTER TABLE livro
    ALTER COLUMN id_autor SET NOT NULL;

ALTER TABLE emprestimo
    ADD id_cliente BIGINT;

ALTER TABLE emprestimo
    ADD id_livro BIGINT;

ALTER TABLE emprestimo
    ADD nome_usuario VARCHAR(255);

ALTER TABLE emprestimo
    ALTER COLUMN id_cliente SET NOT NULL;

ALTER TABLE emprestimo
    ALTER COLUMN id_livro SET NOT NULL;

ALTER TABLE emprestimo
    ADD CONSTRAINT uc_emprestimo_id_livro UNIQUE (id_livro);

ALTER TABLE emprestimo
    ADD CONSTRAINT FK_EMPRESTIMO_ON_ID_CLIENTE FOREIGN KEY (id_cliente) REFERENCES cliente (id);

ALTER TABLE emprestimo
    ADD CONSTRAINT FK_EMPRESTIMO_ON_ID_LIVRO FOREIGN KEY (id_livro) REFERENCES livro (id);

ALTER TABLE livro
    ADD CONSTRAINT FK_LIVRO_ON_ID_AUTOR FOREIGN KEY (id_autor) REFERENCES autor (id);

ALTER TABLE emprestimo
    DROP COLUMN cliente_id;

ALTER TABLE emprestimo
    DROP COLUMN livro_id;

ALTER TABLE autor
    DROP COLUMN data_nascimento;

ALTER TABLE autor
    ADD data_nascimento TIMESTAMP WITHOUT TIME ZONE;

ALTER TABLE cliente
    ALTER COLUMN email DROP NOT NULL;

ALTER TABLE autor
    ALTER COLUMN nome DROP NOT NULL;

ALTER TABLE cliente
    ALTER COLUMN nome DROP NOT NULL;

ALTER TABLE livro
    ALTER COLUMN titulo DROP NOT NULL;