using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class EditarProdutoModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public decimal Valor { get; set; }
    }

    public static class ProdutoViewModelExtensions
    {
        public static EditarProdutoModel ConverteParaViewModel(this Produto produto)
        {
            EditarProdutoModel editar = new EditarProdutoModel();
            editar.Id = produto.Id;
            editar.Nome = produto.Nome;
            editar.Valor = produto.Valor;
            return editar;
        }
    }
}