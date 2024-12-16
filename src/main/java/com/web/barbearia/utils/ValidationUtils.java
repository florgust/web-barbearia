package com.web.barbearia.utils;

import java.time.Duration;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidationUtils {
    Duration parseDuration(String tempoDuracao) {
        return Duration.parse("PT" + tempoDuracao.replaceAll(":", "H") + "M");
    }
}
