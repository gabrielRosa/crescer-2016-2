package br.com.cwi.crescer.temaspring.service;

// @author Gabriel
import br.com.cwi.crescer.temaspring.entity.Classificacao;
import br.com.cwi.crescer.temaspring.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassificacaoServico {

    @Autowired
    private ClassificacaoRepository classificacaoRepository;

    public void add(Classificacao c) {
        classificacaoRepository.save(c);
    }
}
