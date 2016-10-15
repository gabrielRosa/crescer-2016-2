--1)
select count(1) as Total
		from Pedido
		where DataPedido between convert(datetime,'01/09/2016', 103) and convert(datetime,'30/09/2016', 103)

--2)
select * from material

select p.nome
	from Produto as p 
	Inner join ProdutoMaterial as m on p.IDProduto = m.IDProduto
	where m.IDMaterial = 15836

--3)
select Nome
	from cliente
	where RazaoSocial like '%ltda%'

--4)

insert into 

