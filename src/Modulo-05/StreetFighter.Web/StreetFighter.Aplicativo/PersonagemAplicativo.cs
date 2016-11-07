using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Aplicativo
{
    public class PersonagemAplicativo
    {
        private readonly IPersonagemRepositorio repositorio;

        public PersonagemAplicativo()
        {
            this.repositorio = new PersonagemRepositorio();
        }

        internal PersonagemAplicativo(IPersonagemRepositorio repositorio)
        {
            this.repositorio = repositorio;
        }

        public List<Personagem> ListarPersonagens(string filtroNome = null)
        {
            return repositorio.ListarPersonagens(filtroNome);
        }

        public Personagem PersonagensPorId(int id)
        {
            return repositorio.BuscarPorId(id);
        }

        public void ExcluirPersonagem(int id)
        {
            Personagem personagem = repositorio.BuscarPorId(id);
            repositorio.ExcluirPersonagem(personagem);
        }

        public void Salvar(Personagem personagem)
        {
            if (personagem.Id == 0)
            {
                repositorio.IncluirPersonagem(personagem);
            }
            else
                repositorio.EditarPersonagem(personagem);
        }

        public void EditarPersonagem(int id)
        {
            Personagem personagem = repositorio.BuscarPorId(id);
            repositorio.EditarPersonagem(personagem);
        }
    }
}
