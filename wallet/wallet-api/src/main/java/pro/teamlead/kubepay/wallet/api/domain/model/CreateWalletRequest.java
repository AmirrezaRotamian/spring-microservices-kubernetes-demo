package pro.teamlead.kubepay.wallet.api.domain.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Value
public class CreateWalletRequest {

    @NotBlank
    String user;

    @NotNull
    @Min(0)
    BigDecimal initialBalance;

}
