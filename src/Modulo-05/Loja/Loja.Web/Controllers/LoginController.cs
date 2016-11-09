using Loja.Dominio;
using Loja.Web.Models;
using Loja.Web.Servicos;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(IndexModel indexModel)
        {
            UsuarioServico usuarioServico = ServicoDeDependencias.MontarUsuarioServico();

            Usuario usuario = usuarioServico.BuscarPorAutenticacao(indexModel.Email, indexModel.Senha);

            if(usuario == null)
            {
                ViewBag.MessagemErro = "Email ou senha incorreto(s)!";
                return View("Index");
            }

            return RedirectToAction("ListarProduto", "Produto");
        }
    }
}