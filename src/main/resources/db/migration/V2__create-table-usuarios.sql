CREATE TABLE usuarios
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    login VARCHAR(255) not null,
    clave VARCHAR(300) not null,
    PRIMARY KEY (id)
);