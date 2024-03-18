insert into Cliente (nome, cidade, codPostal, CC) values
('Ana', 'Maia', 4567, 123),
('Bruno', 'Porto', 4200, 456),
('Miguel', 'Porto', 4200, 789),
('Maria', 'Maia', 4567, 234),
('Joana', 'Maia', 4567, 678);
insert into Artigo (nome, preco, categoria) values
('Martelo', 5.5, 'Ferramentas'),
('Parafuso', 0.5, 'Ferramentas'),
('Prego', 0.2, 'Ferramentas'),
('Lampada', 1.5, 'Electricidade'),
('Tripla', 5.5, 'Electricidade');
insert into Venda (cliente, data, desconto) values
(1, '2021-03-29', 0.05),
(1, '2021-03-31', 0.20),
(2, '2021-03-29', 0.5),
(4, '2021-03-29', 0.5);
insert into LinhaVenda (venda, artigo, quantidade) values
(1, 1, 2),
(1, 3, 10),
(2, 2, 20),
(3, 3, 100),
(4, 1, 5);