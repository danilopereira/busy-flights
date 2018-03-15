package com.travix.medusa.busyflights.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneySerializer extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal value, JsonGenerator jGen, SerializerProvider sProvider) throws IOException, JsonProcessingException {

        jGen.writeString(value.setScale(2, RoundingMode.HALF_UP).toString());

    }

}