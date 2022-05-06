package com.eluanps.sistemacontrole.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eluanps.sistemacontrole.models.ServicosPrestados;


public interface ServicosPrestadosRepository extends JpaRepository<ServicosPrestados, Integer>{

	@Query(" select s from ServicosPrestados s join s.cliente c where upper(c.nome) like upper(:nome) and MONTH(s.dataServico) =:mes ")
	List<ServicosPrestados> findByNomeClienteAndMes(@Param("nome") String string, @Param("mes") Integer mes);

}
