using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Corredores;
using Karts;
using MarioKart;

namespace MarioKartTestes
{
    [TestClass]
    public class SonnarTeste
    {
        [TestMethod]
        public void CalcularVelocidaParaProfissionalSemEquipamento()
        {
            Corredor corredor = new Corredor("Gabriel", NivelDeHabilidade.Profissional);
            Sonnar meuKart = new Sonnar(corredor);
            Assert.AreEqual(9, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaNoobSemEquipamento()
        {
            Corredor corredor = new Corredor("Gabriel", NivelDeHabilidade.Noob);
            Sonnar meuKart = new Sonnar(corredor);
            Assert.AreEqual(6, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaMedianoSemEquipamento()
        {
            Corredor corredor = new Corredor("Gabriel", NivelDeHabilidade.Mediano);
            Sonnar meuKart = new Sonnar(corredor);
            Assert.AreEqual(8, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiMedianoComPneusDeCouroDeDragao()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            Sonnar meuKart = new Sonnar(corredor);
            meuKart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            Assert.AreEqual(12, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiMedianoComMotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            Sonnar meuKart = new Sonnar(corredor);
            meuKart.AdicionarEquipamento(new MotorABaseDeLava());
            Assert.AreEqual(13, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiProfissionalComMotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Profissional);
            Sonnar meuKart = new Sonnar(corredor);
            meuKart.AdicionarEquipamento(new MotorABaseDeLava());
            Assert.AreEqual(15, meuKart.Velocidade);
        }
    }
}
