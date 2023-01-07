package com.bms.weddingorganizationcompanysystem.helper;

import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;

import java.util.Random;

public class Generator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();
    private static final StringBuilder CODE = new StringBuilder();
    private static final Integer LENGTH = 10;

    private Generator() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static String generateCode(){
        for (int i = 0; i < LENGTH; i++) {
            CODE.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return CODE.toString();
    }
}
