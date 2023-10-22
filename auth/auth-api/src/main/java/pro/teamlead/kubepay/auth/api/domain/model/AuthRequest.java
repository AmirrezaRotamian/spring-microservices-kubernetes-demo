package pro.teamlead.kubepay.auth.api.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import pro.teamlead.kubepay.common.api.domain.exception.validation.ValidUserField;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class AuthRequest {

    @ValidUserField
    String user;

    @NotBlank
    String password;

    @JsonCreator
    public AuthRequest(@JsonProperty("user") String user,
                       @JsonProperty("password") String password) {
        this.user = user;
        this.password = password;
    }
}
