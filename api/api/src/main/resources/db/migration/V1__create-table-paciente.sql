create table Pacientes(
	id bigint primary key,
	nome varchar(100) not null,
	email varchar(100) not null,
	telefone varchar(25) not null,
	logradouro varchar(30) not null,
	bairro varchar(30) not null,
	cep varchar(10) not null,
	cidade varchar(20) not null,
	uf varchar(12) not null,
	numero varchar(8),
	complemento varchar(10)
	
);