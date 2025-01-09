-- Criar um schema
CREATE SCHEMA sistemalivraria;

-- Criar um usuário com senha
CREATE USER usuario_livraria WITH PASSWORD 'EaGb%W6Q19-i"x$`';

-- Conceder privilégios ao esquema
GRANT ALL PRIVILEGES ON SCHEMA sistemalivraria TO usuario_livraria;

-- Criar tabelas
CREATE TABLE autor (
                       id BIGSERIAL PRIMARY KEY,
                       nome VARCHAR(255) NOT NULL,
                       data_nascimento DATE NULL
);

CREATE TABLE cliente (
                         id BIGSERIAL PRIMARY KEY,
                         nome VARCHAR(255) NOT NULL,
                         data_nascimento DATE NULL,
                         email VARCHAR(255) NOT NULL
);

CREATE TABLE livro (
                       id BIGSERIAL PRIMARY KEY,
                       titulo VARCHAR(255) NOT NULL,
                       disponivel BOOLEAN DEFAULT TRUE,
                       data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE emprestimo (
                            id BIGSERIAL PRIMARY KEY,
                            data_emprestimo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            data_devolucao TIMESTAMP NULL,
                            cliente_id BIGINT NOT NULL,
                            livro_id BIGINT NOT NULL,
                            CONSTRAINT fk_cliente FOREIGN KEY(cliente_id) REFERENCES cliente(id),
                            CONSTRAINT fk_livro FOREIGN KEY(livro_id) REFERENCES livro(id)
);

-- Inserir dados na tabela autor
INSERT INTO autor (nome, data_nascimento)
VALUES
    ('J.R.R. Tolkien', '1892-01-03'),
    ('J.K. Rowling', '1965-07-31'),
    ('George R.R. Martin', '1948-09-20');