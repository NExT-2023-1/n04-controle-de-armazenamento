
INSERT INTO Usuario (nome, cpf, data_nasc, endereco, plano, qtd_arquivos_utilizados)
VALUES
    ('José Luanderson', '01457896541', '1989-12-30', 'AV. Epitácio Pessoa, n 210, João Pessoa-PB', 'B', 2),
    ('Matheus Aminadabe', '12501789523', '1991-02-10', 'Av. Agamenon Magalhães, n 586, Recife-PE', 'A', 5),
    ('Adriano Umbelino', '05478987462', '1979-10-08', 'Av. Augusto Freire, n 800, Manaus-AM', 'I', 0),
    ('Pedro Vinícius', '01478562104', '1992-08-27', 'Rua Ariano Suassuna, n 405, Curitiba-PR', 'B', 3);


INSERT INTO Arquivos (tamanho, nome, usuario_id)
VALUES
    (512, 'relatório.txt', 1),
    (4096, 'planta baixa.jpg', 2),
    (1024, 'orçamento.xlsx', 3),
    (2048, 'tese.ppt', 4);
