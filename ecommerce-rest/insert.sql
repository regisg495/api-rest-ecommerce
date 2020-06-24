INSERT grupo (nome_grupo, detalhes_grupo)
VALUES ('Informática', 'Todos os equipamentos de informática');
INSERT grupo (nome_grupo, detalhes_grupo)
VALUES ('Eletroportáteis', 'Equipamentos eletroportáteis');

INSERT INTO subgrupo(id_grupo, nome_subgrupo, detalhes_subgrupo)
VALUES (1, 'Notebooks', NULL);
INSERT INTO subgrupo(id_grupo, nome_subgrupo, detalhes_subgrupo)
VALUES (1, 'PC All In One', NULL);

INSERT INTO subgrupo(id_grupo, nome_subgrupo, detalhes_subgrupo)
VALUES (2, 'Liquidificadores', NULL);
INSERT INTO subgrupo(id_grupo, nome_subgrupo, detalhes_subgrupo)
VALUES (2, 'Forno Elétrico', NULL);

INSERT INTO ficha_tecnica_campo(id_subgrupo, nome_campo_1, nome_campo_2, nome_campo_3, nome_campo_4,
nome_campo_5, nome_campo_6, nome_campo_7, nome_campo_8, nome_campo_9, nome_campo_10)
VALUES (1, 'Código de Barras', 'Fabricante', 'Voltagem 2', 'Cor', 'Garantia do Fornecedor',
        'Sistema Operacional', 'Memória Cachê', 'Memória RAM', 'Capacidade do HD', 'Processador');

INSERT INTO ficha_tecnica_campo(id_subgrupo, nome_campo_1, nome_campo_2, nome_campo_3, nome_campo_4,
nome_campo_5, nome_campo_6)
VALUES (2, 'Código de Barras', 'Fabricante', 'Caixas de Som', 'Conexões', 'Sistema Operacional', 'Capacidade do HD');


INSERT INTO produto(nome_produto, detalhes_produto, preco_produto, id_subgrupo)
VALUES ('Notebook Lenovo Ideapad S145 8ª Intel Core I5 8GB 1TB HD 15,6" W10 Prata', NULL, 2000.0, 1);
INSERT INTO produto(nome_produto, detalhes_produto, preco_produto, id_subgrupo)
VALUES ('Notebook Samsung Essentials E20 Intel Celeron 4GB 500GB LED HD 15,6 W10 Branco', NULL, 3500.0, 1);
INSERT INTO produto(nome_produto, detalhes_produto, preco_produto, id_subgrupo)
VALUES ('Notebook Acer Aspire A315-53-33AD Intel Core I3 8GB 1TB 15,6" Endless', NULL, 2500.99, 1);
INSERT INTO produto(nome_produto, detalhes_produto, preco_produto, id_subgrupo)
VALUES ('Notebook Essentials E30 Intel Core I3 4GB 1TB LED Full HD 15.6'''' W10 Cinza Titânio - Samsung', NULL, 1800.0, 1);

INSERT INTO produto(nome_produto, detalhes_produto, preco_produto, id_subgrupo)
VALUES ('Computador Desktop Completo Com Monitor Led Hdmi Intel Core I5 8gb Hd 500gb Com Caixas De Som Mouse E Teclado Easypc Standard Plus',
        NULL, 3000.0, 2);
INSERT INTO produto(nome_produto, detalhes_produto, preco_produto, id_subgrupo)
VALUES ('Computador Completo Easypc Standard Intel Core I5 3.40Ghz 8gb Hd 3tb Monitor 19.5" Hdmi Led', NULL, 3200.00, 2);
INSERT INTO produto(nome_produto, detalhes_produto, preco_produto, id_subgrupo)
VALUES ('Computador Easy PC Connect Intel Core i5 (Gráficos Intel HD) 8GB HD 2TB Monitor 19.5 LED HDMI', NULL, 3800.00, 2);

INSERT INTO produto(nome_produto, detalhes_produto, preco_produto, id_subgrupo)
VALUES ('Liquidificador Philips Walita ProBlend RI2137 Inox 2,4L 6 Lâminas 12 Velocidades', NULL, 300.0, 3);
INSERT INTO produto(nome_produto, detalhes_produto, preco_produto, id_subgrupo)
VALUES ('Liquidificador Philips Walita Problend 6 Lâminas Ri2134/91 700 W E 5 Velocidades', NULL, 350.0, 3);
INSERT INTO produto(nome_produto, detalhes_produto, preco_produto, id_subgrupo)
VALUES ('Liquidificador Oster Superchef 750w C/ Jarra De Vidro Preto', 'Liquidificador Top', 200.00, 3);
INSERT INTO produto(nome_produto, detalhes_produto, preco_produto, id_subgrupo)
VALUES ('Liquidificador Arno Power Max 3,1L 15 Velocidades Preto', 'Outro Liquidifcador excelente', 150.05, 3);

INSERT INTO produto(nome_produto, detalhes_produto, preco_produto, id_subgrupo)
VALUES ('Forno Elétrico de Bancada Gourmet Grill Branco 44 Litros - Fischer 110V', NULL, 800.99, 4);
INSERT INTO produto(nome_produto, detalhes_produto, preco_produto, id_subgrupo)
VALUES ('Forno Tostador Oster Com Capacidade Para 4 Fatias 10Litros Vermelho 127v', NULL, 900.50, 4);
INSERT INTO produto(nome_produto, detalhes_produto, preco_produto, id_subgrupo)
VALUES ('Forno Elétrico de Embutir Fischer 44L Inox 220V 26819-58805', 'Um dos melhores fornos da atualidade!', 1000.00, 4);


INSERT INTO ficha_tecnica_produto(id_produto, valor_campo_1, valor_campo_2, valor_campo_3, valor_campo_4,
valor_campo_5, valor_campo_6, valor_campo_7, valor_campo_8, valor_campo_9, valor_campo_10) VALUES
(1, '0193386403411', 'Lenovo', 'Bivolt', 'Preto', '12 meses', 'Windows', '4 MB', '8 GB', '1 TB', '8° Intel Core I5');

INSERT INTO ficha_tecnica_produto(id_produto, valor_campo_1, valor_campo_2, valor_campo_3, valor_campo_4,
valor_campo_5, valor_campo_6, valor_campo_7, valor_campo_8, valor_campo_9, valor_campo_10) VALUES
(2, '	124466988293', 'Samsumg', 'Bivolt', 'Cinza', 'Não aplica', 'Windows', '3 MB', '4 GB', '500 GB', 'Intel Celeron');

INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/1/1-0', 'jpg', 1);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/1/1-1', 'jpg', 1);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/1/1-2', 'jpg', 1);

INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/2/2-0', 'jpg', 2);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/2/2-1', 'jpg', 2);

INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/3/3-0', 'jpg', 3);

INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/4/4-0', 'jpg', 4);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/4/4-1', 'jpg', 4);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/4/4-2', 'jpg', 4);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/4/4-3', 'jpg', 4);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/4/4-4', 'jpg', 4);

INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/5/5-0', 'jpg', 5);

INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/6/6-0', 'jpg', 6);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/6/6-1', 'jpg', 6);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/6/6-2', 'jpg', 6);

INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/7/7-0', 'jpg', 7);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/7/7-1', 'jpg', 7);

INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/8/8-0', 'jpg', 8);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/8/8-1', 'jpg', 8);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/8/8-2', 'jpg', 8);

INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/9/9-0', 'png', 9);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/9/9-1', 'jpg', 9);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/9/9-2', 'jpg', 9);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/9/9-3', 'jpg', 9);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/9/9-4', 'jpg', 9);

INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/10/10-0', 'jpg', 10);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/10/10-1', 'jpg', 10);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/10/10-2', 'jpg', 10);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/10/10-3', 'jpg', 10);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/10/10-4', 'jpg', 10);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/10/10-5', 'jpg', 10);

INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/11/11-0', 'jpg', 11);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/11/11-1', 'jpg', 11);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/11/11-2', 'jpg', 11);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/11/11-3', 'jpg', 11);

INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/12/12-0', 'jpg', 12);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/12/12-1', 'jpg', 12);

INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/13/13-0', 'jpg', 13);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/13/13-1', 'jpg', 13);

INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/14/14-0', 'jpg', 14);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/14/14-1', 'jpg', 14);
INSERT INTO produto_imagem(url_imagem, tipo_imagem, id_produto)
VALUES ('upload/produtos/14/14-2', 'jpg', 14);

INSERT INTO endereco(tipo_endereco, nome_destinatario_endereco, numero_endereco, informacoes_referencia_endereco,
                     cep_endereco, logradouro_endereco, bairro_endereco, cidade_endereco, uf_endereco)
VALUES ('Residencial', 'Matheus Matarazzo', '344', 'Frente ao restaurante A', '96225000', NULL, NULL,
        'São José do Norte', 'RS');

INSERT INTO endereco(tipo_endereco, nome_destinatario_endereco, numero_endereco, informacoes_referencia_endereco,
                     cep_endereco, complemento_endereco, logradouro_endereco, bairro_endereco, cidade_endereco,
                     uf_endereco)
VALUES ('Residencial', 'Rafael Arteche', '43', 'Frente ao restaurante B', '01001000', 'lado ímpar', 'Praça da Sé', 'Sé',
        'São Paulo', 'SP');

INSERT INTO endereco(tipo_endereco, nome_destinatario_endereco, numero_endereco, informacoes_referencia_endereco,
                     cep_endereco, complemento_endereco, logradouro_endereco, bairro_endereco, cidade_endereco,
                     uf_endereco)
VALUES ('Apartamento', 'Adriana Souza', '210', 'Frente ao restaurante C', '01034903', '122', 'Rua Antônio de Godói',
        'Centro', 'São Paulo', 'SP');

INSERT INTO endereco(tipo_endereco, nome_destinatario_endereco, numero_endereco, informacoes_referencia_endereco,
                     cep_endereco, logradouro_endereco, bairro_endereco, cidade_endereco, uf_endereco)
VALUES ('Comercial', 'Tiago Moraes', '2', 'Frente ao restaurante D', '07159600', 'Rua Amarilis',
        'Parque Residencial Bambi', 'Guarulhos', 'SP');

INSERT INTO endereco(tipo_endereco, nome_destinatario_endereco, numero_endereco, informacoes_referencia_endereco,
                     cep_endereco, complemento_endereco, logradouro_endereco, bairro_endereco, cidade_endereco,
                     uf_endereco)
VALUES ('Outro', 'Fernando de Souza', '553', 'Frente ao restaurante E', '30110014', 'de 2552 a 3050 - lado par',
        'Avenida do Contorno', 'Santa Efigênia', 'Belo Horizonte', 'MG');

INSERT INTO endereco(tipo_endereco, nome_destinatario_endereco, numero_endereco, informacoes_referencia_endereco,
                     cep_endereco, complemento_endereco, logradouro_endereco, bairro_endereco, cidade_endereco,
                     uf_endereco)
VALUES ('Apartamento', 'Mikaela Alvarez', '200', 'Frente ao restaurante F', '50030911', '35', 'Praça Artur Oscar',
        'Recife', 'Recife', 'PE');

INSERT INTO endereco(tipo_endereco, nome_destinatario_endereco, numero_endereco, informacoes_referencia_endereco,
                     cep_endereco, logradouro_endereco, bairro_endereco, cidade_endereco, uf_endereco)
VALUES ('Residencial', 'Camila Alvarez', '255', 'Frente ao restaurante G', '88512530', 'Rua Antônio Caldas',
        'Santa Catarina', 'Lages', 'SC');

INSERT INTO endereco(tipo_endereco, nome_destinatario_endereco, numero_endereco, informacoes_referencia_endereco,
                     cep_endereco, logradouro_endereco, bairro_endereco, cidade_endereco, uf_endereco)
VALUES ('Comercial', 'Maurício Gaspar', '111', 'Frente ao restaurante H', '88512420', 'Rua Antônio Conselheiro',
        'Santa Catarina', 'Lages', 'SC');

INSERT INTO endereco(tipo_endereco, nome_destinatario_endereco, numero_endereco, informacoes_referencia_endereco,
                     cep_endereco, logradouro_endereco, bairro_endereco, cidade_endereco, uf_endereco)
VALUES ('Outro', 'Verônica Guimarães', '290', 'Frente ao restaurante I', '91170200', 'Rua dos Maias', 'Rubem Berta',
        'Porto Alegre', 'RS');

-- senha: 54321

INSERT INTO cliente(nome_cliente, email_cliente, senha_cliente, apelido_cliente, sexo_cliente, cpf_cliente,
                    data_nascimento_cliente, telefone_residencial_cliente, telefone_celular_cliente,
                    id_endereco_principal_cliente)
VALUES ('Julia Gonçalves', 'juliag@gmail.com', '$2y$12$PV/jso3yjYvdpYopZChraOdFPES1eRaAp73OOknSMhXTSZwLXzTP.',
        'Julinha Fofinha', 'F', '99999999912', '1993-09-01', '5341234444', '53999114444', 1);

INSERT INTO cliente(nome_cliente, email_cliente, senha_cliente, apelido_cliente, sexo_cliente, cpf_cliente,
                    data_nascimento_cliente, telefone_residencial_cliente, telefone_celular_cliente,
                    id_endereco_principal_cliente)
VALUES ('Tainara Alcantara', 'tainag@hotmail.com', '$2y$12$.6ApwF.r4VtWWhTyNjjXHeHDDufWZ0i9Ceg1zOHv0tvvpSQKktj.i',
        'Tainarinha', 'F', '99999999913', '1994-10-03', '5341234445', '53999114445', 2);

INSERT INTO cliente(nome_cliente, email_cliente, senha_cliente, apelido_cliente, sexo_cliente, cpf_cliente,
                    data_nascimento_cliente, telefone_residencial_cliente, telefone_celular_cliente,
                    id_endereco_principal_cliente)
VALUES ('Tiago Barroso', 'tihb@outlook.com', '$2y$12$fhozflyHV0y6vXMWeOzI2eoUdH3I8Nt3svKlu8gGdZsfDAthiVxoC',
        'Tiaguinho', 'M', '99999999914', '1983-01-01', '5341234446', '53999114446', 3);

INSERT INTO cliente(nome_cliente, email_cliente, senha_cliente, apelido_cliente, sexo_cliente, cpf_cliente,
                    data_nascimento_cliente, telefone_residencial_cliente, telefone_celular_cliente,
                    id_endereco_principal_cliente)
VALUES ('Tiago Moraes', 'tiagom@gmail.com', '$2y$12$2ZUqRPyq6/riAPZa9h5taeVe5jCGIOXjwD59TCuztZ9wHWTRJAJ96', 'Tiagão',
        'M', '99999999915', '1991-02-02', '5341234447', '53999114447', 4);

INSERT INTO cliente(nome_cliente, email_cliente, senha_cliente, apelido_cliente, sexo_cliente, cpf_cliente,
                    data_nascimento_cliente, telefone_residencial_cliente, telefone_celular_cliente,
                    id_endereco_principal_cliente)
VALUES ('Manuela de Souza', 'manu234@msn.com', '$2y$12$Qko0Xb1gCsoWL.FmCwcmWeBLv5TWvf/oN4R1rgaBibxsB8FaSaHDa',
        'Manuuuu', 'F', '99999999916', '1981-05-23', '5341234448', '53999114448', 5);

INSERT INTO cliente(nome_cliente, email_cliente, senha_cliente, apelido_cliente, sexo_cliente, cpf_cliente,
                    data_nascimento_cliente, telefone_residencial_cliente, telefone_celular_cliente,
                    id_endereco_principal_cliente)
VALUES ('Fernando de Souza', 'fdesouza@gmail.com', '$2y$12$Q14J9K6bvpHhf.tm5OORwOpdtP8jk4DgNXGzVpX8UkGsgFFRCf15S',
        'Nando', 'M', '99999999917', '1986-04-30', '5341234449', '53999114449', 5);

INSERT INTO cliente(nome_cliente, email_cliente, senha_cliente, apelido_cliente, sexo_cliente, cpf_cliente,
                    data_nascimento_cliente, telefone_residencial_cliente, telefone_celular_cliente,
                    id_endereco_principal_cliente)
VALUES ('Mikaela Alvarez', 'mika123@gmail.com', '$2y$12$qziRjP0SYIH3Ver6rwMJ5ebxrozqMDxbRogLiOkDU.FmxPGavqEo6', 'Mika',
        'F', '99999999918', '1980-03-22', '5341234450', '53999114450', 6);

INSERT INTO cliente_endereco(id_cliente, id_endereco)
VALUES (1, 1);
INSERT INTO cliente_endereco(id_cliente, id_endereco)
VALUES (2, 2);
INSERT INTO cliente_endereco(id_cliente, id_endereco)
VALUES (3, 3);
INSERT INTO cliente_endereco(id_cliente, id_endereco)
VALUES (4, 4);
INSERT INTO cliente_endereco(id_cliente, id_endereco)
VALUES (5, 5);
INSERT INTO cliente_endereco(id_cliente, id_endereco)
VALUES (6, 6);
INSERT INTO cliente_endereco(id_cliente, id_endereco)
VALUES (6, 7);
INSERT INTO cliente_endereco(id_cliente, id_endereco)
VALUES (5, 8);
INSERT INTO cliente_endereco(id_cliente, id_endereco)
VALUES (4, 9);

INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (5, 'Um produto top! Esse aconselho', 1, 1);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (3, 'O produto é bom mas...', 2, 1);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (1, 'Péssimo Produto', 3, 1);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (5, 'Valeu muito a pena!', 7, 2);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (5, NULL, 6, 1);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (3, NULL, 2, 2);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (5, 'O produto valeu muito a pena', 1, 2);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (1, 'Péssimo Produto!', 2, 3);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (1, 'Não vale 1 centavo', 4, 6);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (1, 'O pior produto do mundo', 2, 4);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (2, 'Não aconselho', 4, 2);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (4, 'Produto valeu muito, aconselho!', 3, 2);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (5, 'O melhor PC do mundo', 7, 1);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (1, 'Parece PC da Positivo', 3, 3);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (3, NULL, 4, 4);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (5, NULL, 3, 4);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (2, 'Não vale muito a pena', 5, 5);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (4, 'Um produto top! Esse aconselho', 5, 8);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (5, 'Excelente produto, minha mãe adorou!', 3, 14);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (2, 'Não curti muito.', 2, 14);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (1, 'Essa marca é muito ruim, não aconselho', 5, 14);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (3, 'Um produto mediano', 7, 7);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (1, 'Péssimo produto, um lixo!', 6, 8);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (4, 'Vale muito a pena, podem comprar!', 6, 7);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (1, 'Vou reclamar no reclameaqui. O produto é muito ruim', 3, 10);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (5, 'Valeu cada centavo gasto', 4, 10);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (2, 'Não aconselho, o custo benefício não vale', 1, 11);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (3, '+ ou -', 1, 12);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (5, 'Top das galaxias', 5, 13);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (4, 'Gostei muito', 2, 13);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (1, 'Ruim demais, vou processar vocês', 2, 10);
INSERT INTO produto_avaliacao(estrelas_avaliacao, comentario_avaliacao, id_cliente, id_produto)
VALUES (3, 'É bom, mas tem melhores', 6, 13);

-- senha: 12345

INSERT INTO usuario(nome_usuario, email_usuario, senha_usuario, cpf_usuario, data_nascimento_usuario,
                    telefone_residencial_usuario, telefone_celular_usuario)
VALUES ('Regis Guimarães', 'regisg495@gmail.com', '$2y$12$HBBiKGLPYHAVY83atqLwneq/BPixK.Y0Mmmg4l2IygxYK9leiBwP6',
        '03322767086', '1992-06-26', '5330351823', '5397139922');

INSERT INTO usuario(nome_usuario, email_usuario, senha_usuario, cpf_usuario, data_nascimento_usuario,
                    telefone_residencial_usuario, telefone_celular_usuario)
VALUES ('Camila Oliveira', 'camila.oliveira350@outlook.com',
        '$2y$12$eJJkptoA6ay.UMRH0W5M2eRl0Bmcdykf8CiyiWI0R.HWZje49utpq', '02225567796', '1997-11-12', '5332381111',
        '53981000011');

INSERT INTO usuario(nome_usuario, email_usuario, senha_usuario, cpf_usuario, data_nascimento_usuario,
                    telefone_residencial_usuario, telefone_celular_usuario)
VALUES ('Matheus Aguiar', 'matheus91@gmail.com', '$2y$12$afHOLCkkymfyupv9gMzGc.gcEkwQS/g7RYa7Ir.0yxIMWH9Dv9IPG',
        '09123455511', '1991-09-15', '5332345666', '53991111111');

INSERT INTO usuario(nome_usuario, email_usuario, senha_usuario, cpf_usuario, data_nascimento_usuario,
                    telefone_residencial_usuario, telefone_celular_usuario)
VALUES ('Carolina Ramirez', 'carol.ramirez@gmail.com', '$2y$12$f11tQDk.p7HEBl4yoAIbleUygJC./s/xEtK8AOdI.gatFhiFviwBe',
        '06523488811', '1990-02-10', '5330000000', '53990000000');

INSERT INTO permissao(nome_permissao)
VALUES ('ADMIN');
INSERT INTO permissao(nome_permissao)
VALUES ('DBA');
INSERT INTO permissao(nome_permissao)
VALUES ('USER');

INSERT INTO usuario_permissao(id_usuario, nome_permissao)
VALUES (1, 'ADMIN');
INSERT INTO usuario_permissao(id_usuario, nome_permissao)
VALUES (2, 'DBA');
INSERT INTO usuario_permissao(id_usuario, nome_permissao)
VALUES (3, 'USER');
INSERT INTO usuario_permissao(id_usuario, nome_permissao)
VALUES (4, 'ADMIN');

INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2001-01-01 01:02:00', 1);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2004-01-21 07:03:50', 2);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2006-02-28 23:55:40', 3);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2007-11-30 21:22:30', 4);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2011-12-25 11:32:06', 5);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2012-02-03 06:13:02', 6);

INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2014-12-21 22:22:04', 1);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2013-09-25 19:22:06', 2);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2014-05-21 18:41:40', 3);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2015-04-06 15:12:30', 4);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2016-02-12 11:13:02', 5);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2008-11-19 02:47:01', 6);

INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2020-03-21 04:04:11', 1);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2020-01-15 23:22:46', 2);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2019-09-24 14:45:39', 3);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2018-11-26 13:44:35', 4);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2016-02-08 16:49:22', 5);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2020-12-24 06:59:59', 6);

INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2019-08-11 08:02:59', 1);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2020-06-19 01:33:44', 2);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2014-04-23 23:55:04', 3);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2008-01-22 22:54:01', 4);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2009-12-17 12:50:03', 5);
INSERT INTO pedido(data_envio_pedido, id_cliente) VALUES ('2011-02-18 05:50:11', 6);

INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (1, 1, 1);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (2, 6, 2);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (3, 5, 3);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (4, 4, 1);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (5, 3, 1);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (6, 14, 1);

INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (7, 12, 2);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (8, 11, 3);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (9, 7, 4);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (10, 8, 1);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (11, 5, 3);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (12, 9, 6);

INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (13, 5, 2);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (14, 6, 3);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (15, 3, 1);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (16, 2, 1);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (17, 1, 6);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (18, 9, 4);

INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (19, 14, 3);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (20, 13, 1);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (21, 13, 1);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (22, 11, 2);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (23, 2, 3);
INSERT INTO item_pedido(id_pedido, id_produto, quantidade_produto) VALUES (24, 1, 2);

UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 1;
UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 2;
UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 3;
UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 5;
UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 7;
UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 8;

UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 10;
UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 11;
UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 12;
UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 13;
UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 14;

UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 17;
UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 19;
UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 20;
UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 21;
UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 22;
UPDATE pedido SET pago_pedido = 1 WHERE id_pedido = 24;