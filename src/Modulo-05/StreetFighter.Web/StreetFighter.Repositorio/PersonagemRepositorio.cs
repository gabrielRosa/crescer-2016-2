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
        private const string caminhoArquivo = @"C:\Users\Gabriel\Documents\GitHub\crescer-2016-2\src\Modulo-05\StreetFighter.Web\StreetFighter.Repositorio\Dados\Dados.txt";

        public List<Personagem> ListarPersonagens(string filtroNome = null)
        {
            List<string> personagens = this.LeArquivo(caminhoArquivo);
            if(filtroNome == null)
            {
                for (int i = 0; i < personagens.Count; i++)
                {
                    if (string.IsNullOrEmpty(personagens[i]))
                        personagens.Remove(personagens[i]);
                }
                return this.ListaPersonagemDeStringParaObjeto(personagens);
            }
            List<string> personagensFiltrados = personagens.Where(personagem => personagem.Contains(filtroNome)).ToList();
            return this.ListaPersonagemDeStringParaObjeto(personagensFiltrados);
        }

        public Personagem BuscarPorId(int id)
        {
            List<string> personagens = this.LeArquivo(caminhoArquivo);
            List<string> personagemDoId = personagens.Where(personagem => personagem.Contains(id.ToString())).ToList();
            return this.ListaPersonagemDeStringParaObjeto(personagemDoId).FirstOrDefault();
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            List<string> personagens = this.LeArquivo(caminhoArquivo);
            personagens.Add(this.TransformaPersonagemParaString(personagem));

            File.WriteAllLines(caminhoArquivo, personagens.ToList());     
        }

        public void EditarPersonagem(Personagem personagem)
        {
            List<string> personagensString = this.LeArquivo(caminhoArquivo);
            List<Personagem> personagensObjeto = this.ListaPersonagemDeStringParaObjeto(personagensString);
            for(int i = 0; i< personagensObjeto.Count; i++)
            {
                if(personagensObjeto[i].Id != null && personagensObjeto[i].Id== personagem.Id)
                {
                    personagensObjeto.RemoveAt(i);
                    personagensObjeto.Insert(i, personagem);
                    break;
                }
            }
            this.GravarPersonagemObjeto(personagensObjeto);
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            List<string> personagensString = this.LeArquivo(caminhoArquivo);

            List<Personagem> personagensObjeto = this.ListaPersonagemDeStringParaObjeto(personagensString);
            personagensObjeto.Remove(personagem);
            this.GravarPersonagemObjeto(personagensObjeto);
        }

        private string TransformaPersonagemParaString(Personagem personagem)
        {
            if(personagem == null)
            {
                return null;
            }
            StringBuilder retorno = new  StringBuilder();
            retorno.Append(personagem.Id==0? GerarId():personagem.Id);
            retorno.Append(";");
            retorno.Append(personagem.Imagem);
            retorno.Append(";");
            retorno.Append(personagem.Nascimento.ToString("dd'/'MM'/'yyyy"));
            retorno.Append(";");
            retorno.Append(personagem.Altura);
            retorno.Append(";");
            retorno.Append(personagem.Peso);
            retorno.Append(";");
            retorno.Append(personagem.AbreviacaoPais);
            retorno.Append(";");
            retorno.Append(personagem.GolpesEspeciais);
            retorno.Append(";");
            retorno.Append(personagem.PersonagemOculto);
            retorno.Append(";");
            retorno.Append(personagem.Nome);
            retorno.Append(";");
            retorno.Append(Environment.NewLine);
            return retorno.ToString();
        }

        private Personagem MontarPersonagem(string personagem)
        {
            if (string.IsNullOrEmpty(personagem))
            {
                return null;
            }
            string[] personagemSemVirgula = personagem.Split(';');
            int id = Convert.ToInt32(personagemSemVirgula[0]);
            string imagem = personagemSemVirgula[1];
            string[] data = personagemSemVirgula[2].Split('/');
            int dia = Convert.ToInt32(data[0]);
            int mes = Convert.ToInt32(data[1]);
            int ano = Convert.ToInt32(data[2]);
            int altura = Convert.ToInt32(personagemSemVirgula[3]);
            decimal peso = Convert.ToDecimal(personagemSemVirgula[4]);
            string abreviacaoPais = personagemSemVirgula[5];
            string golpesEspeciais = personagemSemVirgula[6];
            bool personagemOculto = Convert.ToBoolean(personagemSemVirgula[7]);
            string nome = personagemSemVirgula[8];

            Personagem retorno = new Personagem(imagem, new DateTime(ano, mes, dia), altura, peso, abreviacaoPais, golpesEspeciais, personagemOculto, id, nome);
            return retorno;
        }

        private List<Personagem> ListaPersonagemDeStringParaObjeto(List<string> personagemString)
        {
            List<Personagem> retorno = new List<Personagem>();
            foreach (var p in personagemString)
            {
                retorno.Add(this.MontarPersonagem(p));
            }
            return retorno;
        }

        private List<String> LeArquivo(String caminhoArquivo)
        {
            return File.ReadAllLines(caminhoArquivo).ToList();
        }

        private void GravarPersonagemObjeto(List<Personagem> personagensObjeto)
        {
            List<string> personagensString = new List<string>();
            foreach (var ps in personagensObjeto)
            {
                personagensString.Add(this.TransformaPersonagemParaString(ps));
            }

            File.WriteAllLines(caminhoArquivo, personagensString);
        }

        private int GerarId()
        {
            Random random = new Random();
            return random.Next();
        }
    }
}
