package pro.teamlead.kubepay.wallet.api.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Value
public class WalletInfo {

    String address;

    BigDecimal balance;

    @JsonCreator
    public WalletInfo(@JsonProperty("address") String address,
                      @JsonProperty("balance") BigDecimal balance) {
        this.address = address;
        this.balance = balance;
    }
}
