package com.example.myspring.tools;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToLongDeserialize extends JsonDeserializer<Long> {
    public DateToLongDeserialize() {
    }

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        try {
            return p != null && p.getText() != null && !"".equals(p.getText()) ? dateFormat.parse(p.readValueAs(String.class)).getTime() : null;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}