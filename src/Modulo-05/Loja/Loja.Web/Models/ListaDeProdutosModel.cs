using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class ListaDeProdutosModel
    {
        public ListaDeProdutosModel(List<Produto> lista)
        {
            this.Lista = lista;
        }
        public List<Produto> Lista { get; }
    }
}