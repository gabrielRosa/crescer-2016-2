select * from empregado;
--1)ainda nao terminado
select NomeEmpregado 
from empregado
where  DataAdmissao between '1980/05/01' and '1982/01/20' 
--2)
select cargo
	from empregado
	where  max(select cargo
				count(1)
				from empregado
				where cargo)

