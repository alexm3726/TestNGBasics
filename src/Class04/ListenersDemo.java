package Class04;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersDemo implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting the test wth name: "+ result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test pass, we take screenshot");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test fail, I will report it");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Finishing test case with the name: "+ result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
