CREATE TABLE topicos (
    id      BIGINT AUTO_INCREMENT NOT NULL,
    titulo  VARCHAR(20) NOT NULL UNIQUE ,
    mensaje VARCHAR(255) NOT NULL UNIQUE ,
    fecha   date NOT NULL,
    estado  VARCHAR(50) NOT NULL,
    autor   VARCHAR(30) NOT NULL,
    curso   VARCHAR(50) NOT NULL,
    CONSTRAINT pk_topicos PRIMARY KEY (id)
);