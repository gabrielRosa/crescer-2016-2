--1)
select NomeEmpregado, DataAdmissao, DATEDIFF(Month,DataAdmissao,convert(datetime,'2000/12/31')) as MesesTrabalhados
from empregado
where  DataAdmissao between '1980/05/01' and '1982/01/20' 
--2)
select cargo, count(cargo)
from empregado
group by cargo
having count(cargo) = (select max (C.Cargo)
from (select count (cargo) as Cargo
from empregado
group by (cargo)) as c)

/*
Select top 1 with ties
	cargo,
	count(1) as Total
from Empregado
group by cargo
order by Total desc;
*/
--3) 
select uf, count(1) as TotalCidades
from cidade 
group by uf

--4)
select nome, uf, count(1) as Duplicadas
from cidade 
group by Nome, uf
having count(nome)>1

--5)
select isnull(max(IDAssociado),0)+1 as Proximo_ID
from associado
--6)
select nomeempregado, salario,
case when salario < 1164
then 0 
end,
case when salario > 1164 and salario < 2326
then 15
end,
case when salario > 2326
then 27.5
end as Imposto
from empregado
/*
select NomeEmpregado,
	 Salario,
	 case when salario <= 1164 then 0
		when salario <= 2336 then 15
		else 27.5
		end as Imposto
		From empregado;

*/


