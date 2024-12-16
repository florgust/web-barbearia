-- Inserção de um registro na tabela Pessoa
INSERT INTO Pessoa (Nome, Senha, Nascimento, Email, Telefone, Tipo)
VALUES 
('João Silva', '6bb4837eb74329105ee4568dda7dc67ed2ca2ad9', '1990-05-15', 'joao.silva@gmail.com', '123456789', 1), -- senha123
('Maria Oliveira', 'd033e22ae348aeb5660fc2140aec35850c4da997', '1985-08-20', 'maria.oliveira@gmail.com', '987654321', 2); -- senha456

-- Inserção de um registro na tabela Servicos
INSERT INTO Servicos (Titulo, Descricao, Preco, Tempo_Duracao)
VALUES 
('Corte de Cabelo', 'Serviço de corte de cabelo profissional para homens e crianças.', 30.00, '00:30:00'),
('Barba', 'Serviço completo de aparar e modelar a barba.', 20.00, '00:20:00'),
('Corte Infantil', 'Corte de cabelo especializado para crianças.', 25.00, '00:25:00'),
('Lavagem de Cabelo', 'Higienização capilar com produtos de alta qualidade.', 15.00, '00:15:00'),
('Hidratação Capilar', 'Tratamento hidratante para revitalizar os fios.', 50.00, '00:40:00');

-- Inserção de um registro na tabela Atendimento
INSERT INTO Atendimento (Pessoa_ID, Servico_ID, Valor, Data)
VALUES (1, 1, 30.00, '2024-12-15 10:00:00');
