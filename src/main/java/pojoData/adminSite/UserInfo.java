package pojoData.adminSite;

import lombok.Getter;
import lombok.Setter;

public class UserInfo {

    public static UserInfo getUserInfo() {
        return new UserInfo();
    }

    @Setter @Getter
    private String userID;

    @Setter @Getter
    private String userName;

    @Setter @Getter
    private String userMobile;

    @Setter @Getter
    private String userEmail;

    @Setter @Getter
    private String staffCode;


}
