--1)

select count(1) as Total
		from Pedido
		where DataPedido between convert(datetime,'01/09/2016', 103) and convert(datetime,'30/09/2016', 103)

--2)



select p.nome
	from Produto as p 
	Inner join ProdutoMaterial as m on p.IDProduto = m.IDProduto
	where m.IDMaterial = 15836

--3)

select Nome
	from cliente
	where RazaoSocial like '%ltda%'

--4)

insert into Produto (Nome, 
					 DataCadastro,
					 PrecoCusto,
					 PrecoVenda,
					 Situacao)
	values('Galocha Maragato',
		    GETDATE(),	
			35.67,
			77.95,
			'A');

--5)

Select p.Nome
	from Produto as p
	where p.IDProduto not in (Select IDProduto from PedidoItem)

/*
Pensei em fazer com o inner join (como demonstrado abaixo) porém não obtive sucesso.
Select p.Nome
	from Produto as p
	Inner Join PedidoItem as pdi on p.IDProduto = pdi.IDProduto
	where p.IDProduto <> pdi.IDProduto
*/

--6)

Select
