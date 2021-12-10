package br.com.allangf.showdomilhaoapi.domain.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    @Getter
    private boolean isError;
    @Getter
    private int code;
    @Getter
    private String message;

    public ApiErrors(String errorMessage) {

        int code = Integer.parseInt(errorMessage.substring(0, 4));
        int errorMessageSize = errorMessage.length();
        String message = errorMessage.substring(5, errorMessageSize);

        this.isError = true;
        this.code = code;
        this.message = message;
    }

}
