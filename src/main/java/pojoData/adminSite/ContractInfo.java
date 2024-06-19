package pojoData.adminSite;

import lombok.Getter;
import lombok.Setter;

public class ContractInfo {
    public static ContractInfo getContractInfo() {return new ContractInfo();
    }

    @Setter @Getter
    private String contractNumber;

    @Setter @Getter
    private String eccPrefix;

    @Setter @Getter
    private String accountNumber;
}
