-- Criação da tabela Pessoa
CREATE TABLE Pessoa (
    ID SERIAL PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Senha VARCHAR(255) NOT NULL,
    Nascimento DATE NOT NULL,
    Email VARCHAR(150) UNIQUE NOT NULL,
    Telefone VARCHAR(15) NOT NULL
);

-- Criação da tabela Servicos
CREATE TABLE Servicos (
    ID SERIAL PRIMARY KEY,
    Descricao VARCHAR(100) NOT NULL,
    Preco NUMERIC(10, 2) NOT NULL,
    Tempo_Duracao INTERVAL NOT NULL
);

-- Criação da tabela Atendimento
CREATE TABLE Atendimento (
    ID SERIAL PRIMARY KEY,
    Pessoa_ID INT NOT NULL,
    Servico_ID INT NOT NULL,
    Valor NUMERIC(10, 2) NOT NULL,
    Data TIMESTAMP NOT NULL,
    FOREIGN KEY (Pessoa_ID) REFERENCES Pessoa(ID) ON DELETE CASCADE,
    FOREIGN KEY (Servico_ID) REFERENCES Servicos(ID) ON DELETE CASCADE
);