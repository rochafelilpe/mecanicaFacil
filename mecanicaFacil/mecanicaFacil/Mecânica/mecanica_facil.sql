

CREATE TABLE veiculo (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	placa VARCHAR(10) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    cor VARCHAR(20) NOT NULL,
    ano INT NOT NULL,
    cliente_id int NOT NULL,
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
    veiculo_id INT NOT NULL,
	FOREIGN KEY (veiculo_id) REFERENCES veiculo(id)
);

show tables;
select * from servico;

