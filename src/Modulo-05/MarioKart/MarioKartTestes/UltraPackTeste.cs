using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Corredores;
using Karts;
using MarioKart;

namespace MarioKartTestes
{
    [TestClass]
    public class UltraPackTeste
    {
        [TestMethod]
        public void CalcularVelocidaParaYoshiMedianoComUltraPackoEPneusDeCouroDeDragao()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            Kart meuKart = new Kart(corredor);
            meuKart.AdicionarEquipamento(new UltraPack(new PneusDeCouroDeDragao()));
            Assert.AreEqual(11, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiMedianoComUltraPackoEMotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            Kart meuKart = new Kart(corredor);
            meuKart.AdicionarEquipamento(new UltraPack(new MotorABaseDeLava()));
            Assert.AreEqual(12, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiMedianoComUltraPackoEUltraPackoEMotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            Kart meuKart = new Kart(corredor);
            meuKart.AdicionarEquipamento(new UltraPack(new UltraPack(new MotorABaseDeLava())));
            Assert.AreEqual(13, meuKart.Velocidade);
        }
    }
}
