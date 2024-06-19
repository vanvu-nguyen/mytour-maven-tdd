package commons;

import lombok.Getter;

import java.io.File;
@Getter
public class GlobalConstants {
    private static GlobalConstants globalConstants;
    private GlobalConstants() {
    }
    public synchronized static GlobalConstants getGlobalConstants() {
        if (globalConstants == null) {
            globalConstants = new GlobalConstants();
        }
        return globalConstants;
    }

    // Server url: dev, testing, staging, production

    // Database: dev, testing, staging, production

    // Timeout: short, long
    private final long shortTimeout = 5;
    private final long longTimeout = 10;

    // OS name
    private final String osName = System.getProperty("os.name");

    // Relative project path
    private final String relativeProjectPath = System.getProperty("user.dir");

    // download/upload file folder
    private final String downloadPath = relativeProjectPath + File.separator + "downloadFiles" + File.separator;
    private final String uploadPath = relativeProjectPath + File.separator + "uploadImage" + File.separator;

    // Browser extention folder
    private final String browserExtentionPath = relativeProjectPath + File.separator + "browserExtension" + File.separator;

    // Browser log folder
    private final String browserLogFolder = relativeProjectPath + File.separator + "browserLog" + File.separator;

    private final String reportingImagePath = relativeProjectPath + File.separator + "reportNGImage" + File.separator;
    private final String javaVersion = System.getProperty("java.version");

    // Admin dev-env account
    private final String adminUsername = "admin@naver.com";
    private final String adminPassword = "12345";

    // Common Admin dev-env password
    private final String common_password = "12345";

    // User dev-env account
    private final String userUsername = "bidvtest";
    private final String userPassword = "12345";

    // Wordpress (DB name: )
    private final String username = "";
    private final String password = "";



}
