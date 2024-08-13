package com.example.myspring.tools;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;

public class LongToDateDeserializer extends JsonDeserializer<Date> {
    public LongToDateDeserializer() {
    }

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return p != null && p.getText() != null && !"".equals(p.getText()) ? new Date(Long.parseLong(p.getText())) : null;
    }
}
