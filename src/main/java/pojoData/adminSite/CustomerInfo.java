package pojoData.adminSite;

import lombok.Getter;
import lombok.Setter;

public class CustomerInfo {
    public static CustomerInfo getCustomerInfo() {return new CustomerInfo();}
    @Getter @Setter
    private String serviceId;
    @Getter @Setter
    private String merchantId;
    @Getter @Setter
    private String masterId;
    @Getter @Setter
    private String displayName;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String phoneNumber;
    @Getter @Setter
    private String businessNumber;
    @Getter @Setter
    private String companyName;
    @Getter @Setter
    private String issuedPlace;
    @Getter @Setter
    private String issuedYear;
    @Getter @Setter
    private String issuedMonth;
    @Getter @Setter
    private String issuedDate;
    @Getter @Setter
    private String companyAddress;
    @Getter @Setter
    private String managementBranchName;
    @Getter @Setter
    private String remarks;
}
