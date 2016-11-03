using System;

namespace StreetFighter.Dominio
{
    public class RegraNegocioException : Exception
    {
        public RegraNegocioException(string msg) : base(msg)
        { }
    }
}
