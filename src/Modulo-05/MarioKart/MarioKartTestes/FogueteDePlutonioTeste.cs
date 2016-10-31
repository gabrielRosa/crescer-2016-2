using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Corredores;
using Karts;
using MarioKart;

namespace MarioKartTestes
{
    [TestClass]
    public class FogueteDePlutonioTeste
    {
        [TestMethod]
        public void CalcularVelocidaParaYoshiMedianoComFogueteDePlutonioPadrao()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            Kart meuKart = new Kart(corredor);
            meuKart.AdicionarEquipamento(new FogueteDePlutonio());
            Assert.AreEqual(10, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiMedianoComFogueteDePlutonioComNivel5()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            Kart meuKart = new Kart(corredor);
            meuKart.AdicionarEquipamento(new FogueteDePlutonio(5));
            Assert.AreEqual(13, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiProfissionalComFogueteDePlutonioComNivel1()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Profissional);
            Kart meuKart = new Kart(corredor);
            meuKart.AdicionarEquipamento(new FogueteDePlutonio(1));
            Assert.AreEqual(11, meuKart.Velocidade);
        }
    }
}
