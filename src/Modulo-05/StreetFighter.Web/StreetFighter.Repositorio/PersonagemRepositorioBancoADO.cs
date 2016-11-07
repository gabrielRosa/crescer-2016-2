using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorioBancoADO : IPersonagemRepositorio
    {
        public Personagem BuscarPorId(int id)
        {
            string connectionString = ConfigurationManager
                                              .ConnectionStrings["ConexaoPersonagens"]
                                              .ConnectionString;

            Personagem retorno = null;

            using (SqlConnection conexao = new SqlConnection(connectionString))
            {
                conexao.Open();
                string sqlQuery = $"Select IDPersonagem From Personagens Where IDPersonagem == @param_Id";//nao usar na ordem errada
                var command = new SqlCommand(sqlQuery, conexao);
                command.Parameters.Add(new SqlParameter("param_Id", id));

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    retorno = ConvertReaderToPersonagem(reader);
                }

                conexao.Close();
            }

            return retorno;
        }

        public void EditarPersonagem(Personagem personagem)
        {
            throw new NotImplementedException();
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
            string connectionString = ConfigurationManager
                                              .ConnectionStrings["ConexaoPersonagens"]
                                              .ConnectionString;

            List<Personagem> personagens = new List<Personagem>();

            using (SqlConnection conexao = new SqlConnection(connectionString))
            {
                conexao.Open();
                string sqlQuery = "" ;//nao usar na ordem errada
                var command = new SqlCommand(sqlQuery, conexao);

                if (filtroNome == null)
                {
                    sqlQuery = $"Select Nome,Imagem,Nascimento,Altura,Peso,AbreviacaoPais,GolpesEspeciais,PersonagemOculto From Personagens ";
                }
                else
                {
                    sqlQuery = $"Select Nome From Personagens Where Nome Like @param_Nome";
                    command.Parameters.Add(new SqlParameter("param_Nome", filtroNome));
                }
                command.CommandText = sqlQuery;
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Personagem retorno = ConvertReaderToPersonagem(reader);
                    personagens.Add(retorno);
                }

                conexao.Close();
            }

            return personagens;
        }

        private Personagem ConvertReaderToPersonagem(SqlDataReader reader)
        {
            int idRow = Convert.ToInt32(reader["IDPersonagem"]);
            string nomeRow = reader["Nome"].ToString();
            string imagemRow = reader["Imagem"].ToString();
            DateTime nascimentoRow = Convert.ToDateTime(reader["Nascimento"]);
            int alturaRow = Convert.ToInt32(reader["Altura"]);
            decimal pesoRow = Convert.ToDecimal(reader["Peso"]);
            string abreviacaoPaisRow = reader["AbreviacaoPais"].ToString();
            string golpesEspeciaisRow = reader["GolpesEspeciais"].ToString();
            bool personagemOcultoRow = reader["PersonagemOculto"].ToString().Equals(0)? false : true;

            Personagem retorno = new Personagem(
                imagemRow,
                nascimentoRow,
                alturaRow,
                pesoRow,
                abreviacaoPaisRow,
                golpesEspeciaisRow,
                personagemOcultoRow,
                idRow,
                nomeRow);

            return retorno;
        }


    }
}
