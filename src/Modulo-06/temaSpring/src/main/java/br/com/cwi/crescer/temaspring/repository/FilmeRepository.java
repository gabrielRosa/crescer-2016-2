/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.temaspring.repository;

import br.com.cwi.crescer.temaspring.entity.Filme;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Gabriel
 */
public interface FilmeRepository extends CrudRepository<Filme, Long>{
    
}
