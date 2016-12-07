package br.com.cwi.crescer.temaspring.service;

// @author Gabriel
import br.com.cwi.crescer.temaspring.entity.Genero;
import br.com.cwi.crescer.temaspring.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServico {

    @Autowired
    private GeneroRepository generoRepository;

    public void add(Genero g) {
        generoRepository.save(g);
    }
}
