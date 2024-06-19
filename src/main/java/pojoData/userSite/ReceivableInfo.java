package pojoData.userSite;

import lombok.Getter;
import lombok.Setter;

public class ReceivableInfo {
    public static ReceivableInfo getReceivableInfo() {return new ReceivableInfo();}

    @Setter @Getter
    private String refId;

}
