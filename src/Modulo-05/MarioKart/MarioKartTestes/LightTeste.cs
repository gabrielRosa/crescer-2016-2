using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Corredores;
using Karts;
using MarioKart;

namespace MarioKartTestes
{
    [TestClass]
    public class LightTeste
    {
        [TestMethod]
        public void CalcularVelocidaParaProfissionalSemEquipamento()
        {
            Corredor corredor = new Corredor("Gabriel", NivelDeHabilidade.Profissional);
            Light meuKart = new Light(corredor);
            Assert.AreEqual(8, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaNoobSemEquipamento()
        {
            Corredor corredor = new Corredor("Gabriel", NivelDeHabilidade.Noob);
            Light meuKart = new Light(corredor);
            Assert.AreEqual(9, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaMedianoSemEquipamento()
        {
            Corredor corredor = new Corredor("Gabriel", NivelDeHabilidade.Mediano);
            Light meuKart = new Light(corredor);
            Assert.AreEqual(8, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiMedianoComPneusDeCouroDeDragao()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            Light meuKart = new Light(corredor);
            meuKart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            Assert.AreEqual(10, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiMedianoComMotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            Light meuKart = new Light(corredor);
            meuKart.AdicionarEquipamento(new MotorABaseDeLava());
            Assert.AreEqual(11, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiProfissionalComMotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Profissional);
            Light meuKart = new Light(corredor);
            meuKart.AdicionarEquipamento(new MotorABaseDeLava());
            Assert.AreEqual(12, meuKart.Velocidade);
        }
    }
}
