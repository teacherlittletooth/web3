-- Criando banco de dados
create database sistema_java;

-- Selecionando o banco de dados
use sistema_java;

-- Criando tabela de usuarios
create table usuarios(
	id int primary key auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    nascimento date not null,
    senha text not null,
    noticias tinyint(1) not null
);

-- Criando a conta de administrador
insert into usuarios(nome, email, nascimento, senha, noticias)
values
( "admin", "admin@admin", "1970-01-01", sha1("ADM@123"), 0 );
