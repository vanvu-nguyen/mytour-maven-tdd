package pojoData.adminSite;

import lombok.Getter;
import lombok.Setter;

public class DepartmentInfo {

    public static DepartmentInfo getDepartmentInfo() {
        return new DepartmentInfo();
    }

    @Setter @Getter
    private String departmentCode;

    @Setter @Getter
    private String departmentName;

}
