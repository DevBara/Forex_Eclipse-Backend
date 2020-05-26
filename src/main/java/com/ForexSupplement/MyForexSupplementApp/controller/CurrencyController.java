package com.ForexSupplement.MyForexSupplementApp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ForexSupplement.MyForexSupplementApp.exception.ResourceNotFoundException;
import com.ForexSupplement.MyForexSupplementApp.model.Currency;
import com.ForexSupplement.MyForexSupplementApp.repository.CurrencyRepository;

@RestController
@RequestMapping("/ForexSupplement_api/v1")

public class CurrencyController{

	@Autowired
	private CurrencyRepository currencyRepository;
	
	@GetMapping("/currencies")
	public List<Currency> getAllCurrencies(Model model){
		return (List<Currency>) this.currencyRepository.findAll();
	}
	
	@GetMapping("/currencies/{id}")
		public ResponseEntity<Currency> getCurrencyById(@PathVariable(value ="id") Long currencyId)
			throws ResourceNotFoundException {
			Currency currency = currencyRepository.findById(currencyId)
					.orElseThrow(() -> new ResourceNotFoundException("This Currency does not exist ::" + currencyId));
				return ResponseEntity.ok().body(currency);	
	}
	
	@PostMapping("/currencies")
	public Currency createCurrency(@Valid @RequestBody Currency currency) {
		return currencyRepository.save(currency);
	}
	
//	Update Currencies
	
	@PutMapping("/currencies/{id}")
	public ResponseEntity<Currency> updateCurrency(@PathVariable(value ="id")Long currencyId,
			@Valid @RequestBody Currency currencyDetails)
			throws ResourceNotFoundException{
			Currency currency = currencyRepository.findById(currencyId)
					.orElseThrow(() -> new ResourceNotFoundException("Currency not found ::" + currencyId));
							
			currency.setCurrencyName(currencyDetails.getCurrencyName());
			currency.setCurrencyAmt(currencyDetails.getCurrencyAmt());
			currency.setCurrencyCode(currencyDetails.getCurrencyCode());
			currency.setCurrencyRate(currencyDetails.getCurrencyRate());
			
			final Currency updatedCurrency = currencyRepository.save(currency);
			
			return ResponseEntity.ok(updatedCurrency);
	}
	
//	Delete Currency
	
	@DeleteMapping("/currencies/{id}")
	public Map<String, Boolean> deletedCurrency(@PathVariable(value="id")Long currencyId)
					throws ResourceNotFoundException {
					Currency currency = currencyRepository.findById(currencyId)
							.orElseThrow(() -> new ResourceNotFoundException("Currency not found ::" + currencyId));
							
					currencyRepository.delete(currency);
					Map<String, Boolean> response =new HashMap<>();
					
					response.put("deleted currency", Boolean.TRUE);
					
					return response;
	}

}
