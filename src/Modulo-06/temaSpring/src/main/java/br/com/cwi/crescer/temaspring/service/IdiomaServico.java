package br.com.cwi.crescer.temaspring.service;

// @author Gabriel
import br.com.cwi.crescer.temaspring.entity.Idioma;
import br.com.cwi.crescer.temaspring.repository.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdiomaServico {

    @Autowired
    private IdiomaRepository idiomaRepository;

    public void add(Idioma i) {
        idiomaRepository.save(i);
    }
}
