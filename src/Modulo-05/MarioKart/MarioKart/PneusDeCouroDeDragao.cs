using MarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart
{
    public class PneusDeCouroDeDragao : IEquipamento
    {
        public short BonusEquipameto
        {
            get
            {
                return 2;
            }
        }
    }
}
