package br.com.cwi.crescer.aula3tema.repository;

import java.util.List;

public interface IDAO<T, ID> {

    void insert(T t);

    void delete(T t);

    void update(T t);

    List<T> list();

}
