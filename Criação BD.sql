drop database Locadora;

CREATE SCHEMA IF NOT EXISTS Locadora DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

USE Locadora;

create table endereco(
idEndereco serial,
rua varchar(30) not null,
cidade varchar(30) not null,
estado varchar(30) not null,
bairro varchar(30),
cep integer,
numero integer,
CONSTRAINT pkEndereco primary key(idEndereco)
);

create table categoria(
idCategoria serial,
nome varchar(15),
CONSTRAINT pkCategoria primary key(idCategoria)
);

create table Estado(
idEstado serial,
nome varchar(15),
CONSTRAINT pkEstado primary key(idEstado)
);

create table Marca(
idMarca serial,
nome varchar(15),
CONSTRAINT pkMarca primary key(idMarca)
);

create table Modelo(
idModelo serial,
nome varchar(15),
CONSTRAINT pkModelo primary key(idModelo)
);

create table Cliente(
idCliente serial,
nome varchar(40) not null,
RG varchar(10) not null,
CPF varchar(11) not null,
idEndereco integer not null,
CONSTRAINT pkCliente primary key(idCliente),
CONSTRAINT ukCPF unique (CPF),
CONSTRAINT fkEndereco foreign key(idEndereco) references Endereco(idEndereco)
);

create table Veiculo(
idVeiculo serial,
valorDeCompra numeric not null,
placa varchar(7) not null,
ano integer not null,
idModelo integer not null,
idMarca integer not null,
idEstado integer not null,
idCategoria integer not null,
CONSTRAINT pkVeiculo primary key(idVeiculo),
CONSTRAINT ukPlaca unique(placa),
CONSTRAINT fkModelo foreign key(idModelo) references Modelo(idModelo),
CONSTRAINT fkMarca foreign key(idMarca) references Marca(idMarca),
CONSTRAINT fkEstado foreign key(idEstado) references Estado(idEstado),
CONSTRAINT fkCategoria foreign key(idCategoria) references Categoria(idCategoria)
);

create table Locacao(
idLocacao serial,
data timestamp not null,
valor numeric not null,
dias integer not null,
idVeiculo integer not null,
idCliente integer not null,
CONSTRAINT pkLocacao primary key(idLocacao),
CONSTRAINT ukClienteVeiculoData unique(data, idVeiculo, idCliente),
CONSTRAINT fkVeiculo foreign key(idVeiculo) references Veiculo(idVeiculo),
CONSTRAINT fkCliente foreign key(idCliente) references Cliente(idCliente)
);