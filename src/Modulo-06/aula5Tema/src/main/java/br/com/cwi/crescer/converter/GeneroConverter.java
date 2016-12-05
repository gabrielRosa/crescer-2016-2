package br.com.cwi.crescer.converter;

// @author Gabriel
import br.com.cwi.crescer.entity.Genero;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("generoConverter")
public class GeneroConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent uIComponent, String value) {
        if (value != null) {
            return this.getInComponent(uIComponent, value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent uIComponent, Object value) {
        final Genero genero = (Genero) value;
        if (genero != null) {
            this.setInComponent(uIComponent, genero);
            return genero.getIdGenero().toString();
        }
        return null;
    }

    private void setInComponent(final UIComponent uIComponent, final Genero genero) {
        Map<Long, Genero> generos;
        generos = (Map<Long, Genero>) uIComponent.getAttributes().get("generos");
        if (generos == null) {
            generos = new HashMap<>();
        }
        generos.put(genero.getIdGenero(), genero);
        uIComponent.getAttributes().put("generos", generos);
    }

    private Object getInComponent(UIComponent uIComponent, String value) throws NumberFormatException {
        Map<Long, Genero> generos;
        generos = (Map<Long, Genero>) uIComponent.getAttributes().get("generos");
        if (generos != null) {
            return generos.get(Long.valueOf(value));
        }
        return null;
    }

}
