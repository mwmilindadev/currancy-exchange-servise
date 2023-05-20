package com.microservises.currancyexchangeservise.repo;

import com.microservises.currancyexchangeservise.entity.CurrencyExchnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CurrencyExchnageRepo extends JpaRepository<CurrencyExchnage,Integer> {
    CurrencyExchnage findByFromAndTo(String from, String to);
}
