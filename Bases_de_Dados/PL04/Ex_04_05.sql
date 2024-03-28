update Venda
set qtd=10
where prod=1
and cli=2
and data_venda='2012-04-05 00:00:00.000'

go
create procedure alteraMorada(
@morada varchar(100), @cli int
)
as
update Cliente
set morada=@morada
where id=@cli;
go

Exec alteraMorada
@morada= 'Porto', @cli=2;
go

--5.b
create view clientesAtivos As
select nome from Cliente
where estado=1
go

select * from clientesAtivos
go

--5.e
create procedure quantasVendas_cli(
@cli int)
as
select count(v.cli) as contagem
from
Venda v
where v.cli=@cli
go
Exec quantasVendas_cli @cli=2
go

--5.f
select max(preco)
from Produto
go

create view NomeProdMaisCaro AS
select descricao, preco
from Produto
where preco=(select max(preco) as Maxim
from Produto)
go

select * from NomeProdMaisCaro
go

--5.h
create view ClientesNuncaCompraram as
select nome
from Cliente
where id not in (select cli from Venda)
go

select * from ClientesNuncaCompraram
go