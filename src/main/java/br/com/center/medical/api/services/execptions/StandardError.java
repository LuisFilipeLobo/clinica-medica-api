package br.com.center.medical.api.services.execptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {

    private Instant timestamp;
    private HttpStatus httpStatus;
    private String error;
    private String message;
    private String path;

}
