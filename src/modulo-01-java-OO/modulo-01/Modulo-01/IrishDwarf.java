public class IrishDwarf extends Dwarf{

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento){
        super(nome, dataNascimento);
    }

    public IrishDwarf(){
        this(null, new DataTerceiraEra(1,1,1));
    }

    public void tentarSorte(){
        if(this.getNumeroSorte() == -3333){
            for(int j=0;j<super.inventario.getItens().size();j++){
                int numero=0;
                //Alternativa otimizada abaixo
                //int resultado = quantidadeAbsoluta * (quantidadeAbsoluta + 1) / 2;
                for(int i=Math.abs(super.inventario.getItens().get(j).getQuantidade()); i!=0 ;i--){
                    numero+=i;
                }
                super.inventario.getItens().get(j).aumentarUnidades(1000*numero);
            }
        }
    }
}
