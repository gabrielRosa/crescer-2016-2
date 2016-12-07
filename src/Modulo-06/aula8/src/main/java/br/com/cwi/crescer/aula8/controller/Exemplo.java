package br.com.cwi.crescer.aula8.controller;

// @author Gabriel
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Exemplo {

    @RequestMapping(value = "/", method = GET)
    String toIndex(Model model, @RequestParam(required = false) String nome) {
        model.addAttribute("name", nome == null ? "Carlos H. Nonnemacher" : nome);
        return "index";
    }
}
