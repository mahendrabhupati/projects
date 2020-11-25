package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import genericMethods.BaseClass;
import genericMethods.ExcelRead;
import pages.AxisBank_retal_FD_calculator;

public class FdCalculatorSD  {
	AxisBank_retal_FD_calculator AxisBankObj;
	String amount;
	BaseClass BaseClassObj =new BaseClass();
	WebDriver driver;
	public FdCalculatorSD() {
		driver=BaseClassObj.BrowserInvoke("firefox", "https://www.axisbank.com/retail/calculators/fd-calculator");
		
	}
	@Given("^User is on FD Calculator Home Page$")
	public void user_is_on_FD_Calculator_Home_Page() {
//		BrowserInvoke("firefox", "https://www.axisbank.com/retail/calculators/fd-calculator");
		new AxisBank_retal_FD_calculator(driver);
	}

	@When("^User selects Senoir Citizenship radioBtn$")
	public void user_selects_Senoir_Citizenship_radioBtn() {
		// 2.Selecting senior citizenship radio button

		AxisBankObj.seniorCitizenBtn().click();

	}

	@Then("^User selects monthly payout$")
	public void user_selects_monthly_payout() throws InterruptedException {
		Select sel = new Select(AxisBankObj.MonthlyPayoutDdown());
		sel.selectByVisibleText("Monthly Payout");
		Thread.sleep(2000);

	}

	@Then("^Data retrived from excel and click someWhere$")
	public void data_retrived_from_excel_and_click_someWhere() {
		ExcelRead readData = new ExcelRead();
		amount = readData.ExcelRead_amount();
		AxisBankObj.amountDepositTbox().clear();
		AxisBankObj.amountDepositTbox().sendKeys(amount);
		AxisBankObj.clickAnyWhere().click();

	}

	@Then("^Capture the rate of interest print on Console$")
	public void capture_the_rate_of_interest_print_on_Console() {
		System.out.println("Rate of Interest :" + " " + AxisBankObj.rateofIntrest().getText());

	}

	@Then("^Capture the Screenshot$")
	public void capture_the_Screenshot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Screenshots/Screen.png");
		FileUtils.copyFile(source, destination);

	}

}
