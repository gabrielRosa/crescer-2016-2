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
                string sqlQuery = $"Select IDPersonagem,Nome,Imagem,Nascimento,Altura,Peso,AbreviacaoPais,GolpesEspeciais,PersonagemOculto From Personagens Where IDPersonagem = @param_Id";//nao usar na ordem errada
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
            string connectionString = ConfigurationManager
                                  .ConnectionStrings["ConexaoPersonagens"]
                                  .ConnectionString;

            using (SqlConnection conexao = new SqlConnection(connectionString))
            {
                conexao.Open();
                string sqlQuery = $"UPDATE Personagens SET  Nome = @param_Nome ,Imagem = @param_Imagem ,Nascimento = @param_Nascimento,Altura = @param_Altura,Peso = @param_Peso,AbreviacaoPais = @param_AbreviacaoPais ,GolpesEspeciais = @param_GolpesEspeciais,PersonagemOculto = @param_PersonagemOculto WHERE IDPersonagem = @param_IDPersonagem";//nao usar na ordem errada
                var command = new SqlCommand(sqlQuery, conexao);
                command.Parameters.Add(new SqlParameter("param_IDPersonagem", personagem.Id));
                command.Parameters.Add(new SqlParameter("param_Nome", personagem.Nome));
                command.Parameters.Add(new SqlParameter("param_Imagem", personagem.Imagem));
                command.Parameters.Add(new SqlParameter("param_Nascimento", personagem.Nascimento));
                command.Parameters.Add(new SqlParameter("param_Altura", personagem.Altura));
                command.Parameters.Add(new SqlParameter("param_Peso", personagem.Peso));
                command.Parameters.Add(new SqlParameter("param_AbreviacaoPais", personagem.AbreviacaoPais));
                command.Parameters.Add(new SqlParameter("param_GolpesEspeciais", personagem.GolpesEspeciais));
                command.Parameters.Add(new SqlParameter("param_PersonagemOculto", personagem.PersonagemOculto));

                SqlDataReader reader = command.ExecuteReader();
                conexao.Close();
            }
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            string connectionString = ConfigurationManager
                      .ConnectionStrings["ConexaoPersonagens"]
                      .ConnectionString;

            using (SqlConnection conexao = new SqlConnection(connectionString))
            {
                conexao.Open();
                string sqlQuery = $"DELETE FROM Personagens WHERE IDPersonagem = @param_IDPersonagem";//nao usar na ordem errada
                var command = new SqlCommand(sqlQuery, conexao);
                command.Parameters.Add(new SqlParameter("param_IDPersonagem", personagem.Id));
                SqlDataReader reader = command.ExecuteReader();
                conexao.Close();
            }
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            string connectionString = ConfigurationManager
                      .ConnectionStrings["ConexaoPersonagens"]
                      .ConnectionString;

            using (SqlConnection conexao = new SqlConnection(connectionString))
            {
                conexao.Open();
                string sqlQuery = $"INSERT INTO Personagens (Nome , Imagem, Nascimento ,Altura,Peso,AbreviacaoPais,GolpesEspeciais,PersonagemOculto) VALUES (@param_Nome, @param_Imagem ,convert(datetime, @param_Nascimento,103) , @param_Altura, @param_Peso, @param_AbreviacaoPais , @param_GolpesEspeciais, @param_PersonagemOculto)";//nao usar na ordem errada
                var command = new SqlCommand(sqlQuery, conexao);
                command.Parameters.Add(new SqlParameter("param_Nome", personagem.Nome));
                command.Parameters.Add(new SqlParameter("param_Imagem", personagem.Imagem));
                command.Parameters.Add(new SqlParameter("param_Nascimento", personagem.Nascimento.ToString("dd/MM/yyyy")));
                command.Parameters.Add(new SqlParameter("param_Altura", personagem.Altura));
                command.Parameters.Add(new SqlParameter("param_Peso", personagem.Peso));
                command.Parameters.Add(new SqlParameter("param_AbreviacaoPais", personagem.AbreviacaoPais));
                command.Parameters.Add(new SqlParameter("param_GolpesEspeciais", personagem.GolpesEspeciais));
                command.Parameters.Add(new SqlParameter("param_PersonagemOculto", personagem.PersonagemOculto));

                SqlDataReader reader = command.ExecuteReader();
                conexao.Close();
            }
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
                string sqlQuery = "";//nao usar na ordem errada
                var command = new SqlCommand(sqlQuery, conexao);

                if (filtroNome == null)
                {
                    sqlQuery = $"Select Nome,IDPersonagem,Imagem,Nascimento,Altura,Peso,AbreviacaoPais,GolpesEspeciais,PersonagemOculto From Personagens ";
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
            bool personagemOcultoRow = reader["PersonagemOculto"].ToString().Equals(0) ? false : true;

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
