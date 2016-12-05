package br.com.cwi.crescer.converter;

// @author Gabriel
import br.com.cwi.crescer.entity.Elenco;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("elencoConverter")
public class ElencoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent uIComponent, String value) {
        if (value != null) {
            return this.getInComponent(uIComponent, value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        final Elenco elenco = (Elenco) value;
        if (elenco != null) {
            this.setInComponent(component, elenco);
            return elenco.getIdElenco().toString();
        }
        return null;
    }

    private void setInComponent(final UIComponent uIComponent, final Elenco elenco) {
        Map<Long, Elenco> elencos;
        elencos = (Map<Long, Elenco>) uIComponent.getAttributes().get("elencos");
        if (elencos == null) {
            elencos = new HashMap<>();
        }
        elencos.put(elenco.getIdElenco(), elenco);
        uIComponent.getAttributes().put("elencos", elencos);
    }

    private Object getInComponent(UIComponent uIComponent, String value) throws NumberFormatException {
        Map<Long, Elenco> elencos;
        elencos = (Map<Long, Elenco>) uIComponent.getAttributes().get("elencos");
        if (elencos != null) {
            return elencos.get(Long.valueOf(value));
        }
        return null;
    }

}
