package pro.teamlead.kubepay.wallet.api;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WalletApiMethodDictionary {

    public static final String WALLET_CREATE = "/create";

    public static final String WALLET_INFO = "/balance";

    public static final String WALLET_TOPUP = "/topup";

    public static final String WALLET_TRANSFER_FUNDS = "/transfer";
}
