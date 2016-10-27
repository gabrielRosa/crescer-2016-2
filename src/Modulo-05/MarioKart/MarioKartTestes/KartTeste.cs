using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Corredores;
using Karts;


namespace MarioKartTestes
{
    [TestClass]
    public class KartTeste
    {
        [TestMethod]
        public void CalcularVelocidaParaProfissionalSemEquipamento()
        {
            Corredor corredor = new Corredor("Gabriel", NivelDeHabilidade.Profissional);
            Kart meuKart = new Kart(corredor);
            Assert.AreEqual(9, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaNoobSemEquipamento()
        {
            Corredor corredor = new Corredor("Gabriel", NivelDeHabilidade.Noob);
            Kart meuKart = new Kart(corredor);
            Assert.AreEqual(6, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaMedianoSemEquipamento()
        {
            Corredor corredor = new Corredor("Gabriel", NivelDeHabilidade.Mediano);
            Kart meuKart = new Kart(corredor);
            Assert.AreEqual(8, meuKart.Velocidade);
        }
    }
}
