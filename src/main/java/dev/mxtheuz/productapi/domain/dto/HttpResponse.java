package dev.mxtheuz.productapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HttpResponse {
    private int status;
    private String message;
    private Object content;

    public HttpResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.content = null;
    }
}
