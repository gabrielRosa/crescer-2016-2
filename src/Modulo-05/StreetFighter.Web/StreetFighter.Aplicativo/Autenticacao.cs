using System.Linq;
using Infra;
using StreetFighter.Dominio;
using StreetFighter.Repositorio;

namespace StreetFighter.Aplicativo
{
    public class Autenticacao
    {
        public static Usuario BuscarUsuarioAutenticado(string nome, string senha)
        {
            UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();
            Usuario usuarioEncontrado = usuarioRepositorio.Ler(nome);

            string senhaDeComparacao =
                ServicoDeCriptografia.ConverterParaMD5($"{nome}_$_{senha}");

            if (usuarioEncontrado != null && usuarioEncontrado.Senha.Equals(senhaDeComparacao))
            {
                return usuarioEncontrado;
            }

            return null;
        }
    }
}
