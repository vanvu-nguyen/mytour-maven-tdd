package pojoData.userSite;

import lombok.Getter;
import lombok.Setter;

public class PayerInfo {
    public static PayerInfo getPayerInfo() {return new PayerInfo();}

    @Setter @Getter
    private String payerName;

    @Setter @Getter
    private String payerPhoneNumber;
}
