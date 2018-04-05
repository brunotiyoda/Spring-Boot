package br.com.proj.application.controller;

import br.com.proj.application.model.Pessoa;
import br.com.proj.application.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping("/listaPessoas")
    @ResponseBody
    @Transactional
    public List<Pessoa> getPessoas() {
        return pessoaService.getPessoas();
    }
}
