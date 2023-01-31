package com.dev.backend.repository;

import com.dev.backend.entity.PermissaoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoPessoaRepository extends JpaRepository<PermissaoPessoa, Long> {
    
}
