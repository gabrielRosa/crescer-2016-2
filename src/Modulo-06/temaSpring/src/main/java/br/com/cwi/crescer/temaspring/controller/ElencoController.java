package br.com.cwi.crescer.temaspring.controller;

// @author Gabriel
import br.com.cwi.crescer.temaspring.entity.Elenco;
import br.com.cwi.crescer.temaspring.service.ElencoServico;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/elenco")
public class ElencoController {

    @Autowired
    private ElencoServico elencoServico;

    @RequestMapping(method = GET)
    public String toElenco(Model model) {
        Elenco elenco = new Elenco();
        model.addAttribute(elenco);
        return "elenco";
    }

    @RequestMapping(method = POST)
    public void adicionar(@Valid Elenco e) {
        elencoServico.add(e);
    }
}
