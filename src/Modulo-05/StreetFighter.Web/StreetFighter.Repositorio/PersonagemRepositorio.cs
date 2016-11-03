using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {
        private const string caminhoArquivo = @"~\StreetFighter.Web\StreetFighter.Repositorio\Dados\TextFile1.txt";

        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            IList<string> personagens = File.ReadAllLines(caminhoArquivo).ToList();
            personagens.Where(personagem => personagem.Contains(filtroNome)).ToList();




            return null;
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            File.AppendAllText(caminhoArquivo, Environment.NewLine + this.TransformaPersonagemParaString(personagem));
        }

        public void EditarPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        private string TransformaPersonagemParaString(Personagem personagem)
        {
            StringBuilder retorno = new  StringBuilder();
            retorno.Append(personagem.Id);
            retorno.Append(",");
            retorno.Append(personagem.Imagem);
            retorno.Append(",");
            retorno.Append(personagem.Nascimento.ToString());
            retorno.Append(",");
            retorno.Append(personagem.Altura);
            retorno.Append(",");
            retorno.Append(personagem.Peso);
            retorno.Append(",");
            retorno.Append(personagem.AbreviacaoPais);
            retorno.Append(",");
            retorno.Append(personagem.GolpesEspeciais);
            retorno.Append(",");
            retorno.Append(personagem.PersonagemOculto);
            retorno.Append(",");
            retorno.Append(personagem.Nome);
            retorno.Append(",");
            return retorno.ToString();
        }

        private Personagem MontarPersonagem(string personagem)
        {
            string[] personagemSemVirgula = personagem.Split(',');

        }
    }
}
