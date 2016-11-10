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

        [ValidateAntiForgeryToken]
        public ActionResult Salvar(EditarProdutoModel model)
        {
            ProdutoRepositorio repositorio = new ProdutoRepositorio();
            Produto produto = new Produto();

            produto.Id = model.Id;
            produto.Nome = model.Nome;
            produto.Valor = model.Valor;

            repositorio.EditarProduto(ServicoDeDependencias.ValidaProduto(produto));

            return View("Concluido");
        }

        public ActionResult Excluir(EditarProdutoModel model)
        {
            ProdutoRepositorio repositorio = new ProdutoRepositorio();
            Produto produto = new Produto();

            produto.Id = model.Id;
            produto.Nome = model.Nome;
            produto.Valor = model.Valor;

            repositorio.ExcluirProduto(produto);

            return View("Concluido");
        }
    }
}