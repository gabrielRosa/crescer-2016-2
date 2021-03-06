import java.util.ArrayList;

public class Inventario{
    private ArrayList <Item> lista;

    public Inventario(){
        lista = new ArrayList<>();
    }

    public void adicionarItem(Item item){
        lista.add(item);
    }

    public void removerItem(Item item){
        lista.remove(item);
    }

    public ArrayList<Item> getItens(){
        return lista;
    }

    public Item itemMaisPopular(){
        int tamanho = lista.size();
        int maisPopular =0;
        Item item=null;
        for(int i=0;i<tamanho;i++){
            int quantidade =lista.get(i).getQuantidade();
            if(quantidade>maisPopular){
                maisPopular=quantidade;
                item = lista.get(i);
            }
        }
        return item;
    }

    public String getDescricoesItens(){
        int tamanho = lista.size();
        String retorno ="";
        for(int i=0;i<tamanho;i++){
            if(i==tamanho-1){
                retorno += lista.get(i).getDescricao();
            }else{
                retorno += lista.get(i).getDescricao() + ",";
            }
        }
        return retorno;
    }

    public void aumentarUnidadesDosItens(int unidades){
        for(int i=0;i<lista.size();i++){
            lista.get(i).aumentarUnidades(unidades);    
        }
    }

    /*DUVIDA Pergunatar na aula 
     * Posso chamar o metodo ordenarItens o sem parametro, passando o parametro ascendente para o metodo ordenarItens com parametro
     * Como otimizar este metodo
     */
    public void ordenarItens(){
        ordenarItens(TipoOrdenacao.ASCENDENTE);
    }
    /*
     * TODO: utilizar o set, refatorar o metodo
     */
    
    public void ordenarItens(TipoOrdenacao tipoOrdenacao){
        Item [] itens = new Item[lista.size()];
        for(int i=0;i<itens.length;i++){
            itens[i]=lista.get(0);
            lista.remove(0);
        }

        for(int j=0;j<itens.length;j++){
            for(int i =0;i<itens.length;i++){
                if(tipoOrdenacao == TipoOrdenacao.ASCENDENTE){
                    if(itens[j].getQuantidade()> itens[i].getQuantidade()){
                        Item item = itens[j];
                        itens[j]=itens[i];
                        itens[i] = item;
                    }
                }else{
                    if(itens[j].getQuantidade()< itens[i].getQuantidade()){
                        Item item = itens[j];
                        itens[j]=itens[i];
                        itens[i] = item;
                    }
                }
            }
        }

        for(int i=0;i<itens.length;i++){
            lista.add(0,itens[i]);
        }
    }
}

