package com.microservises.currancyexchangeservise.servise;

import com.microservises.currancyexchangeservise.dto.request.SaveCurrencyExchnageDTO;
import com.microservises.currancyexchangeservise.entity.CurrencyExchnage;

public interface CurrancyExchangeServise {
    String saveExchange(SaveCurrencyExchnageDTO saveCurrencyExchnageDTO);

    CurrencyExchnage findValues(String from, String to);
}
