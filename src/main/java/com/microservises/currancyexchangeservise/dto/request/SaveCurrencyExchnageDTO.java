package com.microservises.currancyexchangeservise.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaveCurrencyExchnageDTO {
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
}
