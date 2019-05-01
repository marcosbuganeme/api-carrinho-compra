INSERT INTO cliente(id, nome, email, pontuacao, documento) VALUES 
(1, 'marcos olavo', 'marcos.after@gmail.com', 0, '03287476106');

INSERT INTO categoria(id, nome) VALUES 
(1, 'livros'),
(2, 'eletrônicos'),
(3, 'games'),
(4, 'informâtica e tablets'),
(5, 'tv, áudio e home theater'),
(6, 'filmes, séries e músicas'),
(7, 'eletrodomésticos');

INSERT INTO produto(id, descricao, preco) VALUES 
(1, 'mochileiro das galáxias vol. 1', 35.40),
(2, 'geladeira electrolux 337L inox 2 portas frost free', 2645.11),
(3, 'teclado wireless microsoft', 155.00),
(4, 'mouse naga razer', 333.00),
(5, 'caixa de som jbl 40W', 220.20),
(6, 'tv samsung 49 4k', 2432.06),
(7, 'god of wars 4', 275.00),
(8, 'fifa 2020', 244.05);

INSERT INTO produto_categoria(id_produto, id_categoria) VALUES 
(1, 1),
(2, 7),
(3, 2),
(4, 2),
(5, 2),
(6, 5),
(7, 3),
(8, 3);