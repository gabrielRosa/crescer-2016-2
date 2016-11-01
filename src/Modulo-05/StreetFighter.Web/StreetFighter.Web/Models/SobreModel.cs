using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class SobreModel
    {
        public string PrimeiraAparicao { get; set; }
        public DateTime Nascimento { get; set; }
        public double Altura { get; set; }
        public double Peso { get; set; }
        public string Medidas { get; set; }
        public char TipoSanguineo { get; set; }
        public string HabilidadesEspeciais { get; set; }
        public string Gosta { get; set; }
        public string Desgosta { get; set; }
        public string EstiloDeLuta { get; set; }
        public string Origem { get; set; }
        public string UmaFalaDeVitoria { get; set; }
        public string GolpesEspeciaisFamosos { get; set; }
    }
}