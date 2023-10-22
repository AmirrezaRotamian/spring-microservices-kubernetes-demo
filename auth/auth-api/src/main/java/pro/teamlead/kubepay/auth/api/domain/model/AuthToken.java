package pro.teamlead.kubepay.auth.api.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Value
public class AuthToken {

    @NotBlank
    String token;

    @JsonCreator
    public AuthToken(@JsonProperty("token") String token) {
        this.token = token;
    }
}
