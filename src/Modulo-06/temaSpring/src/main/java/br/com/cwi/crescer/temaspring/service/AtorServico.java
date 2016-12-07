package br.com.cwi.crescer.temaspring.service;

// @author Gabriel
import br.com.cwi.crescer.temaspring.entity.Ator;
import br.com.cwi.crescer.temaspring.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtorServico {

    @Autowired
    private AtorRepository atorRepository;

    public void add(Ator a) {
        atorRepository.save(a);
    }
    
    public Iterable<Ator> list() {
        return atorRepository.findAll();
    }
}
