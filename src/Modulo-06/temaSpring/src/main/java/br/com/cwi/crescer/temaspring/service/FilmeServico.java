package br.com.cwi.crescer.temaspring.service;

// @author Gabriel
import br.com.cwi.crescer.temaspring.entity.Filme;
import br.com.cwi.crescer.temaspring.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeServico {

    @Autowired
    private FilmeRepository filmeRepository;

    public void add(Filme f) {
        filmeRepository.save(f);
    }
}
