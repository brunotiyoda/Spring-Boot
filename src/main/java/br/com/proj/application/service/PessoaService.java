package br.com.proj.application.service;

import br.com.proj.application.dao.PessoaDAO;
import br.com.proj.application.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaDAO pessoaDAO;

    public List<Pessoa> getPessoas() {
        return pessoaDAO.getPessoas();
    }
}
