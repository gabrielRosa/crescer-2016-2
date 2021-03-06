﻿using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Corredores;
using Karts;
using MarioKart;

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

        [TestMethod]
        public void CalcularVelocidaParaYoshiMedianoComPneusDeCouroDeDragao()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            Kart meuKart = new Kart(corredor);
            meuKart.AdicionarEquipamento(new PneusDeCouroDeDragao());
            Assert.AreEqual(10, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiMedianoComMotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Mediano);
            Kart meuKart = new Kart(corredor);
            meuKart.AdicionarEquipamento(new MotorABaseDeLava());
            Assert.AreEqual(11, meuKart.Velocidade);
        }

        [TestMethod]
        public void CalcularVelocidaParaYoshiProfissionalComMotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Yoshi", NivelDeHabilidade.Profissional);
            Kart meuKart = new Kart(corredor);
            meuKart.AdicionarEquipamento(new MotorABaseDeLava());
            Assert.AreEqual(13, meuKart.Velocidade);
        }
    }
}
