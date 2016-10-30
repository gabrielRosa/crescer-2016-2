using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Corredores;
using MarioKart.Equipamentos;

namespace Karts
{
    public class Light : Kart
    {
        public Light(Corredor corredor) : base(corredor)
        {
        }

        protected override int CalcularVelocidade()
        {
            int BonusDeHabilidadeDoCorredor = 0;
            byte BonusDeVelocidadeParaNoob = 3;
            sbyte OnusDeVelocidadeParaProfissional = -1;
            switch (Corredor.NivelDeHabilidade)
            {
                case NivelDeHabilidade.Noob:
                    BonusDeHabilidadeDoCorredor = 3 + BonusDeVelocidadeParaNoob;
                    break;
                case NivelDeHabilidade.Mediano:
                    return base.CalcularVelocidade();
                case NivelDeHabilidade.Profissional:
                    BonusDeHabilidadeDoCorredor = 6 + Equipamentos.Count + OnusDeVelocidadeParaProfissional;
                    break;
            }
            int BonusEquipameto = 0;
            foreach (IEquipamento obj in Equipamentos)
            {
                BonusEquipameto += obj.BonusEquipameto;
            }
            return 3 + BonusEquipameto + BonusDeHabilidadeDoCorredor;
        }
    }
}
