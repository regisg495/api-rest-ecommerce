DROP DATABASE IF EXISTS ecommerce_rest;

CREATE DATABASE IF NOT EXISTS ecommerce_rest CHARACTER SET UTF8;

USE ecommerce_rest;

DROP TABLE IF EXISTS grupo;

CREATE TABLE IF NOT EXISTS grupo
(
  id_grupo               SMALLINT AUTO_INCREMENT NOT NULL,
  data_atualizacao_grupo DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  nome_grupo             VARCHAR(200)            NOT NULL UNIQUE,
  detalhes_grupo         TEXT     DEFAULT NULL,
  CONSTRAINT grupoPK PRIMARY KEY (id_grupo)
);

DROP TABLE IF EXISTS subgrupo;


CREATE TABLE IF NOT EXISTS subgrupo
(
  id_subgrupo               SMALLINT AUTO_INCREMENT NOT NULL,
  data_atualizacao_subgrupo DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  nome_subgrupo             VARCHAR(200)            NOT NULL UNIQUE,
  detalhes_subgrupo         TEXT     DEFAULT NULL,
  id_grupo                  SMALLINT                NOT NULL,
  CONSTRAINT subgrupoPK PRIMARY KEY (id_subgrupo),
  CONSTRAINT subgrupo_grupoFK FOREIGN KEY (id_grupo) REFERENCES grupo (id_grupo) ON UPDATE CASCADE ON DELETE RESTRICT
);

DROP TABLE IF EXISTS produto;

CREATE TABLE IF NOT EXISTS produto
(
  id_produto               BIGINT AUTO_INCREMENT NOT NULL,
  data_atualizacao_produto DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  nome_produto             VARCHAR(200)          NOT NULL UNIQUE,
  detalhes_produto         TEXT     DEFAULT NULL,
  preco_produto            DECIMAL(11, 2)        NOT NULL,
  id_subgrupo              SMALLINT              NOT NULL,
  CONSTRAINT produtoPK PRIMARY KEY (id_produto),
  CONSTRAINT produto_subgrupoFK FOREIGN KEY (id_subgrupo) REFERENCES subgrupo (id_subgrupo)
    ON UPDATE CASCADE ON DELETE RESTRICT
);

DROP TABLE IF EXISTS produto_imagem;

CREATE TABLE IF NOT EXISTS produto_imagem
(
  url_imagem              VARCHAR(200) NOT NULL UNIQUE,
  tipo_imagem             VARCHAR(10)  NOT NULL,
  id_produto              BIGINT       NOT NULL,
  data_atualizacao_imagem DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT produto_imagemPK PRIMARY KEY (url_imagem),
  CONSTRAINT produto_imagem_produtoFK FOREIGN KEY (id_produto) REFERENCES produto (id_produto)
    ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS permissao;

CREATE TABLE IF NOT EXISTS permissao
(
  nome_permissao VARCHAR(40),
  CONSTRAINT permissaoPK PRIMARY KEY (nome_permissao)
);

DROP TABLE IF EXISTS usuario;

CREATE TABLE IF NOT EXISTS usuario
(
  id_usuario                   BIGINT AUTO_INCREMENT NOT NULL,
  nome_usuario                 VARCHAR(200)          NOT NULL,
  email_usuario                VARCHAR(50)           NOT NULL UNIQUE,
  senha_usuario                VARCHAR(255)          NOT NULL,
  cpf_usuario                  CHAR(11)              NOT NULL UNIQUE,
  data_nascimento_usuario      DATE            DEFAULT NULL,
  telefone_residencial_usuario CHAR(10) UNIQUE DEFAULT NULL,
  telefone_celular_usuario     CHAR(11) UNIQUE DEFAULT NULL,
  data_atualizacao_usuario     DATETIME        DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  esta_ativo_usuario           BOOLEAN         DEFAULT TRUE,
  CONSTRAINT usuarioPK PRIMARY KEY (id_usuario)
);

DROP TABLE IF EXISTS usuario_permissao;

CREATE TABLE IF NOT EXISTS usuario_permissao
(
  id_usuario     BIGINT      NOT NULL,
  nome_permissao VARCHAR(40) NOT NULL,
  CONSTRAINT usuario_permissaoPK PRIMARY KEY (id_usuario, nome_permissao),
  CONSTRAINT usuario_permissao_usuarioFK FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
    ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT usuario_permissao_permissaoFK FOREIGN KEY (nome_permissao) REFERENCES permissao (nome_permissao)
    ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS endereco;

CREATE TABLE IF NOT EXISTS endereco
(
  id_endereco                     BIGINT AUTO_INCREMENT NOT NULL,
  tipo_endereco                   VARCHAR(30)           NOT NULL,
  nome_destinatario_endereco      VARCHAR(200)          NOT NULL,
  numero_endereco                 VARCHAR(5)            NOT NULL,
  complemento_endereco            VARCHAR(50)  DEFAULT NULL,
  informacoes_referencia_endereco TEXT                  NOT NULL,
  cep_endereco                    CHAR(8)               NOT NULL,
  logradouro_endereco             VARCHAR(200) DEFAULT NULL,
  bairro_endereco                 VARCHAR(40)  DEFAULT NULL,
  cidade_endereco                 VARCHAR(40)           NOT NULL,
  uf_endereco                     CHAR(2)               NOT NULL,
  CONSTRAINT enderecoPK PRIMARY KEY (id_endereco)
);


DROP TABLE IF EXISTS cliente;

CREATE TABLE IF NOT EXISTS cliente
(
  id_cliente                    BIGINT AUTO_INCREMENT NOT NULL,
  nome_cliente                  VARCHAR(200)          NOT NULL,
  email_cliente                 VARCHAR(50)           NOT NULL UNIQUE,
  senha_cliente                 VARCHAR(255)          NOT NULL,
  apelido_cliente               VARCHAR(50)     DEFAULT NULL,
  sexo_cliente                  CHAR(1)         DEFAULT NULL,
  cpf_cliente                   CHAR(11)              NOT NULL UNIQUE,
  data_nascimento_cliente       DATE            DEFAULT NULL,
  telefone_residencial_cliente  CHAR(10) UNIQUE DEFAULT NULL,
  telefone_celular_cliente      CHAR(11) UNIQUE DEFAULT NULL,
  data_atualizacao_cliente      DATETIME        DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  esta_ativo_cliente            BOOLEAN         DEFAULT TRUE,
  id_endereco_principal_cliente BIGINT          DEFAULT NULL,
  CONSTRAINT clientePK PRIMARY KEY (id_cliente),
  CONSTRAINT enderecoFK FOREIGN KEY (id_endereco_principal_cliente) REFERENCES endereco (id_endereco)
    ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS cliente_endereco;

CREATE TABLE IF NOT EXISTS cliente_endereco
(
  id_cliente  BIGINT NOT NULL,
  id_endereco BIGINT NOT NULL,
  CONSTRAINT cliente_enderecoPK PRIMARY KEY (id_cliente, id_endereco),
  CONSTRAINT cliente_endereco_clienteFK FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
    ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT cliente_endereco_enderecoFK FOREIGN KEY (id_endereco) REFERENCES endereco (id_endereco)
    ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS produto_avaliacao;

CREATE TABLE IF NOT EXISTS produto_avaliacao
(
  data_avaliacao       TIMESTAMP DEFAULT NOW(),
  estrelas_avaliacao   TINYINT NOT NULL,
  comentario_avaliacao TEXT      DEFAULT NULL,
  id_cliente           BIGINT  NOT NULL,
  id_produto           BIGINT  NOT NULL,
  CONSTRAINT produto_avaliacaoPK PRIMARY KEY (id_cliente, id_produto),
  CONSTRAINT produto_avaliacao_clienteFK FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
    ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT produto_avaliacao_produtoFK FOREIGN KEY (id_produto) REFERENCES produto (id_produto)
    ON UPDATE CASCADE ON DELETE CASCADE
);

DROP TABLE IF EXISTS ficha_tecnica_campo;

CREATE TABLE IF NOT EXISTS ficha_tecnica_campo
(
  id_subgrupo   SMALLINT NOT NULL,
  nome_campo_1  VARCHAR(200) DEFAULT 'Campo vazio',
  nome_campo_2  VARCHAR(200) DEFAULT 'Campo vazio',
  nome_campo_3  VARCHAR(200) DEFAULT 'Campo vazio',
  nome_campo_4  VARCHAR(200) DEFAULT 'Campo vazio',
  nome_campo_5  VARCHAR(200) DEFAULT 'Campo vazio',
  nome_campo_6  VARCHAR(200) DEFAULT 'Campo vazio',
  nome_campo_7  VARCHAR(200) DEFAULT 'Campo vazio',
  nome_campo_8  VARCHAR(200) DEFAULT 'Campo vazio',
  nome_campo_9  VARCHAR(200) DEFAULT 'Campo vazio',
  nome_campo_10 VARCHAR(200) DEFAULT 'Campo vazio',
  CONSTRAINT ficha_tecnica_moldePK PRIMARY KEY (id_subgrupo),
  CONSTRAINT subgrupoFK FOREIGN KEY (id_subgrupo) REFERENCES subgrupo (id_subgrupo)
    ON UPDATE CASCADE ON DELETE RESTRICT
);

DROP TABLE IF EXISTS ficha_tecnica_produto;

CREATE TABLE IF NOT EXISTS ficha_tecnica_produto
(
  id_produto     BIGINT NOT NULL,
  valor_campo_1  TEXT DEFAULT NULL,
  valor_campo_2  TEXT DEFAULT NULL,
  valor_campo_3  TEXT DEFAULT NULL,
  valor_campo_4  TEXT DEFAULT NULL,
  valor_campo_5  TEXT DEFAULT NULL,
  valor_campo_6  TEXT DEFAULT NULL,
  valor_campo_7  TEXT DEFAULT NULL,
  valor_campo_8  TEXT DEFAULT NULL,
  valor_campo_9  TEXT DEFAULT NULL,
  valor_campo_10 TEXT DEFAULT NULL,
  CONSTRAINT ficha_tecnica_produtoPK PRIMARY KEY (id_produto),
  CONSTRAINT ficha_tecnica_idprodutoFK FOREIGN KEY (id_produto) REFERENCES produto (id_produto)
    ON UPDATE CASCADE ON DELETE RESTRICT
);

DROP TABLE IF EXISTS pedido;

CREATE TABLE IF NOT EXISTS pedido
(
  id_pedido         BIGINT AUTO_INCREMENT NOT NULL,
  data_pedido       TIMESTAMP DEFAULT NOW(),
  data_envio_pedido TIMESTAMP             NOT NULL,
  id_cliente        BIGINT                NOT NULL,
  total_pedido      DECIMAL(11, 2),
  pago_pedido       BOOLEAN   DEFAULT FALSE,
  CONSTRAINT pedidoPK PRIMARY KEY (id_pedido),
  CONSTRAINT pedido_clienteFK FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
    ON UPDATE CASCADE
);


DROP TABLE IF EXISTS item_pedido;

CREATE TABLE IF NOT EXISTS item_pedido
(
  id_pedido          BIGINT NOT NULL,
  id_produto         BIGINT NOT NULL,
  quantidade_produto INT    NOT NULL,
  CONSTRAINT item_pedidoPK PRIMARY KEY (id_pedido, id_produto),
  CONSTRAINT item_pedido_idpedidoFK FOREIGN KEY (id_pedido) REFERENCES pedido (id_pedido)
    ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT item_pedido_clienteFK FOREIGN KEY (id_produto) REFERENCES produto (id_produto)
    ON UPDATE CASCADE ON DELETE RESTRICT
);

DROP TRIGGER IF EXISTS update_total_pedido;

DELIMITER $$
CREATE TRIGGER update_total_pedido
  AFTER INSERT
  ON item_pedido
  FOR EACH ROW
BEGIN
  UPDATE pedido
  SET total_pedido = (IFNULL(total_pedido, 0) + (NEW.quantidade_produto *
                                                 (SELECT produto.preco_produto
                                                  FROM produto
                                                  WHERE produto.id_produto = NEW.id_produto)))
  WHERE pedido.id_pedido = NEW.id_pedido;
END $$
DELIMITER ;


DROP TABLE IF EXISTS venda;

CREATE TABLE IF NOT EXISTS venda
(
  id_venda          BIGINT    NOT NULL,
  data_venda        TIMESTAMP NOT NULL,
  data_envio_pedido TIMESTAMP NOT NULL,
  id_cliente        BIGINT    NOT NULL,
  total_venda       DECIMAL(11, 2),
  CONSTRAINT vendaPK PRIMARY KEY (id_venda),
  CONSTRAINT venda_clienteFK FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
    ON UPDATE CASCADE ON DELETE RESTRICT
);

DROP TABLE IF EXISTS item_venda;

CREATE TABLE IF NOT EXISTS item_venda
(
  id_venda           BIGINT NOT NULL,
  id_produto         BIGINT NOT NULL,
  quantidade_produto INT    NOT NULL,
  CONSTRAINT item_vendaPK PRIMARY KEY (id_venda, id_produto),
  CONSTRAINT item_venda_idvendaFK FOREIGN KEY (id_venda) REFERENCES venda (id_venda)
    ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT item_venda_produtoFK FOREIGN KEY (id_produto) REFERENCES produto (id_produto)
    ON UPDATE CASCADE ON DELETE RESTRICT
);


DROP TRIGGER IF EXISTS venda_completa;

DELIMITER $$
CREATE TRIGGER venda_completa
  AFTER UPDATE
  ON pedido
  FOR EACH ROW
BEGIN
  DECLARE done INT DEFAULT FALSE;
  DECLARE pago_pedido INT;
  DECLARE idv BIGINT;
  DECLARE idp BIGINT;
  DECLARE qp INT;
  DECLARE cur CURSOR FOR SELECT i.id_pedido, i.id_produto, i.quantidade_produto
                         FROM item_pedido i
                         WHERE new.id_pedido = i.id_pedido;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  SET pago_pedido := NEW.pago_pedido;

  IF (pago_pedido = TRUE) THEN
    INSERT INTO venda(id_venda, data_venda, data_envio_pedido, id_cliente, total_venda)
    VALUES (NEW.id_pedido, NOW(), NEW.data_envio_pedido, NEW.id_cliente, NEW.total_pedido);

    OPEN cur;
    cur_loop :
      LOOP
        FETCH cur INTO idv, idp, qp;
        IF (done) THEN
          LEAVE cur_loop;
        ELSE
          INSERT INTO item_venda(id_venda, id_produto, quantidade_produto) VALUES (idv, idp, qp);

          IF EXISTS(SELECT v.id_venda
                    FROM venda v
                           INNER JOIN item_venda i
                                      ON v.id_venda = new.id_pedido AND i.id_venda = new.id_pedido AND
                                         v.id_venda = i.id_venda) THEN
            DELETE FROM item_pedido WHERE item_pedido.id_pedido = new.id_pedido;
          END IF;
        END IF;
      END LOOP;
    CLOSE cur;

  END IF;

END $$
DELIMITER ;
