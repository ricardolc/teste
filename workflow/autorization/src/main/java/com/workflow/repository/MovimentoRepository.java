package com.workflow.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.workflow.domain.Movimento;

public interface MovimentoRepository extends CrudRepository<Movimento, Serializable> {

}
