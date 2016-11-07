using System.Web;
using StreetFighter.Web.Models;

namespace StreetFighter.Web.Services
{
    public static class ServicoDeAutenticacao
    {
        private const string USUARIO_LOGADO_CHAVE = "USUARIO_LOGADO_CHAVE";
        public static void Autenticar(UsuarioLogadoModel model)
        {
            HttpContext.Current.Session[USUARIO_LOGADO_CHAVE] = model;
        }

        public static UsuarioLogadoModel UsuarioLogado
        {
            get
            {
                return (UsuarioLogadoModel)HttpContext.Current.Session[USUARIO_LOGADO_CHAVE];
            }
        }

    }
}