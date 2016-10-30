using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Corredores;
using Karts;
using MarioKart;

namespace MarioKartTestes
{
    [TestClass]
    public class SkyFusionTeste
    {
        [TestMethod]
        public void CalcularVelocidaParaProfissionalSemEquipamento()
        {
            Corredor corredor = new Corredor("Gabriel", NivelDeHabilidade.Profissional);
            SkyFusion meuKart = new SkyFusion(corredor);
            Assert.AreEqual(9, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaNoobSemEquipamento()
        {
            Corredor corredor = new Corredor("Gabriel", NivelDeHabilidade.Noob);
            SkyFusion meuKart = new SkyFusion(corredor);
            Assert.AreEqual(6, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaMedianoSemEquipamento()
        {
            Corredor corredor = new Corredor("Gabriel", NivelDeHabilidade.Mediano);
            SkyFusion meuKart = new SkyFusion(corredor);
            Assert.AreEqual(8, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiMedianoComPneusDeCouroDeDragao()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            SkyFusion meuKart = new SkyFusion(corredor);
            meuKart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            Assert.AreEqual(10, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiMedianoComMotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            SkyFusion meuKart = new SkyFusion(corredor);
            meuKart.AdicionarEquipamento(new MotorABaseDeLava());
            Assert.AreEqual(11, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiProfissionalComMotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Profissional);
            SkyFusion meuKart = new SkyFusion(corredor);
            meuKart.AdicionarEquipamento(new MotorABaseDeLava());
            Assert.AreEqual(13, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiProfissionalComSkyFusion()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Profissional);
            SkyFusion meuKart = new SkyFusion(corredor);
            meuKart.AdicionarEquipamento(new SkyFusion(corredor));
            Assert.AreEqual(16, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiProfissionalComSkyFusionComMaisUmSkyFusion()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Profissional);
            SkyFusion meuKart = new SkyFusion(corredor);
            SkyFusion equipamentoSuperior = new SkyFusion(corredor);
            SkyFusion equipamentoInferior = new SkyFusion(corredor);
            equipamentoSuperior.AdicionarEquipamento(equipamentoInferior);
            meuKart.AdicionarEquipamento(equipamentoSuperior);
            Assert.AreEqual(28, meuKart.Velocidade);
        }
    }
}
