import io.github.bonigarcia.wdm.WebDriverManager;
import jakarta.mail.*;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.search.OrTerm;
import jakarta.mail.search.SearchTerm;
import jakarta.mail.search.SubjectTerm;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class CapabilitiesMethods {


    public WebDriver browserConfig() {
        WebDriverManager.chromedriver().driverVersion("146.0.7680.165").setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--window-size=1920,1200");
        options.addArguments("--headless");

        return new ChromeDriver(options);
    }


    public void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }

    public void navigate(WebDriver driver, String url) {
        driver.get(url);
        waitForPageLoad(driver);
    }

    public void waitForPageLoad(WebDriver driver) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                    wd -> ((JavascriptExecutor) wd)
                            .executeScript("return document.readyState").equals("complete")
            );
        } catch (Exception ignored) {
        }
    }

    public void waitVisible(WebDriver driver, By element) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
        wait(400);
    }

    public void waitClickable(WebDriver driver, By element) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitSelectable(WebDriver driver, By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public void waitExists(WebDriver driver, By element) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void click(WebDriver driver, By element, int ms) {
        waitClickable(driver, element);
        driver.findElement(element).click();
        wait(ms);
    }

    public void doubleClick(WebDriver driver, By element, int ms) {
        waitClickable(driver, element);
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(element)).perform();
        wait(ms);
    }

    public void clear(WebDriver driver, By element) {
        waitExists(driver, element);
        driver.findElement(element).clear();
    }

    public void sendKeys(WebDriver driver, By element, String text) {
        sendKeys(driver, element, text, 0); // Default
    }
    public void sendKeys(WebDriver driver, By element, String text, int ms) {
        waitVisible(driver, element);
        driver.findElement(element).sendKeys(text);
        wait(ms);
    }

    public void switchFrame(WebDriver driver, String frame) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frame);
    }

    public void defaultContentFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public boolean getElementSelected(WebDriver driver, By element) {
        waitExists(driver, element);
        return driver.findElement(element).isSelected();
    }

    public String getElementValue(WebDriver driver, By element) {
        waitExists(driver, element);
        return driver.findElement(element).getAttribute("value");
    }

    public String getElementAttribute(WebDriver driver, By element, String attr) {
        waitExists(driver, element);
        WebElement el = driver.findElement(element);

        switch (attr) {
            case "width":
                return String.valueOf(el.getSize().getWidth());
            case "height":
                return String.valueOf(el.getSize().getHeight());
            default:
                return el.getAttribute(attr);
        }
    }

    public String getElementCssProperty(WebDriver driver, By element, String property) {
        waitExists(driver, element);
        return driver.findElement(element).getCssValue(property);
    }

    public String getElementText(WebDriver driver, By element) {
        waitExists(driver, element);
        return driver.findElement(element).getText();
    }

    public int getElementsCount(WebDriver driver, By element) {
        return driver.findElements(element).size();
    }

    public void setElementAttribute(WebDriver driver, By element, String name, String value) {
        WebElement el = driver.findElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                el, name, value);
    }

    public void setSelectByValue(WebDriver driver, By element, String value, int ms) {
        Select select = new Select(driver.findElement(element));
        select.selectByValue(value);
        wait(ms);
    }

    public void setSelectByText(WebDriver driver, By element, String text) {
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(text);
    }

    public boolean exists(WebDriver driver, By element) {
        try {
            driver.findElement(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDisplayed(WebDriver driver, By element) {
        try {
            return driver.findElement(element).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isVisible(WebDriver driver, By element) {
        try {
            WebElement el = driver.findElement(element);
            return (boolean) ((JavascriptExecutor) driver)
                    .executeScript(
                            "var elem = arguments[0], box = elem.getBoundingClientRect(), " +
                                    "cx = box.left + box.width / 2, cy = box.top + box.height / 2, " +
                                    "e = document.elementFromPoint(cx, cy); for (; e; e = e.parentElement) " +
                                    "{ if (e === elem) return true; } return false;", el);
        } catch (Exception e) {
            return false;
        }
    }

    public void mouseOver(WebDriver driver, By element, int ms) {
        WebElement el = driver.findElement(element);
        new Actions(driver).moveToElement(el).perform();
        wait(ms);
    }

    public int countElements(WebDriver driver, By element) {
        return driver.findElements(element).size();
    }

    public void waitHideElement(WebDriver driver, By element) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(d -> {
            try {
                List<WebElement> elements = d.findElements(element);
                return elements.isEmpty() || !elements.get(0).isDisplayed();
            } catch (Exception e) {
                return true;
            }
        });
    }

    public void pressionarEsc(WebDriver driver) {
        new Actions(driver).sendKeys(Keys.ESCAPE).perform();
    }

    public void tentarClicarElemento(WebDriver driver, By element, int tempoEspera) {
        for (int i = 0; i < 3; i++) {
            if (isVisible(driver, element)) {
                click(driver, element, tempoEspera);
                break;
            }
        }
    }

    public void tentarPreencherCampo(WebDriver driver, By element, String texto) {
        for (int i = 0; i < 3; i++) {
            if (isVisible(driver, element)) {
                sendKeys(driver, element, texto, 0);
                break;
            }
        }
    }

    public void scrollToElement(WebDriver driver, By element) {
        for (int i = 0; i < 3; i++) {
            if (!isVisible(driver, element)) {
                WebElement el = driver.findElement(element);
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", el);
            }
            if (isVisible(driver, element)) break;
        }
    }

    public void screeanShot(WebDriver driver) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\TesteTrelloJava\\AutomacaoTrello\\src\\print\\" + "screenshot_" + System.currentTimeMillis() + ".png");
        screenshot.renameTo(dest);
    }

    // ---------- IMAP GMAIL ----------
    public String obterCodigoVerificacaoGmail() throws Exception {

        Properties props = new Properties();

        props.put("mail.imap.ssl.enable", "true");
        props.put("mail.imap.ssl.trust", "*");
        props.put("mail.imap.ssl.checkserveridentity", "false");
        props.put("mail.imaps.connectiontimeout", "10000");
        props.put("mail.imaps.timeout", "10000");


        Session session = Session.getInstance(props);
        Store store = session.getStore("imap");

        store.connect("imap.gmail.com",993, Global.user, Global.passApp);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] msgs = inbox.search(new SubjectTerm("Verificacao da sua identidade"));

        if (msgs.length == 0)
            throw new MessagingException("Nenhum e-mail encontrado.");

        Message msg = msgs[msgs.length - 1];

        String body = getTextFromMessage(msg);
        return body;
    }

    public String obterCodigoVerificacaoGmailJakarta()
            throws Exception {

        Properties props = new Properties();
        props.put("mail.imap.ssl.enable", "true");
        props.put("mail.imap.ssl.trust", "*");
        props.put("mail.imap.ssl.checkserveridentity", "false");
        props.put("mail.imaps.connectiontimeout", "10000");
        props.put("mail.imaps.timeout", "10000");


        Session session = Session.getInstance(props);
        Store store = session.getStore("imaps");

        store.connect("imap.gmail.com",993, Global.user, Global.passApp);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        SearchTerm searchTerm = new OrTerm(
                new SubjectTerm("Verific"),
                new SubjectTerm("identidade")
        );

        Message[] msgs = inbox.search(searchTerm);

        if (msgs.length == 0) {
            throw new MessagingException("Nenhum e-mail encontrado.");
        }

        Message msg = msgs[msgs.length - 1];

        String body = getTextFromMessage(msg);
        return body;

    }
    private String getTextFromMessage(Message message) throws Exception {
        Object content = message.getContent();

        if (content instanceof String) {
            return (String) content;
        }

        if (content instanceof MimeMultipart) {
            return getTextFromMimeMultipart((MimeMultipart) content);
        }

        return null;
    }

    private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
        String result = "";

        for (int i = 0; i < mimeMultipart.getCount(); i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);

            if (bodyPart.isMimeType("text/plain")) {
                result += bodyPart.getContent();
            } else if (bodyPart.isMimeType("text/html")) {
                result += org.jsoup.Jsoup.parse(bodyPart.getContent().toString()).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result += getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            }
        }
        return result;
    }

}