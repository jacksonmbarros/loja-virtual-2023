package com.dev.backend.service;

import com.dev.backend.dto.PessoaClienteRequestDTO;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaClienteRepository;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaClienteService {
    
    @Autowired
    private PessoaClienteRepository pessoaClienteRepository;
    
    @Autowired
    private PermissaoPessoaService permissaoPessoaService;
    
    @Autowired
    private EmailService emailService;
    
    public Pessoa registrar(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
        pessoa.setDataCriacao(new Date());
        Pessoa objetoNovo = pessoaClienteRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(objetoNovo);
        //emailService.enviarEmailTexto(objetoNovo.getEmail(), "Cadastro na Loja Virtual", "O registro na Loja Virtual foi realizado com sucesso. Em breve você receberá a senha de acesso por e-mail!!");
        Map<String, Object> propMap = new HashMap<>();
        propMap.put("nome", objetoNovo.getNome());
        propMap.put("mensagem", "Cadastro na Loja Virtual\", \"O registro na Loja Virtual foi realizado com sucesso. Em breve você receberá a senha de acesso por e-mail!!");
        emailService.enviarEmailTemplate(objetoNovo.getEmail(), "Cadastro na Loja Virtual", propMap);
        return objetoNovo;
    }
    
}
