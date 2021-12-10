package br.com.allangf.showdomilhaoapi.domain.exception;

import io.swagger.annotations.Api;
import springfox.documentation.spring.web.json.Json;

public class RuleOfException extends RuntimeException {

    public RuleOfException(String message) {
        super(message);
    }

}
