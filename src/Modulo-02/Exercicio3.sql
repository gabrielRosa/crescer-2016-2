--7) nao consegui fazer
select * from empregado

Select e.NomeEmpregado as NomeEmpregado,
		f.NomeDepartamento as Departamento,
		g.NomeEmpregado as NomeGerente,
		h.NomeDepartamento as Departamento
	From Empregado as e
	Inner join Departamento as f on e.IDDepartamento = f.IDDepartamento
	Inner join Empregado as g on e.IDGerente = g.IDEmpregado
	Inner join Departamento as h on  e.IDDepartamento = h.IDDepartamento and e.IDGerente = g.IDEmpregado

--8)
select * into Empregado2 from empregado

begin tran
update empregado2
set salario = salario*1.145
from empregado2 e inner join departamento d on e.IDDepartamento = d.IDDepartamento and d.Localizacao in ('Sao paulo')

select * from Empregado2

--9)
select sum(e2.salario - e.salario ) 
from empregado e inner join empregado2 e2
on e.IDEmpregado = e2.IDEmpregado
/*
select (sum(salario) - ((Select sum(salario) from copiaEmpregado))) as DiferencaSalarios
from empregado
*/
--10) 
select top 1 with ties
	e.NomeDepartamento
	from empregado f Inner join Departamento e on f.IDDepartamento = e.IDDepartamento
	group by NomeDepartamento
	order by max(f.Salario) desc;
--2 modelos de acordo com a tabela
select top 1 with ties
	e.NomeDepartamento
	from empregado2 f Inner join Departamento e on f.IDDepartamento = e.IDDepartamento
	group by NomeDepartamento
	order by max(f.Salario) desc;