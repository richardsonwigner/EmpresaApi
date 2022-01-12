INSERT INTO USUARIO(nome, email, senha) VALUES('Funcionario', 'funcionario@gmail.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');

INSERT INTO Cargo(funcao) VALUES('funcao1');
INSERT INTO Cargo(funcao) VALUES('funcao2');

INSERT INTO Funcionario(nome, cpf, salario, cargo_id) VALUES ('funcionario1', '123456576', 5000, 1);
INSERT INTO Funcionario(nome, cpf, salario, cargo_id) VALUES ('funcionario2', '123456576', 3000, 2);
INSERT INTO Funcionario(nome, cpf, salario, cargo_id) VALUES ('funcionario3', '123456576', 8000, 1);
INSERT INTO Funcionario(nome, cpf, salario, cargo_id) VALUES ('funcionario4', '123456576', 10000, 2);