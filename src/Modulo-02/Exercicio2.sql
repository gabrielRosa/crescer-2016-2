
--1)ainda nao terminado
select NomeEmpregado, DATEDIFF(Month,DataAdmissao,convert(datetime,'2000/12/31')) MesesTrabalhados
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
--3) 
select uf, count(nome)
from cidade 
group by uf

--4)
select uf, count(nome)
from cidade 
group by uf
having count(nome)>2

--5)
select max(IDAssociado)+1
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
end
from empregado

