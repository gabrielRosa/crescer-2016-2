using StreetFighter.Dominio;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;

namespace StreetFighter.Repositorio
{
    public class DatabaseContext: DbContext
    {
        public DatabaseContext() : base("ConexaoStreetFighterEF")
        {

        }

        public DbSet<Personagem> User { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            base.OnModelCreating(modelBuilder);
        }
    }
}
