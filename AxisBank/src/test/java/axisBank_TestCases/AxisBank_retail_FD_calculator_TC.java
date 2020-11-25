package axisBank_TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import genericMethods.BaseClass;
import genericMethods.ExcelRead;
import pageObjects.AxisBank_retal_FD_calculator;

public class AxisBank_retail_FD_calculator_TC extends BaseClass {

	@BeforeClass
	public static void startBrowser() {
		// 1.Opening provided URL in Firefox browser
		BrowserInvoke("firefox", "https://www.axisbank.com/retail/calculators/fd-calculator");
	}

	@Test
	public void SalesTestDemo() throws IOException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AxisBank_retal_FD_calculator AxisBankObj = new AxisBank_retal_FD_calculator(driver);

		// 2.Selecting senior citizenship radio button
		AxisBankObj.seniorCitizenBtn().click();

		// 3.Selecting monthly payout from drop down
		Select sel = new Select(AxisBankObj.MonthlyPayoutDdown());
		sel.selectByVisibleText("Monthly Payout");
		Thread.sleep(2000);

		// 4.Reading data from excel File
		ExcelRead readData = new ExcelRead();
		String amount = readData.ExcelRead_amount();

		// ...Clearing already existing example
		AxisBankObj.amountDepositTbox().clear();

		// ...Entering data from excel sheet
		AxisBankObj.amountDepositTbox().sendKeys(amount);

		// 5.clicking in openspace to come out of amount Deposit Text box
		AxisBankObj.clickAnyWhere().click();

		// 6.Printing rate of Interest in console
		System.out.println("Rate of Interest :" + " " + AxisBankObj.rateofIntrest().getText());

		// 7.taking screenshot of final page and storing screenshot in Screeshot folder
		Screenshot();

	}

	@AfterClass
	public static void quitBrowser() {

		// ...Closing the opened browser
		driver.quit();
	}
}
