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

Select top 1 with ties 
	c1.UF
	from Cidade as c1
	Inner Join Cliente as ct on ct.IDCidade = c1.IDCidade
	group by c1.UF
	order by count(1) desc ;

Select top 1 with ties 
	c1.UF
	from Cidade as c1
	Inner Join Cliente as ct on ct.IDCidade = c1.IDCidade
	group by c1.UF
	order by count(1) asc ;

--7)

Select pedido.IDPedido, pedido.DataEntrega, pedido.ValorPedido, pim.Quantidade
	from Pedido as pedido
	Inner Join PedidoItem as pim on pedido.IDPedido = pim.IDPedido
	Inner Join ProdutoMaterial as produtoMaterial on produtoMaterial.IDProduto = pim.IDProduto

	where pedido.DataEntrega between convert(datetime, '01/10/2016', 103) and convert(datetime, '31/10/2016', 103) and 
	isnull(produtoMaterial.Quantidade,0)=0

Select pedido.IDCliente
	from Pedido as pedido
	Inner Join PedidoItem as pim on pedido.IDPedido = pim.IDPedido
	Inner Join ProdutoMaterial as produtoMaterial on produtoMaterial.IDProduto = pim.IDProduto

	where pedido.DataEntrega between convert(datetime, '01/10/2016', 103) and convert(datetime, '31/10/2016', 103) and 
	isnull(produtoMaterial.Quantidade,0)=0



--8)
select * from ProdutoMaterial where IDProduto = 8001
select * from Produto where nome = 'Galocha Maragato'

Select Nome
	from Produto as produto
	Inner Join ProdutoMaterial as pm on produto.IDProduto = pm.IDProduto
	where produto.IDProduto not in (pm.IDProduto)





--9)

Select top 1 with ties
	Substring(Nome, 1, Charindex(' ', Nome) -1)
	from Cliente
	group by Nome 
	order by count(distinct(Substring(Nome, 1, Charindex(' ', Nome) -1))) desc
 

--10)

begin tran
	
	 update produto set Situacao='F' 
		from pedido as pedido
			Inner Join PedidoItem as pim on pedido.IDPedido = pim.IDPedido
			Inner Join ProdutoMaterial as produtoMaterial on produtoMaterial.IDProduto = pim.IDProduto
			where isnull(produtoMaterial.Quantidade,0)=0
	 update Produto set Situacao='Q'
		  	from pedido as pedido
			Inner Join PedidoItem as pim on pedido.IDPedido = pim.IDPedido
			Inner Join ProdutoMaterial as produtoMaterial on produtoMaterial.IDProduto = pim.IDProduto
			where pedido.DataEntrega not between convert(datetime, DATEADD(M, -60, GETDATE()), 103) and convert(datetime, GETDATE(), 103) and 
			isnull(produtoMaterial.Quantidade,0)=0
	 update Produto set Situacao='A'
		  	from pedido as pedido
			Inner Join PedidoItem as pim on pedido.IDPedido = pim.IDPedido
			Inner Join ProdutoMaterial as produtoMaterial on produtoMaterial.IDProduto = pim.IDProduto	 
			where not pedido.DataEntrega not between convert(datetime, DATEADD(M, -60, GETDATE()), 103) and convert(datetime, GETDATE(), 103) and 
			isnull(produtoMaterial.Quantidade,0)=0 or isnull(produtoMaterial.Quantidade,0)=0
		  
commit

