using Loja.Dominio;
using Loja.Repositorio;
using Loja.Web.Models;
using Loja.Web.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    public class ProdutoController : Controller
    {

        public ActionResult ListarProduto()
        {
            ListaDeProdutosModel lista = new ListaDeProdutosModel(ServicoDeDependencias.MontarListaDeProdutos());
            return View(lista);
        }

        public ActionResult EditarProduto(int id)
        {
            Produto produto = ServicoDeDependencias.GetProdutoById(id);
            EditarProdutoModel editar = produto.ConverteParaViewModel();
            return View(editar);
        }

        public ActionResult Salvar(int id)
        {
            ProdutoRepositorio produto = new ProdutoRepositorio();
            produto.EditarProduto(id);

            return View("Concluido");
        }
    }
}