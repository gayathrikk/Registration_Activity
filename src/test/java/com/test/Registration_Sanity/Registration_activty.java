package com.test.Registration_Sanity;

import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Registration_activty {
	
	
	private RemoteWebDriver driver;
	private WebDriverWait wait;

	@BeforeTest

	public void setup() throws Exception {
	DesiredCapabilities dc = DesiredCapabilities.chrome();
	// URL url = new URL("http://172.20.23.7:5555/wd/hub");
	URL url = new URL("http://172.12.20.99:4444/");
	driver = new RemoteWebDriver(url, dc);
	wait = new WebDriverWait(driver, 30);

	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
	driver.get("https://apollo2.humanbrain.in/viewer/annotation/portal");
	driver.manage().window().maximize();
	String currentURL = driver.getCurrentUrl();
	System.out.println("Current URL: " + currentURL);
	WebDriverWait wait = new WebDriverWait(driver, 60);
	driver.switchTo().defaultContent(); // Switch back to default content
	WebElement viewerElement = wait
	.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Viewer']")));
	if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
	viewerElement.click();
	System.out.println("Viewer icon is clicked");
	} else {
	System.out.println("Viewer icon is not clickable");
	}

	String parentWindow = driver.getWindowHandle();
	WebElement loginButton = wait
	.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
	if (loginButton != null) {
	loginButton.click();
	System.out.println("Login button clicked successfully.");
	} else {
	System.out.println("Login button is not clicked.");
	}

	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	Set<String> allWindows = driver.getWindowHandles();
	for (String window : allWindows) {
	if (!window.equals(parentWindow)) {
	driver.switchTo().window(window);
	break;
	}
	}
	WebElement emailInput = wait
	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
	if (emailInput != null && emailInput.isDisplayed()) {
	emailInput.sendKeys("softwareteam45@gmail.com");
	System.out.println("Email was entered successfully.");
	} else {
	System.out.println("Email was not entered.");
	}

	WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	if (nextButton1 != null) {
	nextButton1.click();
	System.out.println("Next button 1 is clicked.");
	} else {
	System.out.println("Next button 1 is not clicked.");
	}

	WebElement passwordInput = wait.until(
	ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
	passwordInput.sendKeys("Health#123");
	if (passwordInput.getAttribute("value").equals("Health#123")) {
	System.out.println("Password was entered successfully.");
	} else {
	System.out.println("Password was not entered.");
	}

	WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	if (nextButton2 != null) {
	nextButton2.click();
	System.out.println("Next button 2 is clicked.");
	} else {
	System.out.println("Next button 2 is not clicked.");
	}

	driver.switchTo().window(parentWindow);
	System.out.println("Login successfully");

	System.out.println("************************Login validation done***********************");
	Thread.sleep(5000);
	}

	@Test(priority = 2)
	public void brain_search() throws InterruptedException {
	WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input)[2]")));
	if (searchBar != null && searchBar.isDisplayed()) {
	searchBar.sendKeys("29", Keys.ENTER);
	System.out.println("Biosample ID entered successfully");
	} else {
	System.out.println("Biosample ID was not entered.");
	}
	Thread.sleep(3000);

	WebElement redirectIcon = wait.until(
	ExpectedConditions.visibilityOfElementLocated(By.xpath("(//nb-card-footer[@class='p-2'])[1]/nb-icon")));
	if (redirectIcon != null && redirectIcon.isDisplayed()) {
	redirectIcon.click();
	System.out.println("Brain was clicked successfully");
	} else {
	System.out.println("Brain was not clicked");
	}
	Thread.sleep(3000);

	String parentWindow = driver.getWindowHandle();

	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	Set<String> allWindows = driver.getWindowHandles();
	for (String window : allWindows) {
	if (!window.equals(parentWindow)) {
	driver.switchTo().window(window);
	break;
	}
	}

	WebElement brainSection = wait
	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='335'])[1]")));
	if (brainSection != null && brainSection.isDisplayed()) {
	brainSection.click();
	System.out.println("Section clicked successfully");
	} else {
	System.out.println("Section is not clicked");
	}
	Thread.sleep(3000);

	WebElement HdElement = wait
	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Manual Registration']")));
	if (HdElement != null && HdElement.isDisplayed()) {
	HdElement.click();
	System.out.println("Manual Registration Icon clicked successfully");
	} else {
	System.out.println("Manual Registration Icon is not clicked");
	}
	Thread.sleep(7000);

	driver.switchTo().window(parentWindow);

	}

	@Test(priority = 3)
	public void activity_Search() throws InterruptedException {
	WebElement LimsElement = wait
	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='LIMS']")));
	if (LimsElement != null && LimsElement.isDisplayed()) {
	LimsElement.click();
	System.out.println("Lims icon clicked successfully");
	} else {
	System.out.println("Lims icon is not clicked");
	}

	Thread.sleep(5000);

	WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
	// now we will Switch to the iframe for further actions

	driver.switchTo().frame(iframeElement);

	WebElement userInput = wait
	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
	if (userInput != null && userInput.isDisplayed()) {
	userInput.sendKeys("admin");
	System.out.println("Username was entered successfully.");
	} else {
	System.out.println("Username was not entered.");
	}
	Thread.sleep(2000);

	WebElement passInput = wait
	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
	if (passInput != null && passInput.isDisplayed()) {
	passInput.click();
	passInput.sendKeys("admin");
	System.out.println("Password was entered successfully.");
	} else {
	System.out.println("Password was not entered.");
	}
	Thread.sleep(2000);

	driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	System.out.println("Login button clicked successfully");

	Thread.sleep(3000);

	WebElement ActivityElement = wait
	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Activity']")));
	if (ActivityElement != null && ActivityElement.isDisplayed()) {
	ActivityElement.click();
	System.out.println("Activity clicked successfully");
	} else {
	System.out.println("Activity is not clicked");
	}
	Thread.sleep(3000);

	}

	@Test(priority = 4)
	public void userName() throws InterruptedException {
	String[] expectedFileName = { "Software Team" };

	java.util.List<WebElement> locationElements = driver
	.findElements(By.xpath("(//td[text()='Software Team'])[1]"));
	String actualFileName = locationElements.get(0).getText();
	Thread.sleep(2000);

	Assert.assertEquals(actualFileName, expectedFileName[0], "FileName not matching.");
	System.out.println("Username matched Successfully");
	System.out.println("\n\n ************************Username validation done***********************\n\n");
	Thread.sleep(2000);

	}

	@Test(priority = 5)
	public void Action() throws InterruptedException {
	String[] expectedFileName = { "Manual Registration" };

	java.util.List<WebElement> locationElements = driver
	.findElements(By.xpath("(//td[text()='Software Team'])[1]/following-sibling::td[1]"));
	String actualFileName = locationElements.get(0).getText();
	Thread.sleep(2000);

	Assert.assertEquals(actualFileName, expectedFileName[0], "FileName not matching.");
	System.out.println("Action matched Successfully");
	System.out.println("\n\n ************************Action validation done***********************\n\n");
	Thread.sleep(2000);

	}

	@Test(priority = 6)
	public void Info() throws InterruptedException {
	String[] expectedFileName = { "SS-14:7:335" };

	java.util.List<WebElement> locationElements = driver
	.findElements(By.xpath("(//td[text()='Software Team'])[1]/following-sibling::td[2]"));
	String actualFileName = locationElements.get(0).getText();
	Thread.sleep(2000);

	Assert.assertEquals(actualFileName, expectedFileName[0], "FileName not matching.");
	System.out.println("Info matched Successfully");
	System.out.println("\n\n ************************Info validation done***********************\n\n");
	Thread.sleep(5000);

	}

	@AfterTest
	public void afterTest() {
	driver.quit();
	}

}
