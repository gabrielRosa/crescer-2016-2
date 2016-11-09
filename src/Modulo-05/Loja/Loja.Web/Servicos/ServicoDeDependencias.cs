using Loja.Dominio;
using Loja.Infraestrutura;
using Loja.Repositorio;
using System.Collections.Generic;
using System;

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

         static void SalvarProduto(int id)
        {
            throw new NotImplementedException();
        }
    }
}