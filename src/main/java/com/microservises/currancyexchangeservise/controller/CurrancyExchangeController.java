package com.microservises.currancyexchangeservise.controller;

import com.microservises.currancyexchangeservise.dto.request.SaveCurrencyExchnageDTO;
import com.microservises.currancyexchangeservise.entity.CurrencyExchnage;
import com.microservises.currancyexchangeservise.servise.CurrancyExchangeServise;
import com.microservises.currancyexchangeservise.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/vi/exchange")
public class CurrancyExchangeController {
    @Autowired
    private CurrancyExchangeServise currancyExchangeServise;
    @PostMapping("/save")

    public ResponseEntity<StandardResponse>saveExchanges(@RequestBody SaveCurrencyExchnageDTO saveCurrencyExchnageDTO){
    String message=currancyExchangeServise.saveExchange(saveCurrencyExchnageDTO);
        return  new ResponseEntity<StandardResponse>(new StandardResponse(200,"Saved",message),HttpStatus.CREATED);
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")

    public ResponseEntity<StandardResponse> retrieveValue(@PathVariable String from, @PathVariable String to){
        CurrencyExchnage  currencyExchnage=currancyExchangeServise.findValues(from,to);
        if(currencyExchnage ==null){
            throw new RuntimeException("no data found");
        }
        //return new ResponseEntity<StandardResponse>(new StandardResponse(200,"OK",new CurrencyExchnage(1000L,from,to, BigDecimal.valueOf(50))), HttpStatus.OK);
        return new ResponseEntity<>(new StandardResponse(200,"ok",currencyExchnage),HttpStatus.OK);
        //return new CurrencyExchnage(1000L,from,to, BigDecimal.valueOf(50));

    }
}
