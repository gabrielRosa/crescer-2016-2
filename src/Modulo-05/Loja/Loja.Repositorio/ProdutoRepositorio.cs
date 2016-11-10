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

        public void ExcluirProduto(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(produto).State = EntityState.Deleted;
                context.SaveChanges();
            }
        }

        public List<Produto> ListarProdutos()
        {
            using (var context = new ContextoDeDados())
            {
                return context.Produto.ToList(); 
            }
        }

        public void EditarProduto(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                context.Entry<Produto>(produto).State = EntityState.Modified;
                context.SaveChanges();
            }
        }
    }
}
