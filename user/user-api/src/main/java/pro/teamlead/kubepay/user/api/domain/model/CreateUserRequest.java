package pro.teamlead.kubepay.user.api.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import pro.teamlead.kubepay.common.api.domain.exception.validation.ValidUserField;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
public class CreateUserRequest {

    @ValidUserField
    private String user;

    @NotBlank
    private String passwordHash;

    @JsonCreator
    public CreateUserRequest(@JsonProperty("user") String user,
                             @JsonProperty("passwordHash") String passwordHash) {
        this.user = user;
        this.passwordHash = passwordHash;
    }
}
