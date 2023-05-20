package com.microservises.currancyexchangeservise.servise.impl;

import com.microservises.currancyexchangeservise.dto.request.SaveCurrencyExchnageDTO;
import com.microservises.currancyexchangeservise.entity.CurrencyExchnage;
import com.microservises.currancyexchangeservise.repo.CurrencyExchnageRepo;
import com.microservises.currancyexchangeservise.servise.CurrancyExchangeServise;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrancyExchangeImpl implements CurrancyExchangeServise {

    @Autowired
    private CurrencyExchnageRepo currencyExchnageRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveExchange(SaveCurrencyExchnageDTO saveCurrencyExchnageDTO) {
        CurrencyExchnage currencyExchnage=modelMapper.map(saveCurrencyExchnageDTO,CurrencyExchnage.class);
        currencyExchnageRepo.save(currencyExchnage);

        return "Saved"+saveCurrencyExchnageDTO.getFrom();
    }

    @Override
    public CurrencyExchnage findValues(String from, String to) {
        CurrencyExchnage currencyExchnage=currencyExchnageRepo.findByFromAndTo(from,to);
        return currencyExchnage;
    }
}
