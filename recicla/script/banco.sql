create database ams20241;

create table ams20241.usuarios (
  id BIGINT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255),
  senha VARCHAR(255),
  status VARCHAR(255),
  tipo VARCHAR(255),
  primary key (id));

create table ams20241.sistemas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  servidor VARCHAR(255),
  status VARCHAR(255),
  ip VARCHAR(255),
  primary key (id));

create table ams20241.usuarios_sistemas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  idU BIGINT NOT NULL,
  idS BIGINT NOT NULL,
  obs VARCHAR(255),
  primary key (id));

ALTER TABLE ams20241.usuarios_sistemas ADD CONSTRAINT fk_ussi FOREIGN KEY (idU) REFERENCES ams20241.usuarios(id);
ALTER TABLE ams20241.usuarios_sistemas ADD CONSTRAINT fk_sius FOREIGN KEY (idS) REFERENCES ams20241.sistemas(id);

INSERT INTO `ams20241`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('BITTENCOURT', 'ABFABF010101', 'ATIVO', 'ADM');
INSERT INTO `ams20241`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('SCURACCHIO', 'ABFABF010101', 'ATIVO', 'VISITANTE');

