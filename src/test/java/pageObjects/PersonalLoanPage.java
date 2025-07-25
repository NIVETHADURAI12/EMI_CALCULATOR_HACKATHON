package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalLoanPage extends BasePage{
	
	public PersonalLoanPage(WebDriver driver) {
		super(driver);
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	
	@FindBy(id = "loanamount")
	WebElement loanInput;
	@FindBy(id = "loanamountslider")
	WebElement loanSliderBar;
	@FindBy(xpath = "//div[@id='loanamountslider']/span")
	WebElement homeLoanAmt;
	
	@FindBy(id = "loaninterest")
	WebElement interestInput;
	@FindBy(id = "loaninterestslider")
	WebElement interestSliderBar;
	@FindBy(xpath = "//*[@id='loaninterestslider']/span")
	WebElement interestRate;
	
	
	@FindBy(id = "loanterm")
	WebElement termInput;
	@FindBy(id = "loantermslider")
	WebElement tenureSliderBar;
	@FindBy(xpath = "//*[@id='loantermslider']/span")
	WebElement loanTenure;
	
	@FindBy(xpath = "//div[@id='emiamount']/p")
	WebElement loanEmi;
	
	@FindBy(xpath = "//div[@id='emitotalinterest']/p")
	WebElement totalPayment;
	
	// Set Car Loan Amount to target value using slider
		public void setLoanAmtSlider(int target) {
			
			//moveSlider(driver, element, slider, sliderBar, min, max, target);
			iMin = 0;
			iMax = 3000000;
			moveSlider(loanInput, homeLoanAmt, loanSliderBar, iMin, iMax, target);
		}
		
		//Set Car Interest rate to target value using slider
		public void setInterestRateSlider(double target) {
			
			//moveSlider(driver, element, slider, sliderBar, min, max, target);
			fMin = 5;
			fMax = 25;
			moveSlider(interestInput, interestRate, interestSliderBar, fMin, fMax, target);
		}
		
		//Set Tenure to target value using slider
		public void setTenureSlider(double target) {
			
			//moveSlider(driver, element, slider, sliderBar, min, max, target);
			fMin = 0.1;
			fMax = 5;
			moveSlider(termInput, loanTenure, tenureSliderBar, fMin, fMax, target);
		}
		
		//Display the Interest Amount and Principal Amount
		public String getEMI() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			return loanEmi.getText();
		}
		public String getPrincipalAmount() {
			return totalPayment.getText();
		}
	
		@FindBy(id = "car-loan")
		WebElement carLoan;
		public void clickCarloan() {
			carLoan.click();
		}
	
	
}
