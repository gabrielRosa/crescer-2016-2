using FakeItEasy;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Aplicativo;
using StreetFighter.Dominio;

namespace StreetFighter.Testes.Aplicativo
{
    [TestClass]
    public class PersonagemAplicativoTest
    {
        [TestMethod]
        public void SalvarPersonagemComId0DeveIncluir()
        {
            var repositorioFake = A.Fake<IPersonagemRepositorio>();

            var aplicativo = new PersonagemAplicativo(repositorioFake);
            var personagem = new Personagem(0, "São Leopoldo");

            aplicativo.Salvar(personagem);

            A.CallTo(() => repositorioFake.IncluirPersonagem(personagem))
                .MustHaveHappened();
        }

        [TestMethod]
        public void SalvarPersonagemComDiferenteId0DeveEditar()
        {
            var repositorioFake = A.Fake<IPersonagemRepositorio>();

            var aplicativo = new PersonagemAplicativo(repositorioFake);
            var personagem = new Personagem(10, "Bison");

            aplicativo.Salvar(personagem);

            A.CallTo(() => repositorioFake.EditarPersonagem(personagem))
                .MustHaveHappened();
        }

        [TestMethod]
        public void ExcluirPersonagem()
        {
            var repositorioFake = A.Fake<IPersonagemRepositorio>();

            var aplicativo = new PersonagemAplicativo(repositorioFake);
            var personagem = new Personagem(10, "Bison");

            aplicativo.ExcluirPersonagem(10);

            A.CallTo(() => repositorioFake.ExcluirPersonagem(personagem))
                .MustHaveHappened();
        }
    }
}
