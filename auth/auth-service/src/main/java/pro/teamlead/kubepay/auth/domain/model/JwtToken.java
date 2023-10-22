package pro.teamlead.kubepay.auth.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class JwtToken {

     String token;

     @JsonCreator
     public JwtToken(@JsonProperty("token") String token) {
          this.token = token;
     }
}
