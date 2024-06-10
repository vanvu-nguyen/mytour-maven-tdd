package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import commons.GlobalConstants;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstants.getGlobalConstants().getRelativeProjectPath() + "/extentReport/HTMLReport.html");
        reporter.config().setReportName("CMS-BIDV HTML Report");
        reporter.config().setDocumentTitle("CMS-BIDV HTML Report");
        reporter.config().setTimelineEnabled(true);
        reporter.config().setEncoding("utf-8");
        reporter.config().setTheme(Theme.STANDARD);

        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("InfoPlus", "Vuke");
        extentReports.setSystemInfo("Project", "CMS-BIDV");
        extentReports.setSystemInfo("Team", "ATTeam");
        extentReports.setSystemInfo("JDK version", GlobalConstants.getGlobalConstants().getJavaVersion());
        return extentReports;
    }
}
