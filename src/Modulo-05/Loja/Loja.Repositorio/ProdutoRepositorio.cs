using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;

namespace Loja.Repositorio
{
    public class ProdutoRepositorio : IProdutoRepositorio
    {
        public Produto GetProdutoById(int id)
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto.FirstOrDefault(p => p.Id==id);
            }
        }

        public void ExcluirProduto(int id)
        {
            throw new NotImplementedException();
        }

        public List<Produto> ListarProdutos()
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto.ToList(); 
            }
        }

        public void EditarProduto(int id)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(this.GetProdutoById(id)).State = EntityState.Modified;
                context.SaveChanges();
            }
        }
    }
}
