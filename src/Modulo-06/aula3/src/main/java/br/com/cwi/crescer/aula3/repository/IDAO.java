package br.com.cwi.crescer.aula3.repository;

import java.util.List;

public interface IDAO<T, ID> {

    void insert(T t);

    T find(ID id);

    void delete(T t);

    List<T> findAll();

    List<T> findByName(String nome);
    
    List<T> findByName(T t);
}
