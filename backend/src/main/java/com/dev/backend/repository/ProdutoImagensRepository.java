package com.dev.backend.repository;

import com.dev.backend.entity.ProdutoImagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoImagensRepository extends JpaRepository<ProdutoImagens, Long>{
    
}
