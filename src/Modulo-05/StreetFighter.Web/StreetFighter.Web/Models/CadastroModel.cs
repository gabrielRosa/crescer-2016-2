using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class CadastroModel
    {
        [DisplayName("Imagem")]
        public string Imagem { get; set; }

        [DisplayName("Nome:")]
        public string Nome { get; set; }

        [DisplayName("Nascimento")]
        public DateTime Nascimento { get; set; }

        [DisplayName("Altura")]
        public int Altura { get; set; }

        [DisplayName("Peso")]
        public decimal Peso { get; set; }

        [DisplayName("País")]
        public string AbreviacaoPais { get; set; }

        [DisplayName("Golpes Especiais")]
        public string GolpesEspeciais { get; set; }

        [DisplayName("Personagem Oculto")]
        public bool PersonagemOculto { get; set; }
    }
}