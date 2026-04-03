show databases;

CREATE DATABASE IF NOT EXISTS mecanica_facil; 
USE mecanica_facil; 

CREATE TABLE veiculo (
    placa VARCHAR(10) PRIMARY KEY,
    modelo VARCHAR(50) NOT NULL,
    marca VARCHAR(50),
    cor VARCHAR(20),
    ano INT,
    cliente_id int not null,
    FOREIGN KEY(cliente_id) REFERENCES cliente(id)
);

CREATE TABLE cliente(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL, 
	telefone VARCHAR(20) NOT NULL,
	endereco VARCHAR(200) NOT NULL
);


CREATE TABLE servico(
	id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(300) NOT NULL, 
    valor DECIMAL(10,2) NOT NULL, 
    data_servico DATE NOT NULL, 
    veiculo_placa VARCHAR(10) NOT NULL,
	FOREIGN KEY (veiculo_placa) REFERENCES veiculo(placa)
);

show tables;

