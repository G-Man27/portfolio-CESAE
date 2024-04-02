create table cliente (cliente_id int identity(1,1) primary key, nome text);
create table contrato (contrato_id int identity(1,1) primary key, data_inicio date, data_fim date, cliente_id int);
create table elevador (elevador_id int identity(1,1) primary key, contrato_id int, marca text);
create table visita (visita_id int identity(1,1) primary key, contrato_id int, data_visita date, tecnico_id int);
create table relatorio (relatorio_id int identity(1,1) primary key, elevador_id int, visita_id int);
create table proposta (proposta_id int identity(1,1) primary key, relatorio_id int, aceite bit);
create table pecas_proposta (proposta_id int not null, peca_id int not null, custo decimal(10,2));

alter table pecas_proposta 
add primary key (proposta_id, peca_id);
alter table contrato
add foreign key (cliente_id) references cliente(cliente_id);
alter table elevador
add foreign key (contrato_id) references contrato(contrato_id);
alter table visita
add foreign key (contrato_id) references contrato(contrato_id);
alter table relatorio
add foreign key (elevador_id) references elevador(elevador_id);
alter table relatorio
add foreign key (visita_id) references visita(visita_id);
alter table proposta
add foreign key (relatorio_id) references relatorio(relatorio_id);
alter table pecas_proposta
add foreign key (proposta_id) references proposta(proposta_id);

insert into cliente (nome) values ('Maria'), ('Manuel');
select * from cliente;
insert into contrato (data_inicio, data_fim, cliente_id) values ('2021-11-9', '2021-11-10', 1), ('2021-05-9', '2021-05-10', 2);
select * from contrato;
insert into elevador (contrato_id, marca) values (1,'XPTO'), (2,'XPTO10');
select * from elevador;
insert into visita (contrato_id, data_visita, tecnico_id) values (1,'2021-11-9', 101), (2,'2021-11-9', 102);
select * from visita;
insert into relatorio (elevador_id, visita_id) values (1,1);
select * from relatorio;
insert into proposta (relatorio_id, aceite) values (1,1);
select * from proposta;
insert into pecas_proposta (proposta_id, peca_id, custo) values (1,1005,10.3);
select * from pecas_proposta;

--a)
select c.nome, o.data_fim
from cliente c, contrato o
where c.cliente_id = o.cliente_id and o.data_fim > getdate();

--b)


--5
insert into cliente (nome) values ('Gonçalo'), ('António');
select * from cliente;
insert into contrato (data_inicio, data_fim, cliente_id) values ('2021-11-15', '2024-11-21', 1003), ('2021-05-27', '2024-05-31', 1002);
select * from contrato;
insert into elevador (contrato_id, marca) values (1003,'XPTO'), (1002,'XPTO10'),(1003,'XPTO10');
select * from elevador;
insert into visita (contrato_id, data_visita, tecnico_id) values (1002,'2021-11-9', 101), (1003,'2021-11-9', 102);
select * from visita;
insert into relatorio (elevador_id, visita_id) values (1002,1003);
select * from relatorio;
insert into proposta (relatorio_id, aceite) values (2,1);
select * from proposta;
insert into pecas_proposta (proposta_id, peca_id, custo) values (2,1005,10.3), (2,1006,20);
select * from pecas_proposta;

--6
--a)
select c.nome, d.data_fim
	from cliente c, contrato d
	where c.cliente_id=d.cliente_id and d.data_fim>GETDATE();

--b)
select c.cliente_id, COUNT(c.cliente_id) as contagem
	from cliente c, contrato d
	where c.cliente_id=d.cliente_id and d.data_fim>GETDATE()
	group by c.cliente_id;

--c)
select e.contrato_id,COUNT(e.elevador_id) as contagem
	from elevador e
	group by e.contrato_id
	having COUNT(e.elevador_id)>1;

--d)
insert into visita(contrato_id,data_visita,tecnico_id)
	values(1003,'2021-5-27',101), (2,'2021-5-9',102);

select v.tecnico_id
	from elevador e, visita v
	where e.contrato_id=v.contrato_id and v.data_visita between '2021-5-1' and '2021-5-31'
	--and month(v.data_visita=5 and year(v.data_visita)=2021
	group by v.tecnico_id--,e.contrato_id
	having COUNT(e.elevador_id)>1;

--e)
select e.contrato_id as 'contrato_id (ativo)',COUNT(e.elevador_id) as nº_elevadores
	from elevador e, contrato c
	where e.contrato_id=c.contrato_id and c.data_fim>GETDATE()
	group by e.contrato_id
	having COUNT(e.elevador_id)>1;