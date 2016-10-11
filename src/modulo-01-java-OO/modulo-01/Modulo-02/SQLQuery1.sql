select NomeEmpregado from Empregado order by DataAdmissao

select * from Empregado

select NomeEmpregado, Salario from Empregado where Cargo in ('Atendente') or Salario*12< 18500.00

select IDCidade from Cidade where Nome = 'Uberlândia'

select * from Cidade

Select IDCidade, Nome from Cidade where UF in ('RS')
