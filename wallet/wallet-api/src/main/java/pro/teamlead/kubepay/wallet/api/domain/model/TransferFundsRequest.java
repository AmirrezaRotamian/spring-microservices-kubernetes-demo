package pro.teamlead.kubepay.wallet.api.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Value
public class TransferFundsRequest {

    @NotEmpty
    String to;

    @Min(0)
    @NotNull
    BigDecimal amount;

    @JsonCreator
    public TransferFundsRequest(@JsonProperty("to") String to,
                                @JsonProperty("amount") BigDecimal amount) {
        this.to = to;
        this.amount = amount;
    }
}
