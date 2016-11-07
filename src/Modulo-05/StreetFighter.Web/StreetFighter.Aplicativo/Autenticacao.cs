using System.Linq;
using Infra;
using StreetFighter.Dominio;

namespace StreetFighter.Aplicativo
{
    public class Autenticacao
    {
        public static Usuario BuscarUsuarioAutenticado(string nome, string senha)
        {
            Usuario usuarioEncontrado = _usuarios.FirstOrDefault(
                usuario => usuario.Nome.Equals(nome));

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
