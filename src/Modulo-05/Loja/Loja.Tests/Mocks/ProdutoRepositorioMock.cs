using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Tests.Mocks
{
    public class ProdutoRepositorioMock : IProdutoRepositorio
    {
        public void EditarProduto(Produto produto)
        {
            throw new NotImplementedException();
        }

        public void ExcluirProduto(Produto produto)
        {
            throw new NotImplementedException();
        }

        public Produto GetProdutoById(int id)
        {
            throw new NotImplementedException();
        }

        public List<Produto> ListarProdutos()
        {
            Produto produto = new Produto();
            List<Produto> lista = new List<Produto>();

            produto.Id = 100;
            produto.Nome = "Nutella";
            produto.Valor = 9999;

            lista.Add(produto);

            return lista;
        }
    }
}
