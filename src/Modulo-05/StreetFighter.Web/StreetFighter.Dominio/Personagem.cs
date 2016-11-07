using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {

        public string Imagem { get; set; }

        public DateTime Nascimento { get; set; }

        public int Altura { get; set; }

        public decimal Peso { get; set; }

        public string AbreviacaoPais { get; set; }

        public string GolpesEspeciais { get; set; }

        public bool PersonagemOculto { get; set; }

        public int Id { get; private set; }

        public string Nome { get; private set; }

        public Personagem (string imagem, DateTime nascimento, int altura, decimal peso, 
            string abreviacaoPais, string golpesEspeciais, bool personagemOculto, 
            int id, string nome) : this(id, nome)
        {
            if (abreviacaoPais.Equals("MP"))
                throw new RegraNegocioException("Somente um personagem pode ser dessa região e esse personagem não é o Nunes.");
            this.Imagem = imagem;
            this.Nascimento = nascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.AbreviacaoPais = abreviacaoPais;
            this.GolpesEspeciais = golpesEspeciais;
            this.PersonagemOculto = personagemOculto;
        }

        public Personagem(int id, string nome)
            : this(nome)
        {
                this.Id = id;
        }

        public Personagem(string nome)
        {
            if (nome.ToUpperInvariant().Contains("NUNES"))
                throw new RegraNegocioException("Não é permitido cadastrar um personagem overpowered.");

            this.Nome = nome;
        }

        public override bool Equals(object obj)
        {
            var objeto = obj as Personagem;

            if(objeto == null)
            {
                return false;
            }
            return this.Id == objeto.Id;
        }
    }
}
