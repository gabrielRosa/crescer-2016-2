using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Corredores;
using Karts;
using MarioKart;

namespace MarioKartTestes
{
    [TestClass]
    public class DinamTeste
    {
        [TestMethod]
        public void CalcularVelocidaParaProfissionalSemEquipamento()
        {
            Corredor corredor = new Corredor("Gabriel", NivelDeHabilidade.Profissional);
            Dinam meuKart = new Dinam(corredor);
            Assert.AreEqual(15, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaNoobSemEquipamento()
        {
            Corredor corredor = new Corredor("Gabriel", NivelDeHabilidade.Noob);
            Dinam meuKart = new Dinam(corredor);
            Assert.AreEqual(9, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaMedianoSemEquipamento()
        {
            Corredor corredor = new Corredor("Gabriel", NivelDeHabilidade.Mediano);
            Dinam meuKart = new Dinam(corredor);
            Assert.AreEqual(13, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiMedianoComPneusDeCouroDeDragao()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            Dinam meuKart = new Dinam(corredor);
            meuKart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            Assert.AreEqual(15, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiMedianoComMotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            Dinam meuKart = new Dinam(corredor);
            meuKart.AdicionarEquipamento(new MotorABaseDeLava());
            Assert.AreEqual(16, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiProfissionalComMotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Profissional);
            Dinam meuKart = new Dinam(corredor);
            meuKart.AdicionarEquipamento(new MotorABaseDeLava());
            Assert.AreEqual(20, meuKart.Velocidade);
        }
    }
}
