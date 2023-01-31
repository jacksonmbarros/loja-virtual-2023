package com.dev.backend.repository;

import com.dev.backend.entity.Permissao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
    List<Permissao> findByNome(String nome);
}
