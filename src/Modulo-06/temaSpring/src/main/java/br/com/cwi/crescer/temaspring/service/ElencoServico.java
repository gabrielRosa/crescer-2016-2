package br.com.cwi.crescer.temaspring.service;

// @author Gabriel
import br.com.cwi.crescer.temaspring.entity.Elenco;
import br.com.cwi.crescer.temaspring.repository.ElencoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElencoServico {

    @Autowired
    private ElencoRepository elencoRepository;

    public void add(Elenco e) {
        elencoRepository.save(e);
    }
}
