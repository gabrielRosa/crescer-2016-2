using Corredores;
using MarioKart.Equipamentos;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Karts
{
    public class Kart
    {
        public Kart(Corredor corredor)
        {
            this.Corredor = corredor;
            Equipamentos = new ArrayList();
        }
        public Corredor Corredor { get; set; }
        public ArrayList Equipamentos { get; set; }
        private int velocidade;
        public int Velocidade {
            get
            {
                return CalcularVelocidade();
            }

            private set
            {
                this.Velocidade = value;
            }
        }

        public void AdicionarEquipamento(IEquipamento equipamento)
        {
            Equipamentos.Add(equipamento);
        }

        //calcula a velocidade de acordo com as especificações
        protected virtual int CalcularVelocidade()
        {
            int BonusDeHabilidadeDoCorredor = this.CalculaBonusCorredor();
            int BonusEquipameto = 0;
            foreach (IEquipamento obj in Equipamentos)
            {
                BonusEquipameto += obj.BonusEquipameto;
            }
            return 3 + BonusEquipameto + BonusDeHabilidadeDoCorredor;
        }

        protected virtual int CalculaBonusCorredor()
        {
            int BonusDeHabilidadeDoCorredor = 0;
            switch (Corredor.NivelDeHabilidade)
            {
                case NivelDeHabilidade.Noob:
                    BonusDeHabilidadeDoCorredor = 3;
                    break;
                case NivelDeHabilidade.Mediano:
                    BonusDeHabilidadeDoCorredor = 5;
                    break;
                case NivelDeHabilidade.Profissional:
                    BonusDeHabilidadeDoCorredor = 6 + Equipamentos.Count;
                    break;
            }
            return BonusDeHabilidadeDoCorredor;
        }
    }
}
