package pro.teamlead.kubepay.user.api.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Value
public class UserInfo {

    String user;

    String name;

    boolean enabled;

    @JsonCreator
    public UserInfo(@JsonProperty("user") String user,
                    @JsonProperty("name") String name,
                    @JsonProperty("enabled") boolean enabled) {

        this.user = user;
        this.name = name;
        this.enabled = enabled;
    }
}
