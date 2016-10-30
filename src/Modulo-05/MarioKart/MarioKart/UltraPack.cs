using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MarioKart.Equipamentos;

namespace MarioKart
{
    public class UltraPack : IEquipamento
    {
        public UltraPack(IEquipamento equipamento)
        {
            this.Equipamento = equipamento;
        }
        public int BonusEquipameto
        {
            get
            {
                return Equipamento.BonusEquipameto + Convert.ToInt16(Math.Ceiling(Equipamento.BonusEquipameto * 0.2));
            }
        }
        public IEquipamento Equipamento { get; private set; }
    }
}
