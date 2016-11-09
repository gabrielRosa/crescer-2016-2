using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorioEF : DbContext, IPersonagemRepositorio
    {
        public Personagem BuscarPorId(int id)
        {
            using(var context = new DatabaseContext())
            {
                Personagem personagemFound = context.Personagem.FirstOrDefault(personagem => personagem.Id == id);
                return personagemFound;
            }
        }

        public void EditarPersonagem(Personagem personagem)
        {
        
        
            using (var context = new DatabaseContext())
            {
                context.Entry<Personagem>(personagem).State = EntityState.Modified;
                context.SaveChanges();
            }
        
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
        }

        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            List<Personagem> personagens;
            using (var context = new DatabaseContext())
            {
                if(filtroNome == null)
                {
                    personagens = context.Personagem.ToList();
                }else
                {
                    personagens = context.Personagem.Where(personagem => personagem.Nome.Equals(filtroNome)).ToList();
                }
                
                return personagens;
            }
        }
    }
}
