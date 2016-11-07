using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using StreetFighter.Dominio;

namespace StreetFighter.Repositorio
{
    public class UsuarioRepositorio
    {
        private const string caminhoArquivo = @"C:\Users\Gabriel\Documents\GitHub\crescer-2016-2\src\Modulo-05\StreetFighter.Web\StreetFighter.Repositorio\Dados\DadosUsuario.txt";

        public void Adicionar(Usuario usuario)
        {
            List<string> usuarios = this.LeArquivo(caminhoArquivo);
            usuarios.Add(this.TransformarObjetoEmString(usuario));
            File.WriteAllLines(caminhoArquivo, usuarios);
        }
        //TODO: retirar o contains
        public Usuario Ler(string nome)
        {
            List<string> usuarios = this.LeArquivo(caminhoArquivo);
            Usuario usuario = new Usuario();
            //usuario = usuarios.Where(u => u.Contains(nome));
            return usuario;
        }

        private List<String> LeArquivo(String caminhoArquivo)
        {
            return File.ReadAllLines(caminhoArquivo).ToList();
        }

        private Usuario TransformaStringEmObjeto(string usuario)
        {
            string[] usuarioQuebrado = usuario.Split(';');
            Usuario retorno = new Usuario();
            retorno.Nome = usuarioQuebrado[0];
            retorno.Senha = usuarioQuebrado[1];
            //retorno.Permissoes = usuarioQuebrado[2]
            return retorno;
        }

        private string TransformarObjetoEmString(Usuario usuario)
        {
            if(usuario == null)
            {
                return null;
            }

            StringBuilder retorno = new StringBuilder();
            retorno.Append(usuario.Nome);
            retorno.Append(";");
            retorno.Append(usuario.Senha);
            retorno.Append(";");
            retorno.Append(usuario.Permissoes.ToString());
            retorno.Append(Environment.NewLine);

            return retorno.ToString();
        }
    }
}
