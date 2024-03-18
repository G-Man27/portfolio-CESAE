create database ExemploTeorica01;
use ExemploTeorica01;
create table Cliente(
idCliente int identity(1,1) PRIMARY KEY,
nome varchar(50),
cidade varchar(50),
codPostal int,
cc int unique not null
);
create table Venda(
idVenda int identity(1,1)PRIMARY KEY,
cliente int,
foreign key (cliente) references Cliente(idCliente),
data datetime,
desconto decimal(5,2)
);
create table Artigo(
idArtigo int identity(1,1) PRIMARY KEY,
nome varchar(50),
preco decimal(10,2),
categoria varchar(20)
);
create table LinhaVenda(
venda int,
foreign key (venda) references Venda(idVEnda),
artigo int,
foreign key (artigo) references Artigo(idArtigo),
quantidade int,
primary key (venda, artigo)
);