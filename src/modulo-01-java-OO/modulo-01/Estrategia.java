import java.util.List;
public interface Estrategia{
    List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes) throws ContingenteDesproporcionalException;
}
