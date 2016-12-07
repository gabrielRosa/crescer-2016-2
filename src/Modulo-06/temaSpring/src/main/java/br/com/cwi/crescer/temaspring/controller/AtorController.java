package br.com.cwi.crescer.temaspring.controller;

// @author Gabriel
import br.com.cwi.crescer.temaspring.entity.Ator;
import br.com.cwi.crescer.temaspring.service.AtorServico;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/ator")
public class AtorController {

    @Autowired
    private AtorServico atorServico;

    @RequestMapping(method = GET)
    public String toAtor(Model model) {
        Ator ator = new Ator();
        model.addAttribute(ator);
        return "ator";
    }

    @RequestMapping(method = POST)
    public void adicionar(@Valid Ator a) {
        atorServico.add(a);
    }
}
