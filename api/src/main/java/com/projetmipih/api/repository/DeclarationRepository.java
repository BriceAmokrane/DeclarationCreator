package com.projetmipih.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projetmipih.api.model.Declaration;

@Repository
public interface DeclarationRepository extends CrudRepository<Declaration, Long>{
	
}
