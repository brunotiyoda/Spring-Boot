package br.com.proj.application.dao;

import br.com.proj.application.model.Pessoa;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PessoaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Pessoa> getPessoas() {
        String jpql;
        jpql = "select p from Pessoa p";

        return entityManager.createQuery(jpql, Pessoa.class).getResultList();
    }

}
