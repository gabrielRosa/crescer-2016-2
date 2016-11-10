using Loja.Dominio;
using Loja.Tests.Mocks;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace Loja.Tests
{
    [TestClass]
    public class ProdutoServicoTestes
    {
        [TestMethod]
        public void DeveValidarComSucesso()
        {
            var produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto();
            produto.Id = 100;
            produto.Nome = "Eu";
            produto.Valor = 10;

            Assert.IsNotNull(produtoServico.ValidarProduto(produto));
        }

        [TestMethod]
        public void DeveValidarSemSucessoValorIncorretoNegativo()
        {
            var produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto();
            produto.Id = 100;
            produto.Nome = "Eu";
            produto.Valor = -10;

            bool passou = false;

            try
            {
                produtoServico.ValidarProduto(produto);
            }
            catch (ArgumentException)
            {
                passou = true;
            }
            catch
            {
                passou = false;
            }
            Assert.IsTrue(passou);
        }

        [TestMethod]
        public void DeveValidarSemSucessoValorIncorretoZero()
        {
            var produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto();
            produto.Id = 100;
            produto.Nome = "Eu";
            produto.Valor = 0;

            bool passou = false;

            try
            {
                produtoServico.ValidarProduto(produto);
            }
            catch (ArgumentException)
            {
                passou = true;
            }
            catch
            {
                passou = false;
            }
            Assert.IsTrue(passou);
        }

        [TestMethod]
        public void DeveValidarSemSucessoNomeComMenos2Caracteres()
        {
            var produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto();
            produto.Id = 100;
            produto.Nome = "E";
            produto.Valor = 10;

            bool passou = false;

            try
            {
                produtoServico.ValidarProduto(produto);
            }
            catch (ArgumentException)
            {
                passou = true;
            }
            catch
            {
                passou = false;
            }
            Assert.IsTrue(passou);
        }

        [TestMethod]
        public void DeveValidarSemSucessoNomeRepetido()
        {
            var produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto();
            produto.Id = 100;
            produto.Nome = "Nutella";
            produto.Valor = 10;

            bool passou = false;

            try
            {
                produtoServico.ValidarProduto(produto);
            }
            catch (ArgumentException)
            {
                passou = true;
            }
            catch
            {
                passou = false;
            }
            Assert.IsTrue(passou);
        }
    }
}
