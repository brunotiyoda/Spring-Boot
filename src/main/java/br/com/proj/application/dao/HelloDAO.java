package br.com.proj.application.dao;

import br.com.proj.application.model.Hello;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class HelloDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Hello hello) {
        entityManager.persist(hello);
    }

}
