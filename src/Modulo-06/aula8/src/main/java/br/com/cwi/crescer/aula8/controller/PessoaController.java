package br.com.cwi.crescer.aula8.controller;

// @author Gabriel
import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.service.PessoaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

    @Autowired
    private PessoaServico servico;

    @RequestMapping(value = "/pessoa.json", method = GET)
    public Iterable<Pessoa> list() {
        return servico.listAll();
    }

    @RequestMapping(value = "/pessoa.json", method = POST)
    public Iterable<Pessoa> add(@RequestBody Pessoa p) {
        servico.add(p);
        return servico.listAll();
    }
}
