package br.com.cwi.crescer.aula8.service;

// @author Gabriel
import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServico {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Iterable<Pessoa> listAll() {
        return pessoaRepository.findAll();
    }

    public void add(Pessoa p) {
        pessoaRepository.save(p);
    }
}
