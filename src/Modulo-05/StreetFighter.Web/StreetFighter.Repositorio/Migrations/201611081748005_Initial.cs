namespace StreetFighter.Repositorio.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Personagem",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Imagem = c.String(),
                        Nascimento = c.DateTime(nullable: false),
                        Altura = c.Int(nullable: false),
                        Peso = c.Decimal(nullable: false, precision: 18, scale: 2),
                        AbreviacaoPais = c.String(),
                        GolpesEspeciais = c.String(),
                        PersonagemOculto = c.Boolean(nullable: false),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropTable("dbo.Personagem");
        }
    }
}
