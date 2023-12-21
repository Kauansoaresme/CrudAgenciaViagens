/* Lógico_Viajantes: */

CREATE DATABASE viajantes;

USE viajantes;

CREATE TABLE Cliente (
    id_cliente integer PRIMARY KEY,
    nome_cliente VARCHAR(30),
    email_cliente VARCHAR(30),
    celular_cliente VARCHAR(11),
    senha_cliente VARCHAR(10)
);

CREATE TABLE Passagem (
    id_passagem integer PRIMARY KEY,
    classe VARCHAR(10),
    preco DECIMAL(10),
    fk_Cliente_id_cliente integer,
    fk_Voo_id_voo integer
);

CREATE TABLE Voo (
    id_voo integer PRIMARY KEY,
    origem_voo VARCHAR(30),
    destino_voo VARCHAR(30)
);
 
ALTER TABLE Passagem ADD CONSTRAINT FK_Passagem_2
    FOREIGN KEY (fk_Cliente_id_cliente)
    REFERENCES Cliente (id_cliente)
    ON DELETE CASCADE;
 
ALTER TABLE Passagem ADD CONSTRAINT FK_Passagem_3
    FOREIGN KEY (fk_Voo_id_voo)
    REFERENCES Voo (id_voo)
    ON DELETE CASCADE;