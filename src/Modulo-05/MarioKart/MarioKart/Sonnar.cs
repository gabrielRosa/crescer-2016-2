using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Corredores;

namespace Karts
{
    public class Sonnar : Kart
    {
        public Sonnar(Corredor corredor) : base(corredor)
        {
        }

        protected override int CalcularVelocidade()
        {
            bool temItem = Equipamentos.Count > 0;
            if (temItem)
            {
                return base.CalcularVelocidade() + 2;
            }

            return base.CalcularVelocidade(); 
        }
    }
}
