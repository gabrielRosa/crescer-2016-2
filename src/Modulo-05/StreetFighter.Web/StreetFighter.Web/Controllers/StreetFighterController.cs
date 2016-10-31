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
            fichaTecnica.PrimeiraAparicao = "Street Fighter II The World Warrior (1991)";
            fichaTecnica.Nascimento = DateTime.Parse("ads");
            fichaTecnica.Altura = 192;
            fichaTecnica.Peso = 96;
            return View(fichaTecnica);
        }
    }
}