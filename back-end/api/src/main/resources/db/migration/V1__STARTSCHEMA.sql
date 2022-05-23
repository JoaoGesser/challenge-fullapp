CREATE SEQUENCE  IF NOT EXISTS cod_id START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE  IF NOT EXISTS cpo_id START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE  IF NOT EXISTS pro_id START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE  IF NOT EXISTS scm_id START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE  IF NOT EXISTS sco_id START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE  IF NOT EXISTS sho_id START WITH 1 INCREMENT BY 1;

CREATE TABLE tb_client_order (
  cor_id BIGINT NOT NULL,
   cor_total DOUBLE PRECISION,
   CONSTRAINT pk_tb_client_order PRIMARY KEY (cor_id)
);

CREATE TABLE tb_client_product_order (
  cpo_id BIGINT NOT NULL,
   cpo_corid BIGINT,
   cpo_proid BIGINT,
   CONSTRAINT pk_tb_client_product_order PRIMARY KEY (cpo_id)
);

CREATE TABLE tb_product (
  pro_id BIGINT NOT NULL,
   pro_name VARCHAR(255),
   pro_value DOUBLE PRECISION,
   CONSTRAINT pk_tb_product PRIMARY KEY (pro_id)
);

CREATE TABLE tb_shipping_client_order (
  sco_id BIGINT NOT NULL,
   sco_shoid BIGINT,
   sco_corid BIGINT,
   CONSTRAINT pk_tb_shipping_client_order PRIMARY KEY (sco_id)
);

CREATE TABLE tb_shipping_company (
  scm_id BIGINT NOT NULL,
   scm_name VARCHAR(255),
   CONSTRAINT pk_tb_shipping_company PRIMARY KEY (scm_id)
);

CREATE TABLE tb_shipping_order (
  sho_id BIGINT NOT NULL,
   sho_scmid BIGINT,
   CONSTRAINT pk_tb_shipping_order PRIMARY KEY (sho_id)
);

ALTER TABLE tb_product ADD CONSTRAINT uc_tb_product_pro_name UNIQUE (pro_name);

ALTER TABLE tb_client_product_order ADD CONSTRAINT FK_TB_CLIENT_PRODUCT_ORDER_ON_CPO_CORID FOREIGN KEY (cpo_corid) REFERENCES tb_client_order (cor_id);

ALTER TABLE tb_client_product_order ADD CONSTRAINT FK_TB_CLIENT_PRODUCT_ORDER_ON_CPO_PROID FOREIGN KEY (cpo_proid) REFERENCES tb_product (pro_id);

ALTER TABLE tb_shipping_client_order ADD CONSTRAINT FK_TB_SHIPPING_CLIENT_ORDER_ON_SCO_CORID FOREIGN KEY (sco_corid) REFERENCES tb_client_order (cor_id);

ALTER TABLE tb_shipping_client_order ADD CONSTRAINT FK_TB_SHIPPING_CLIENT_ORDER_ON_SCO_SHOID FOREIGN KEY (sco_shoid) REFERENCES tb_shipping_order (sho_id);

ALTER TABLE tb_shipping_order ADD CONSTRAINT FK_TB_SHIPPING_ORDER_ON_SHO_SCMID FOREIGN KEY (sho_scmid) REFERENCES tb_shipping_company (scm_id);