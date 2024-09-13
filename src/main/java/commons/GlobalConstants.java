package commons;

import lombok.Getter;

import java.io.File;
@Getter
public class GlobalConstants {

    // Timeout: short, long
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 10;

    // OS name
    public static final String OS_NAME = System.getProperty("os.name");

    // Relative project path
    public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");

    // download/upload file folder
    public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "downloadFiles" + File.separator;
    public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadImage" + File.separator;

    // Browser extention folder
    public static final String BROWSER_EXTENTION_PATH = RELATIVE_PROJECT_PATH + File.separator + "browserExtension" + File.separator;

    // Browser log folder
    public static final String BROWSER_LOG_FOLDER = RELATIVE_PROJECT_PATH + File.separator + "browserLog" + File.separator;

    public static final String REPORTING_IMAGE_PATH = RELATIVE_PROJECT_PATH + File.separator + "reportNGImage" + File.separator;
    public static final String JAVA_VERSION = System.getProperty("java.version");

    // Admin dev-env account
    public static final String ADMIN_USERNAME = "admin@naver.com";
    public static final String ADMIN_PASSWORD = "12345";

    // Common Admin dev-env password
    public static final String COMMON_PASSWORD = "12345";

    // User dev-env account
    public static final String USER_USERNAME = "bidvtest";
    public static final String USER_PASSWORD = "12345";

    // Wordpress (DB name: )
    public static final String USERNAME = "";
    public static final String PASSWORD = "";

}
