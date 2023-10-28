package pro.teamlead.kubepay.wallet.api.domain.model;

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
}
