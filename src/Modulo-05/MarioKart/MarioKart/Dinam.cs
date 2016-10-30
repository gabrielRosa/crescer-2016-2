using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Corredores;
using MarioKart.Equipamentos;

namespace Karts
{
    public class Dinam : Kart
    {
        public Dinam(Corredor corredor) : base(corredor)
        {
        }

        protected override int CalcularVelocidade()
        {
            //BonusDeHabilidadeDoCorredor dobrado de acordo com a regra
            int BonusDeHabilidadeDoCorredor = 2*(this.CalculaBonusCorredor());
            int BonusEquipameto = 0;
            foreach (IEquipamento obj in Equipamentos)
            {
                BonusEquipameto += obj.BonusEquipameto;
            }
            return 3 + BonusEquipameto + BonusDeHabilidadeDoCorredor;
        }
    }
}
