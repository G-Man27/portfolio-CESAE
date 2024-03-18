SELECT *
FROM Artigo

SELECT idArtigo, nome, preco
FROM Artigo
WHERE preco<5

SELECT nome, preco
FROM Artigo
WHERE preco>=2 AND preco<=10

SELECT nome, preco
FROM Artigo
WHERE preco BETWEEN 2 AND 10

SELECT nome, preco
FROM Artigo
WHERE preco<5 OR preco>10

SELECT nome, preco
FROM Artigo
WHERE preco NOT BETWEEN 5 AND 10

SELECT nome, preco
FROM Artigo
WHERE preco IN (10,100)

SELECT *
FROM Artigo
WHERE nome LIKE 'M%'

SELECT * FROM Artigo
ORDER BY preco ASC

SELECT * FROM Artigo
ORDER BY preco DESC

SELECT * FROM Artigo
WHERE preco >500
ORDER BY preco DESC

SELECT COUNT(nome) AS TotalArtigos
FROM Artigo

SELECT SUM(preco) AS SomaPV
FROM Artigo

SELECT AVG(preco) AS MediaPV
FROM Artigo

SELECT MAX(preco) AS MaximoPV
FROM Artigo

SELECT MIN(preco) AS MinimoPV
FROM Artigo

SELECT cidade
FROM Cliente

SELECT DISTINCT cidade
FROM Cliente

SELECT Cliente.nome, Venda.data, Artigo.nome
FROM Artigo, Cliente, Venda, LinhaVenda
WHERE Cliente.idCliente = Venda.cliente AND
Venda.idVenda = LinhaVenda.venda AND
LinhaVenda.artigo = Artigo.idArtigo

SELECT c.nome, v.data, a.nome
FROM Artigo a, Cliente c, Venda v, LinhaVenda l
WHERE c.idCliente = v.cliente AND
v.idVenda = l.venda AND
l.artigo = a.idArtigo

SELECT c.nome, v.data
FROM Cliente c
INNER JOIN Venda v ON c.idCliente = v.cliente

SELECT c.nome, v.data
FROM Cliente c
LEFT JOIN Venda v ON c.idCliente = v.cliente

SELECT c.nome, v.data, SUM(l.quantidade*a.preco) AS Total
FROM Artigo a, Cliente c, Venda v, LinhaVenda l
WHERE c.idCliente = v.cliente AND v.idVenda = l.venda AND l.artigo = a.idArtigo
GROUP BY c.nome, v.data

SELECT TOP(1) c.nome, v.data
FROM Artigo a, Cliente c, Venda v, LinhaVenda l
WHERE c.idCliente = v.cliente AND v.idVenda = l.venda AND l.artigo = a.idArtigo
ORDER BY v.data DESC

SELECT c.codPostal, COUNT(c.codPostal)
FROM Cliente c
GROUP BY c.codPostal
HAVING COUNT(c.codPostal) > 2;

SELECT a.categoria, COUNT(a.nome) AS TotalArtigos
FROM Artigo a
GROUP BY a.categoria

SELECT c.nome
FROM Cliente c
WHERE c.idCliente NOT IN (SELECT cliente FROM Venda)

SELECT nome, (SELECT COUNT(*) FROM Venda WHERE Venda.cliente = Cliente.idCliente)
FROM Cliente

SELECT nome
FROM Artigo
WHERE preco >= ALL (SELECT preco FROM Artigo)

SELECT nome
FROM Artigo
WHERE preco > ANY (SELECT preco FROM Artigo)