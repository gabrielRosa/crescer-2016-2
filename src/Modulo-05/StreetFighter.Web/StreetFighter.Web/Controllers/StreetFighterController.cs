using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using StreetFighter.Web.Models;
using System.Globalization;
using StreetFighter.Aplicativo;
using StreetFighter.Dominio;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        // GET: StreetFighter
        public ActionResult Index()
        {
            return View();
        }
        //duvida neste método
        public ActionResult FichaTecnica(string nome)
        {
            PersonagemAplicativo personagemAplicativo = new PersonagemAplicativo();
            Personagem personagem = personagemAplicativo.ListarPersonagens(nome).First();

            FichaTecnicaModel fichaTecnica = new FichaTecnicaModel();

            fichaTecnica.Nascimento = personagem.Nascimento;
            fichaTecnica.Nome = personagem.Nome;
            fichaTecnica.Imagem = personagem.Imagem;
            fichaTecnica.Altura = personagem.Altura;
            fichaTecnica.Peso = personagem.Peso;
            fichaTecnica.AbreviacaoPais = personagem.AbreviacaoPais;
            fichaTecnica.GolpesEspeciais = personagem.GolpesEspeciais;
            fichaTecnica.PersonagemOculto = personagem.PersonagemOculto;

            return View(fichaTecnica);
        }

        public ActionResult Sobre()
        {
            SobreModel sobre = new SobreModel();
            sobre.PrimeiraAparicao = "Meados de 1996.";
            sobre.Nascimento = DateTime.Parse("23/02/1997", new CultureInfo("pt-BR"));
            sobre.Altura = 165;
            sobre.Peso = 61;
            sobre.Medidas = "B198, C120, Q172.";
            sobre.TipoSanguineo = 'A';
            sobre.HabilidadesEspeciais = "Programar, jogar e pedalar.";
            sobre.Gosta = "Nutella.";
            sobre.Desgosta = "Frio.";
            sobre.EstiloDeLuta = "Null.";
            sobre.Origem = "Brasil.";
            sobre.UmaFalaDeVitoria = "Ver um código sem bug é o paraíso!";
            sobre.GolpesEspeciaisFamosos = "Null.";
            return View(sobre);
        }

        public ActionResult Cadastro()
        {
            PopularPais();
            return View();
        }

        public ActionResult Salvar(CadastroModel model)
        {

            PopularPais();

            if (true)
            {
                Personagem personagem = new Personagem(
                    model.Imagem,
                    model.Nascimento,
                    model.Altura,
                    model.Peso,
                    model.AbreviacaoPais,
                    model.GolpesEspeciais,
                    model.PersonagemOculto,
                    model.Id,
                    model.Nome
                    );
                if (personagem.Id == 0)
                {
                    ViewBag.Mensagem = "Salvo com sucesso!";
                }
                else
                {
                    ViewBag.Mensagem = "Editado com sucesso!";
                }

                PersonagemAplicativo personagemAplicativo = new PersonagemAplicativo();
                personagemAplicativo.Salvar(personagem);
            }
            return View("Cadastro", model);
        }

        public ActionResult ListaDePersonagens(string filtro)
        {
            PersonagemAplicativo personagem = new PersonagemAplicativo();
            return View(personagem.ListarPersonagens(filtro));
        }

        public ActionResult ExcluirPersonagem(string id)
        {
            PersonagemAplicativo personagem = new PersonagemAplicativo();
            personagem.ExcluirPersonagem(Convert.ToInt32(id));
            ViewBag.Mensagem = "Excluído com sucesso!";
            return View("ListaDePersonagens",personagem.ListarPersonagens());
        }

        public ActionResult EditarPersonagem(string id)
        {
            PersonagemAplicativo personagemAplicativo = new PersonagemAplicativo();
            CadastroModel cadastroPopulado = new CadastroModel();

            Personagem personagem = personagemAplicativo.PersonagensPorId(Convert.ToInt32(id));

            cadastroPopulado.Id = personagem.Id;
            cadastroPopulado.Imagem = personagem.Imagem;
            cadastroPopulado.Nome = personagem.Nome;
            cadastroPopulado.Nascimento = personagem.Nascimento;
            cadastroPopulado.Altura = personagem.Altura;
            cadastroPopulado.Peso = personagem.Peso;
            cadastroPopulado.AbreviacaoPais = personagem.AbreviacaoPais;
            cadastroPopulado.GolpesEspeciais = personagem.GolpesEspeciais;
            cadastroPopulado.PersonagemOculto = personagem.PersonagemOculto;

            this.PopularPais();

            return View("Cadastro", cadastroPopulado);
        }

        private void PopularPais()
        {
            ViewData["ListaPaises"] = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "BR", Text = "Brasil" },
                new SelectListItem() { Value = "USA", Text = "Estados Unidos" },
                new SelectListItem() { Value = "CHI", Text = "Chile" },
                new SelectListItem() { Value = "GER", Text = "Alemanha" },
                new SelectListItem() { Value = "GRE", Text = "Grecia" },
                new SelectListItem() { Value = "MP", Text = "Morro da Pedra" }
            };
        }
    }
}