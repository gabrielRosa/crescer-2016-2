--1)

select count(1) as Total
		from Pedido
		where DataPedido between convert(datetime,'01/09/2016', 103) and convert(datetime,'30/09/2016', 103)+.99999

--2)

select p.nome
	from Produto as p 
	Inner join ProdutoMaterial as m on p.IDProduto = m.IDProduto
	where m.IDMaterial = 15836

create index IX_ProdutoMaterial_Material on ProdutoMaterial (IDMaterial);

--3)

select Nome, RazaoSocial
	from cliente
	where RazaoSocial like '%ltda%' or Nome  like '%ltda%'

--4)

insert into Produto (Nome, PrecoCusto, PrecoVenda, Situacao)
values('Galocha Maragato', 36.67, 77.95, 'A')

--5)

Select * 
from Produto as produto left Join PedidoItem as pim
on produto.IDProduto = pim.IDProduto
where pim.IDProduto is null

/*
--Melhor esse modelo
Select IDProduto, Nome
from Produto pro
where not exists (Select 1
				  From pedidoItem item
				  where pro.IDProduto = item.IDProduto)
*/


--6)

Select top 1 UF
from Cidade as c 
Inner join cliente as cl on c.IDCidade = cl.IDCidade
group by uf
order by count(1) desc

Select top 1 UF
from Cidade as c 
Inner join cliente as cl on c.IDCidade = cl.IDCidade
group by uf
order by count(1) asc

--7)

Select IDPedido, DataEntrega, ValorPedido, Quantidade