using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Corredores;
using MarioKart.Equipamentos;

namespace Karts
{
    public class SkyFusion : Kart, IEquipamento
    {
        public SkyFusion(Corredor corredor) : base(corredor)
        {
        }

        public int BonusEquipameto
        {
            get
            {
                int bonusEquipameto = 0;
                foreach (IEquipamento obj in Equipamentos)
                {
                    bonusEquipameto += obj.BonusEquipameto;
                }
                int bonusDeHabilidadeDoCorredor = this.CalculaBonusCorredor();
                int velocidadeTotal = bonusEquipameto + bonusDeHabilidadeDoCorredor;
                if (velocidadeTotal > 12)
                {
                    velocidadeTotal += 5;
                }
                return velocidadeTotal;
            }
        }
    }
}
