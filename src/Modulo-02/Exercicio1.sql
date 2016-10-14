-- Coloquei o nome como PK para seguir o exemplo. Pergunta poderia usar o id na tabela Projeto?
create table Empregado(
	Nome varchar(100) not null, 
	constraint PK_Empregado primary key (Nome) 
);

create table Responsavel(
	Nome varchar(100) not null,
	constraint PK_Responsavel primary key (Nome)
);

create table Projeto(
	IDProjeto			int				identity	not null,
	NomeProjeto			varchar (100)				not null,
	Responsavel         varchar(100)				not null,
	DataInicio			datetime					not null,
	DataFimPrevisto		datetime					not null,
	DataFimReal			datetime					not null, 
	ValorPrevisto       decimal (18,2)				not null,
	ValorRealizado      decimal (18,2)				not null,
	ValorFaturado       decimal (18,2)				not null,
	Empregado           varchar(100)				not null,
	ParticipacaoPerc    decimal(3,2)				not null,

		constraint PK_Projeto primary key (IDProjeto),
			constraint FK_Responsavel foreign key (Responsavel)
				references Responsavel (Nome),
			constraint FK_Empregado foreign key (Empregado)
				references Empregado (Nome),
);

insert into Responsavel values('Heitor de Troia');
insert into Responsavel values('James Lovell');
insert into Responsavel values('Ivan Korolev');
insert into Responsavel values('Sergei Korolev');
 
select * from Responsavel;

insert into Empregado values('Dardano');
insert into Empregado values('Laomedonte');
insert into Empregado values('Carlos Saldanha');
insert into Empregado values('Príamo');
insert into Empregado values('Páris');
insert into Empregado values('Fred Haise');
insert into Empregado values('John Swigert');
insert into Empregado values('Charles Duke Jr');
insert into Empregado values('Carlos Saldanha');
insert into Empregado values('Laika');
insert into Empregado values('Yuri Gagarin');
insert into Empregado values('Kerim Kerimov');
insert into Empregado values('Valentina Tereshkova');

select * from Empregado;

insert into Projeto Values ('Projeto Atenas II', 'Heitor de Troia', convert(datetime, '21/07/2001',103), convert(datetime, '28/07/2011', 103),  convert(datetime, '10/04/2011', 103), 7851532326.14, 1969532326.14, 2500532326.14, 'Dardano', 1.00 );
insert into Projeto Values ('Projeto Atenas II', 'Heitor de Troia', convert(datetime, '21/07/2001',103), convert(datetime, '28/07/2011', 103),  convert(datetime, '10/04/2011', 103), 7851532326.14, 1969532326.14, 2500532326.14, 'Laomedonte', 1.00 );
insert into Projeto Values ('Projeto Atenas II', 'Heitor de Troia', convert(datetime, '21/07/2001',103), convert(datetime, '28/07/2011', 103),  convert(datetime, '10/04/2011', 103), 7851532326.14, 1969532326.14, 2500532326.14, 'Carlos Saldanha', 0.10 );
insert into Projeto Values ('Projeto Atenas II', 'Heitor de Troia', convert(datetime, '21/07/2001',103), convert(datetime, '28/07/2011', 103),  convert(datetime, '10/04/2011', 103), 7851532326.14, 1969532326.14, 2500532326.14, 'Príamo', 1.00 );
insert into Projeto Values ('Projeto Atenas II', 'Heitor de Troia', convert(datetime, '21/07/2001',103), convert(datetime, '28/07/2011', 103),  convert(datetime, '10/04/2011', 103), 7851532326.14, 1969532326.14, 2500532326.14, 'Páris', 1.00 );
insert into Projeto Values ('Apollo XIII', 'James Lovell',          convert(datetime, '02/01/2010',103), convert(datetime, '25/04/2016', 103),  convert(datetime, '17/04/2016', 103), 350754000.65, 386754014.38, 386754014.38, 'Fred Haise', 1.00 );
insert into Projeto Values ('Apollo XIII', 'James Lovell',          convert(datetime, '02/01/2010',103), convert(datetime, '25/04/2016', 103),  convert(datetime, '17/04/2016', 103), 350754000.65, 386754014.38, 386754014.38, 'John Swigert', 1.00 );
insert into Projeto Values ('Apollo XIII', 'James Lovell',          convert(datetime, '02/01/2010',103), convert(datetime, '25/04/2016', 103),  convert(datetime, '17/04/2016', 103), 350754000.65, 386754014.38, 386754014.38, 'John Young', 0.90 );
insert into Projeto Values ('Apollo XIII', 'James Lovell',          convert(datetime, '02/01/2010',103), convert(datetime, '25/04/2016', 103),  convert(datetime, '17/04/2016', 103), 350754000.65, 386754014.38, 386754014.38, 'Charles Duke Jr', 0.90 );
insert into Projeto Values ('Apollo XIII', 'James Lovell',          convert(datetime, '02/01/2010',103), convert(datetime, '25/04/2016', 103),  convert(datetime, '17/04/2016', 103), 350754000.65, 386754014.38, 386754014.38, 'Carlos Saldanha', 0.10 );
insert into Projeto Values ('Sputinik', 'Ivan Korolev',             convert(datetime, '25/12/2009',103), convert(datetime, '25/10/2012', 103),  convert(datetime, '25/10/2012', 103), 79853154.50, 55953154.50, 79853154.50, 'Laika', 1.00 );
insert into Projeto Values ('Sputinik', 'Ivan Korolev',             convert(datetime, '25/12/2009',103), convert(datetime, '25/10/2012', 103),  convert(datetime, '25/10/2012', 103), 79853154.50, 55953154.50, 79853154.50, 'Carlos Saldanha', 0.10 );
insert into Projeto Values ('Vostok I', 'Sergei Korolev',           convert(datetime, '09/11/2005',103), convert(datetime, '12/04/2016', 103),  convert(datetime, '12/04/2016', 103), 765876200.00, 610176200.00, 765876200.00, 'Yuri Gagarin', 1.00 );
insert into Projeto Values ('Vostok I', 'Sergei Korolev',           convert(datetime, '09/11/2005',103), convert(datetime, '12/04/2016', 103),  convert(datetime, '12/04/2016', 103), 765876200.00, 610176200.00, 765876200.00, 'Kerim Kerimov', 1.00 );
insert into Projeto Values ('Vostok I', 'Sergei Korolev',           convert(datetime, '09/11/2005',103), convert(datetime, '12/04/2016', 103),  convert(datetime, '12/04/2016', 103), 765876200.00, 610176200.00, 765876200.00, 'Carlos Saldanha', 0.10 );
insert into Projeto Values ('Vostok I', 'Sergei Korolev',           convert(datetime, '09/11/2005',103), convert(datetime, '12/04/2016', 103),  convert(datetime, '12/04/2016', 103), 765876200.00, 610176200.00, 765876200.00, 'Valentina Tereshkova', 0.85 );

truncate table Projeto;
select * from Projeto;
--1)
select Empregado, 
		COUNT(1) as Total 
	from Projeto
	Group By Empregado
Having  count(1)>1;

--2)
select distinct NomeProjeto
		from Projeto
where (ValorFaturado - ValorRealizado)>0;

--3) 
select NomeProjeto 
		from projeto
		where valorFaturado < ValorRealizado

--4)
select Nome, 
		 CASE WHEN CHARINDEX(' ', NOME) > 0 
		 THEN SUBSTRING(NOME, 1, CHARINDEX(' ', NOME) - 1) 
		 ELSE NOME 
		 END as NomeCurto,
		COUNT(1) as Total 
	from Empregado
	Group By Nome
Having  count(1)=1;