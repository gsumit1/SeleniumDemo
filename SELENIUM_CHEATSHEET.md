# Selenium WebDriver Cheatsheet (Java)

## 1. Setup & Initialization

### Chrome Driver
```java
// Using WebDriverManager (recommended)
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();

// With options
ChromeOptions options = new ChromeOptions();
options.addArguments("--start-maximized");
options.addArguments("--incognito");
options.addArguments("--disable-notifications");
WebDriver driver = new ChromeDriver(options);
```

### Firefox Driver
```java
WebDriverManager.firefoxdriver().setup();
WebDriver driver = new FirefoxDriver();

// With options
FirefoxOptions options = new FirefoxOptions();
options.addArguments("--private");
WebDriver driver = new FirefoxDriver(options);
```

### Edge Driver
```java
WebDriverManager.edgedriver().setup();
WebDriver driver = new EdgeDriver();
```

### Safari Driver
```java
WebDriver driver = new SafariDriver();
```

### Remote WebDriver
```java
WebDriver driver = new RemoteWebDriver(
    new URL("http://localhost:4444"), 
    new ChromeOptions()
);
```

## 2. Finding Elements

### Single Element (findElement)
```java
// By ID
WebElement element = driver.findElement(By.id("element_id"));

// By Name
WebElement element = driver.findElement(By.name("element_name"));

// By Class Name
WebElement element = driver.findElement(By.className("classname"));

// By CSS Selector
WebElement element = driver.findElement(By.cssSelector("css_selector"));

// By XPath
WebElement element = driver.findElement(By.xpath("//xpath/expression"));

// By Link Text
WebElement element = driver.findElement(By.linkText("Link Text"));

// By Partial Link Text
WebElement element = driver.findElement(By.partialLinkText("Partial Link"));

// By Tag Name
WebElement element = driver.findElement(By.tagName("input"));
```

### Multiple Elements (findElements)
```java
List<WebElement> elements = driver.findElements(By.className("classname"));

// Iterate through elements
for (WebElement element : elements) {
    System.out.println(element.getText());
}
```

## 3. Interacting with Elements

### Click
```java
element.click();

// Using Actions class for advanced clicks
Actions actions = new Actions(driver);
actions.click(element).perform();

// Double click
actions.doubleClick(element).perform();

// Right click
actions.contextClick(element).perform();
```

### Type Text
```java
element.sendKeys("Text to enter");

// Clear and type
element.clear();
element.sendKeys("New text");

// Type with special keys
element.sendKeys(Keys.SHIFT, "a");  // Capital A
element.sendKeys(Keys.CONTROL, "a");  // Select all
```

### Submit Form
```java
element.submit();
```

### Get Element Properties
```java
// Get text
String text = element.getText();

// Get attribute value
String value = element.getAttribute("attribute_name");

// Get CSS value
String color = element.getCssValue("color");

// Check if displayed
boolean isDisplayed = element.isDisplayed();

// Check if enabled
boolean isEnabled = element.isEnabled();

// Check if selected
boolean isSelected = element.isSelected();

// Get tag name
String tagName = element.getTagName();
```

### Get Element Size & Location
```java
Dimension size = element.getSize();
Point location = element.getLocation();
Rectangle rect = element.getRect();
```

## 4. Navigation

### Navigate to URL
```java
driver.get("https://www.example.com");
// or
driver.navigate().to("https://www.example.com");
```

### Back
```java
driver.navigate().back();
```

### Forward
```java
driver.navigate().forward();
```

### Refresh
```java
driver.navigate().refresh();
```

### Get Current URL
```java
String currentUrl = driver.getCurrentUrl();
```

### Get Page Title
```java
String title = driver.getTitle();
```

### Get Page Source
```java
String pageSource = driver.getPageSource();
```

## 5. Wait Strategies

### Implicit Wait (applies to all elements)
```java
// Wait for 10 seconds
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```

### Explicit Wait (WebDriverWait)
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Wait for element to be visible
WebElement element = wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.id("element_id"))
);

// Wait for element to be clickable
WebElement element = wait.until(
    ExpectedConditions.elementToBeClickable(By.id("element_id"))
);

// Wait for element to be present
WebElement element = wait.until(
    ExpectedConditions.presenceOfElementLocated(By.id("element_id"))
);
```

### Fluent Wait
```java
Wait<WebDriver> fluentWait = new FluentWait<>(driver)
    .withTimeout(Duration.ofSeconds(10))
    .pollingEvery(Duration.ofMillis(500))
    .ignoring(NoSuchElementException.class);

WebElement element = fluentWait.until(
    d -> d.findElement(By.id("element_id"))
);
```

### Common Expected Conditions
```java
// Visibility
ExpectedConditions.visibilityOfElementLocated(By.id("id"));

// Presence
ExpectedConditions.presenceOfElementLocated(By.id("id"));

// Clickable
ExpectedConditions.elementToBeClickable(By.id("id"));

// Text in element
ExpectedConditions.textToBePresentInElement(element, "text");

// URL contains
ExpectedConditions.urlContains("part_of_url");

// Title is
ExpectedConditions.titleIs("Page Title");

// Alert is present
ExpectedConditions.alertIsPresent();

// Number of elements
ExpectedConditions.numberOfElementsToBeMoreThan(By.id("id"), 5);
```

## 6. Alerts & Windows

### Handle Alerts
```java
// Switch to alert
Alert alert = driver.switchTo().alert();

// Get alert text
String alertText = alert.getText();

// Accept alert
alert.accept();

// Dismiss alert
alert.dismiss();

// Send keys to alert
alert.sendKeys("text to enter");

// Wait for alert to appear
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
wait.until(ExpectedConditions.alertIsPresent());
```

### Switch to Window
```java
// Get window handles
Set<String> windowHandles = driver.getWindowHandles();

// Switch by handle
driver.switchTo().window(windowHandle);

// Get current window handle
String currentWindow = driver.getWindowHandle();

// Switch to latest window
for (String handle : driver.getWindowHandles()) {
    driver.switchTo().window(handle);
}
```

### Switch to Frame
```java
// By index
driver.switchTo().frame(0);

// By name or id
driver.switchTo().frame("frame_name");

// By WebElement
WebElement frameElement = driver.findElement(By.id("frame_id"));
driver.switchTo().frame(frameElement);

// Switch back to main content
driver.switchTo().defaultContent();

// Switch to parent frame
driver.switchTo().parentFrame();
```

## 7. Dropdowns (Select)

### Select by Visible Text
```java
Select dropdown = new Select(element);
dropdown.selectByVisibleText("Option Text");
```

### Select by Value
```java
dropdown.selectByValue("value_attribute");
```

### Select by Index
```java
dropdown.selectByIndex(2);  // Select 3rd option (0-indexed)
```

### Get Selected Option
```java
WebElement selectedOption = dropdown.getFirstSelectedOption();
String selectedText = selectedOption.getText();
```

### Get All Options
```java
List<WebElement> options = dropdown.getOptions();
for (WebElement option : options) {
    System.out.println(option.getText());
}
```

### Deselect Options (Multi-select)
```java
dropdown.deselectByVisibleText("Option Text");
dropdown.deselectByValue("value");
dropdown.deselectByIndex(0);
dropdown.deselectAll();
```

### Check if Multi-select
```java
boolean isMultiple = dropdown.isMultiple();
```

## 8. Mouse & Keyboard Actions

### Hover Over Element
```java
Actions actions = new Actions(driver);
actions.moveToElement(element).perform();
```

### Drag and Drop
```java
Actions actions = new Actions(driver);
actions.dragAndDrop(sourceElement, targetElement).perform();

// Or using drag and drop by offset
actions.clickAndHold(sourceElement)
    .moveByOffset(100, 50)
    .release()
    .perform();
```

### Keyboard Actions
```java
Actions actions = new Actions(driver);

// Press key
actions.keyDown(Keys.SHIFT).perform();
actions.keyUp(Keys.SHIFT).perform();

// Type with modifiers
actions.keyDown(Keys.CONTROL)
    .sendKeys("c")
    .keyUp(Keys.CONTROL)
    .perform();

// Chain multiple actions
actions.click(element)
    .pause(Duration.ofMillis(500))
    .sendKeys("text")
    .perform();
```

### Keyboard Shortcuts
```java
// Ctrl+A (Select All)
element.sendKeys(Keys.CONTROL, "a");

// Ctrl+C (Copy)
element.sendKeys(Keys.CONTROL, "c");

// Ctrl+V (Paste)
element.sendKeys(Keys.CONTROL, "v");

// Ctrl+X (Cut)
element.sendKeys(Keys.CONTROL, "x");

// Tab
element.sendKeys(Keys.TAB);

// Enter
element.sendKeys(Keys.RETURN);

// Escape
element.sendKeys(Keys.ESCAPE);

// Delete
element.sendKeys(Keys.DELETE);

// Backspace
element.sendKeys(Keys.BACK_SPACE);

// Arrow Keys
element.sendKeys(Keys.ARROW_DOWN);
element.sendKeys(Keys.ARROW_UP);
element.sendKeys(Keys.ARROW_LEFT);
element.sendKeys(Keys.ARROW_RIGHT);
```

## 9. JavaScript Execution

### Execute JavaScript
```java
JavascriptExecutor js = (JavascriptExecutor) driver;

// Execute script and get return value
Object result = js.executeScript("return document.title;");

// Execute script without return value
js.executeScript("console.log('Hello from Selenium');");
```

### Scroll to Element
```java
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView(true);", element);
```

### Scroll to Bottom
```java
js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
```

### Click Element (JavaScript Click)
```java
js.executeScript("arguments[0].click();", element);
```

### Highlight Element
```java
js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
```

### Get Computed Style
```java
String color = (String) js.executeScript(
    "return window.getComputedStyle(arguments[0], null).getPropertyValue('color');", 
    element
);
```

### Remove Element
```java
js.executeScript("arguments[0].remove();", element);
```

### Change Element Value
```java
js.executeScript("arguments[0].value = 'new value';", element);
```

## 10. Screenshots & Logs

### Take Screenshot
```java
// Full page screenshot
File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screenshot, new File("screenshot.png"));

// Element screenshot
File elementScreenshot = element.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(elementScreenshot, new File("element_screenshot.png"));

// Get screenshot as Base64
String base64Screenshot = ((TakesScreenshot) driver)
    .getScreenshotAs(OutputType.BASE64);
```

### Get Browser Logs
```java
LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
for (LogEntry entry : logs) {
    System.out.println(entry.getLevel() + " " + entry.getMessage());
}
```

### Get Available Log Types
```java
Set<String> logTypes = driver.manage().logs().getAvailableLogTypes();
```

## 11. Assertions

### TestNG Assertions
```java
// Assert true
Assert.assertTrue(condition);
Assert.assertTrue(condition, "Error message");

// Assert false
Assert.assertFalse(condition);

// Assert equals
Assert.assertEquals(actual, expected);
Assert.assertEquals(actual, expected, "Error message");

// Assert not equals
Assert.assertNotEquals(actual, expected);

// Assert null
Assert.assertNull(value);
Assert.assertNotNull(value);

// Soft assertions (continue even if assertion fails)
SoftAssert softAssert = new SoftAssert();
softAssert.assertTrue(condition1);
softAssert.assertTrue(condition2);
softAssert.assertAll();  // Must call at end
```

### JUnit Assertions
```java
// Assert true
assertTrue(condition);

// Assert false
assertFalse(condition);

// Assert equals
assertEquals(expected, actual);

// Assert not equals
assertNotEquals(expected, actual);

// Assert null
assertNull(value);
assertNotNull(value);

// Assert throws exception
assertThrows(Exception.class, () -> {
    // code that should throw exception
});
```

### Assertion with Selenium Elements
```java
// Assert element is displayed
Assert.assertTrue(element.isDisplayed(), "Element not visible");

// Assert element is enabled
Assert.assertTrue(element.isEnabled(), "Element not enabled");

// Assert element is selected
Assert.assertTrue(element.isSelected(), "Element not selected");

// Assert element text
Assert.assertEquals(element.getText(), "Expected Text");

// Assert element attribute
Assert.assertEquals(element.getAttribute("class"), "active");

// Assert page title
Assert.assertEquals(driver.getTitle(), "Expected Title");

// Assert current URL
Assert.assertTrue(driver.getCurrentUrl().contains("example.com"));
```

## 12. Best Practices

### 1. Use Explicit Waits Instead of Thread.sleep()
```java
// ❌ Bad
Thread.sleep(5000);

// ✅ Good
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element")));
```

### 2. Use Page Object Model (POM)
```java
// Page class
public class LoginPage {
    private WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}

// Test class
@Test
public void testLogin() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("user@example.com", "password");
}
```

### 3. Always Quit WebDriver
```java
@AfterClass
public void tearDown() {
    if (driver != null) {
        driver.quit();  // Close all windows and end session
    }
}
```

### 4. Use Relative XPath
```java
// ❌ Bad - Fragile
By.xpath("/html/body/div[1]/div[2]/div[3]/button");

// ✅ Good - Robust
By.xpath("//button[@id='submit']");
By.xpath("//button[contains(text(), 'Submit')]");
```

### 5. Handle Exceptions Properly
```java
try {
    WebElement element = driver.findElement(By.id("element"));
    element.click();
} catch (NoSuchElementException e) {
    System.out.println("Element not found");
} catch (StaleElementReferenceException e) {
    System.out.println("Element is no longer attached to DOM");
} finally {
    driver.quit();
}
```

### 6. Wait for Document Ready State
```java
public void waitForPageLoad(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));
}
```

### 7. Use WebDriverManager for Driver Management
```java
// Instead of setting system property manually
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
```

### 8. Avoid Hard Waits (Thread.sleep)
```java
// ❌ Avoid
Thread.sleep(2000);

// ✅ Use explicit wait with proper condition
```

### 9. Take Screenshots on Test Failure
```java
public void captureScreenshot(String screenshotName) throws IOException {
    File screenshot = ((TakesScreenshot) driver)
        .getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(screenshot, new File("screenshots/" + screenshotName + ".png"));
}
```

### 10. Use Fluent Wait for Unstable Elements
```java
Wait<WebDriver> wait = new FluentWait<>(driver)
    .withTimeout(Duration.ofSeconds(15))
    .pollingEvery(Duration.ofMillis(500))
    .ignoring(NoSuchElementException.class)
    .ignoring(StaleElementReferenceException.class);
```

## 13. Quick Reference Table

| Task | Code |
|------|------|
| **Navigation** | |
| Navigate to URL | `driver.get("url")` |
| Get current URL | `driver.getCurrentUrl()` |
| Refresh page | `driver.navigate().refresh()` |
| Back | `driver.navigate().back()` |
| Forward | `driver.navigate().forward()` |
| **Finding Elements** | |
| Find by ID | `driver.findElement(By.id("id"))` |
| Find by Name | `driver.findElement(By.name("name"))` |
| Find by XPath | `driver.findElement(By.xpath("xpath"))` |
| Find by CSS | `driver.findElement(By.cssSelector("css"))` |
| Find Multiple | `driver.findElements(By.className("class"))` |
| **Interacting** | |
| Click | `element.click()` |
| Send Keys | `element.sendKeys("text")` |
| Clear | `element.clear()` |
| Submit | `element.submit()` |
| Get Text | `element.getText()` |
| Get Attribute | `element.getAttribute("name")` |
| Is Displayed | `element.isDisplayed()` |
| Is Enabled | `element.isEnabled()` |
| Is Selected | `element.isSelected()` |
| **Waiting** | |
| Implicit Wait | `driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))` |
| Explicit Wait | `new WebDriverWait(driver, Duration.ofSeconds(10))` |
| Wait for Visible | `wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id")))` |
| Wait for Clickable | `wait.until(ExpectedConditions.elementToBeClickable(By.id("id")))` |
| **Dropdowns** | |
| Select by Text | `new Select(element).selectByVisibleText("text")` |
| Select by Value | `new Select(element).selectByValue("value")` |
| Select by Index | `new Select(element).selectByIndex(0)` |
| Get Selected | `new Select(element).getFirstSelectedOption()` |
| Get All Options | `new Select(element).getOptions()` |
| **Windows & Alerts** | |
| Switch to Alert | `driver.switchTo().alert()` |
| Accept Alert | `driver.switchTo().alert().accept()` |
| Switch to Frame | `driver.switchTo().frame(0)` |
| Switch to Window | `driver.switchTo().window(handle)` |
| Get Window Handle | `driver.getWindowHandle()` |
| Get All Handles | `driver.getWindowHandles()` |
| **JavaScript** | |
| Execute Script | `((JavascriptExecutor) driver).executeScript("script")` |
| Scroll to Element | `js.executeScript("arguments[0].scrollIntoView();", element)` |
| Click via JS | `js.executeScript("arguments[0].click();", element)` |
| **Screenshots** | |
| Take Screenshot | `((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)` |
| **Quit/Close** | |
| Close Current Tab | `driver.close()` |
| Close All Tabs | `driver.quit()` |

## Maven Dependencies

```xml
<!-- Selenium WebDriver -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.15.0</version>
</dependency>

<!-- WebDriverManager -->
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.6.2</version>
</dependency>

<!-- TestNG -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.8.1</version>
    <scope>test</scope>
</dependency>

<!-- JUnit 5 -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>
```

## Useful Links

- [Selenium Official Documentation](https://www.selenium.dev/documentation/)
- [Selenium GitHub Repository](https://github.com/SeleniumHQ/selenium)
- [WebDriver API](https://www.selenium.dev/selenium/docs/api/java/index.html)
- [XPath Tutorial](https://www.w3schools.com/xml/xpath_intro.asp)
- [CSS Selectors Reference](https://www.w3schools.com/cssref/css_selectors.asp)

---

**Last Updated:** May 2026
**Selenium Version:** 4.x
**Java Version:** 8+
