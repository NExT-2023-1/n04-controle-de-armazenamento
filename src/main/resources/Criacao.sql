
CREATE database next_cloud;


CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    cpf CHAR(11) NOT NULL,
    data_nasc DATE,
    endereco TEXT,
    plano CHAR(1) NOT NULL CHECK (plano IN ('B', 'A', 'I')),
    qtd_arquivos_utilizados INT
);


CREATE TABLE Arquivos (
    id_arquivos INT AUTO_INCREMENT PRIMARY KEY,
    tamanho INT,
    nome VARCHAR(255) NOT NULL,
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);
