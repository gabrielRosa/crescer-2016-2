package br.com.cwi.crescer.temaspring.controller;

// @author Gabriel
import br.com.cwi.crescer.temaspring.entity.Classificacao;
import br.com.cwi.crescer.temaspring.service.ClassificacaoServico;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/classificacao")
public class ClassificacaoController {

    @Autowired
    private ClassificacaoServico classificacaoServico;

    @RequestMapping(method = GET)
    public String toClassificacao(Model model) {
        Classificacao classificacao = new Classificacao();
        model.addAttribute(classificacao);
        return "classificacao";
    }

    @RequestMapping(method = POST)
    public void adicionar(@Valid Classificacao c) {
        classificacaoServico.add(c);
    }
}
