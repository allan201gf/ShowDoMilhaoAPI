package br.com.allangf.showdomilhaoapi.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeMessage {

    private boolean isError;
    private int code;
    private String message;

}
