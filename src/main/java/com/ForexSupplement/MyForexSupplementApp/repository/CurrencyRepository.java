package com.ForexSupplement.MyForexSupplementApp.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ForexSupplement.MyForexSupplementApp.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
	
	

    
}
