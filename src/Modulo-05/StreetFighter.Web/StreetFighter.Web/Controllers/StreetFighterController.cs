using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using StreetFighter.Web.Models;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        // GET: StreetFighter
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            FichaTecnicaModel fichaTecnica = new FichaTecnicaModel();
            fichaTecnica.PrimeiraAparicao = "Street Fighter II The World Warrior (1991).";
            fichaTecnica.Nascimento = DateTime.Parse();
            fichaTecnica.Altura = 192;
            fichaTecnica.Peso = 96;
            fichaTecnica.Medidas = "B198, C120, Q172.";
            fichaTecnica.TipoSanguineo = 'B';
            fichaTecnica.HabilidadesEspeciais = "Caçar, Eletricidade.";
            fichaTecnica.Gosta = "Frutas tropicais, Pirarucu, Sua mãe.";
            fichaTecnica.Desgosta = "Army ants (espécie de formiga).";
            fichaTecnica.EstiloDeLuta = "Luta Selvagem autodidata (Army Ants) / Capoeira.";
            fichaTecnica.Origem = "Brasil (lugar de nascença é provável como sendo Tailândia).";
            fichaTecnica.UmaFalaDeVitoria = "Ver você em ação é uma piada!";
            fichaTecnica.SSF2Nickname = "A selvagem criança da natureza.";
            fichaTecnica.SFA3Nickname = "A animal pessoa amazônica.";
            fichaTecnica.SF4Nickname = "Guerreiro da selva";
            fichaTecnica.SFA3Stage = "Ramificação do Rio Madeira - pantano, Brasil (ramificação do rio Madeira: talvez possa ser Mato Grosso, ou Tocantins?).";
            fichaTecnica.SF2Stage = "Bacia do rio Amazonas (Brasil)";
            fichaTecnica.GolpesEspeciaisFamosos = "Electric Thunder, Rolling Attack.";
            return View(fichaTecnica);
        }
    }
}