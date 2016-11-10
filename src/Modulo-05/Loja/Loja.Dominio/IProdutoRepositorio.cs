using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public interface IProdutoRepositorio
    {
        List<Produto> ListarProdutos();
        void EditarProduto(Produto produto);
        Produto GetProdutoById(int id);
        void ExcluirProduto(Produto produto);
    }
}
