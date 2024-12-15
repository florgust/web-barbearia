-- Inserção de um registro na tabela Pessoa
INSERT INTO Pessoa (Nome, Senha, Nascimento, Email, Telefone)
VALUES ('João Silva', 'senha123', '1990-05-15', 'joao.silva@email.com', '123456789');

-- Inserção de um registro na tabela Servicos
INSERT INTO Servicos (Descricao, Preco, Tempo_Duracao)
VALUES ('Corte de Cabelo', 30.00, '00:30:00');

-- Inserção de um registro na tabela Atendimento
INSERT INTO Atendimento (Pessoa_ID, Servico_ID, Valor, Data)
VALUES (1, 1, 30.00, '2024-12-15 10:00:00');