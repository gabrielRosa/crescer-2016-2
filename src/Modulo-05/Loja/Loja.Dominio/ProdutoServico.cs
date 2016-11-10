using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoServico
    {
        private IProdutoRepositorio produtoRepositorio;

        public ProdutoServico(IProdutoRepositorio produtoRepositorio)
        {
            this.produtoRepositorio = produtoRepositorio;
        }

        public Produto ValidarProduto(Produto produto)
        {
            bool nomeComMenosDe2Caracteres = produto.Nome.Length < 2;
            bool valorMenorQueZero = produto.Valor <= 0;

            if(nomeComMenosDe2Caracteres)
                throw new ArgumentException("Deve ter mais de 2 caracteres!");

            if(valorMenorQueZero)
                throw new ArgumentException("Valor negativo ou zero!");

            bool temProdutoComMesmoNome = produtoRepositorio.ListarProdutos().Where(p => p.Nome.Equals(produto.Nome)).Count() != 0;
            if (temProdutoComMesmoNome)
                throw new ArgumentException("Já existe um  produto com este nome!");

            return produto;
        }
    }
}
