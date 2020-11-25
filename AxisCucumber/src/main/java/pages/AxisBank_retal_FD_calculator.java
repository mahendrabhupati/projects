package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AxisBank_retal_FD_calculator {

	WebDriver driver;

	public AxisBank_retal_FD_calculator(WebDriver driver) {
		this.driver = driver;
	}

	By seniorCitizenBtn = By.xpath("//label[contains(text(),'Senior Citizen')]");
	By MonthlyPayoutDdown = By.xpath("//select[@id='FdepType']");
	By amountDepositTbox = By.xpath("//input[@id='loan_amount']");
	By clickAnyWhere = By.xpath("//body/div[@id='mainContentWrap']/div[@id='ctl00_Body_C022_Col00']/div[1]");
	By rateofIntrest = By.xpath("//span[@id='matIntRate']");

	public WebElement seniorCitizenBtn() {
		return driver.findElement(seniorCitizenBtn);
	}

	public WebElement MonthlyPayoutDdown() {
		return driver.findElement(MonthlyPayoutDdown);
	}

	public WebElement amountDepositTbox() {
		return driver.findElement(amountDepositTbox);
	}

	public WebElement clickAnyWhere() {
		return driver.findElement(clickAnyWhere);
	}

	public WebElement rateofIntrest() {
		return driver.findElement(rateofIntrest);
	}
}
