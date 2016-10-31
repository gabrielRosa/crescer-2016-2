using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MarioKart.Equipamentos;

namespace MarioKart
{
    public class FogueteDePlutonio : IEquipamento
    {
        public FogueteDePlutonio(byte nivel = 2)
        {
            this.Nivel = nivel;
        }
        public int BonusEquipameto
        {
            get
            {
                return this.Nivel;
            }
        }
        private byte nivel;
        public byte Nivel
        {
            get
            {
                return this.nivel;
            }
            set
            {
               if(this.nivel < 1 && this.nivel > 5)
                {
                    this.nivel = 2;
                }
                this.nivel = value;
            }
        }
    }
}
