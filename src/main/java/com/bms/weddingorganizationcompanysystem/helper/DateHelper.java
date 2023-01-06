package com.bms.weddingorganizationcompanysystem.helper;

import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateHelper {
    private DateHelper() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
}
