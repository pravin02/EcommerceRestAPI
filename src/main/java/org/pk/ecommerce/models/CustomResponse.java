package org.pk.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponse {
    private Boolean status = Boolean.FALSE;
    private String message;
    private Object data;

    public CustomResponse(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

}
