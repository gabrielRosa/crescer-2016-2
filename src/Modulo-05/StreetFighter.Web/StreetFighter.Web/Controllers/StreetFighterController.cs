using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using StreetFighter.Web.Models;
using System.Globalization;

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
        public ActionResult FichaTecnica()
        {
            //FichaTecnicaModel fichaTecnica = new FichaTecnicaModel();
            //fichaTecnica.PrimeiraAparicao = "Street Fighter II The World Warrior (1991).";
            //fichaTecnica.Nascimento = DateTime.Parse("12/02/1966", new CultureInfo("pt-BR"));
            //fichaTecnica.Nome = "Blanka";
            //fichaTecnica.Imagem = @"~/Content/Imagens/blanka.png";
            ///fichaTecnica.Altura = 192;
            //fichaTecnica.Peso = 96;
            //fichaTecnica.Medidas = "B198, C120, Q172.";
            //fichaTecnica.TipoSanguineo = 'B';
            //fichaTecnica.HabilidadesEspeciais = "Caçar, Eletricidade.";
            //fichaTecnica.Gosta = "Frutas tropicais, Pirarucu, Sua mãe.";
            //fichaTecnica.Desgosta = "Army ants (espécie de formiga).";
            //fichaTecnica.EstiloDeLuta = "Luta Selvagem autodidata (Army Ants) / Capoeira.";
            //fichaTecnica.Origem = "Brasil (lugar de nascença é provável como sendo Tailândia).";
            //fichaTecnica.UmaFalaDeVitoria = "Ver você em ação é uma piada!";
            //fichaTecnica.SSF2Nickname = "A selvagem criança da natureza.";
            //fichaTecnica.SFA3Nickname = "A animal pessoa amazônica.";
            //fichaTecnica.SF4Nickname = "Guerreiro da selva";
            //fichaTecnica.SFA3Stage = "Ramificação do Rio Madeira - pantano, Brasil (ramificação do rio Madeira: talvez possa ser Mato Grosso, ou Tocantins?).";
            //fichaTecnica.SF2Stage = "Bacia do rio Amazonas (Brasil)";
            //fichaTecnica.GolpesEspeciaisFamosos = "Electric Thunder, Rolling Attack.";
            //fichaTecnica.PersonagemOculto = false;
            CadastroModel cadastro = new CadastroModel();
            cadastro.Nascimento = DateTime.Parse("12/02/1966", new CultureInfo("pt-BR"));
            cadastro.Nome = "Blanka";
            cadastro.Imagem = @"~/Content/Imagens/blanka.png";
            cadastro.Altura = 192;
            cadastro.Peso = 96;
            cadastro.AbreviacaoPais = "BR";
            cadastro.GolpesEspeciais = "Electric Thunder, Rolling Attack.";
            cadastro.PersonagemOculto = false;
            return View(cadastro);
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

            CadastroModel retorno = new CadastroModel();
            retorno.Imagem = model.Imagem;
            retorno.Nome = model.Nome;
            retorno.Nascimento = model.Nascimento;
            retorno.Altura = model.Altura;
            retorno.Peso = model.Peso;
            retorno.AbreviacaoPais = model.AbreviacaoPais;
            retorno.GolpesEspeciais = model.GolpesEspeciais;
            retorno.PersonagemOculto = model.PersonagemOculto;

            return View("FichaTecnica", retorno);
        }

        private void PopularPais()
        {
            ViewData["ListaPaises"] = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "BR", Text = "Brasil" },
                new SelectListItem() { Value = "USA", Text = "Estados Unidos" },
                new SelectListItem() { Value = "CHI", Text = "Chile" },
                new SelectListItem() { Value = "GER", Text = "Alemanha" },
                new SelectListItem() { Value = "GRE", Text = "Grecia" }
            };
        }
    }
}