package com.rocketfin.respository;

import com.rocketfin.entity.Income;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IncomesRespository extends CrudRepository<Income, Long> {

    Income save(Income income);

    List<Income> findAllById(Long id);

    Optional<Income> findById(Long id);
}
