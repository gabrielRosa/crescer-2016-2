using Loja.Dominio;
using Loja.Infraestrutura;
using Loja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Loja.Web.Servicos
{
    public class ServicoDeDependencias
    {
        public static UsuarioServico MontarUsuarioServico()
        {
            UsuarioServico usuarioServico =
                new UsuarioServico(
                    new UsuarioRepositorio(), 
                    new ServicoDeCriptografia());

            return usuarioServico;
        }

        public static List<Produto> MontarListaDeProdutos()
        {
            ProdutoRepositorio produtos = new ProdutoRepositorio();
            return produtos.ListarProdutos();
        }

        public static Produto GetProdutoById(int id)
        {
            ProdutoRepositorio produto = new ProdutoRepositorio();
            return produto.GetProdutoById(id);
        }

        public static Produto ValidaProduto(Produto produto)
        {
            ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorio());
            produtoServico.ValidarProduto(produto);

            return produto;
        }

    }
}