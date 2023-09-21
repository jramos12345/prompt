import java.beans.Transient;
import java.nio.channels.WritableByteChannel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test{

    @Test
    public void securedCardApp(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.discover.com/");

        //ideally this and other web elements get put into pageObject classes to minimize code duplication
        WebElement creditCardLink = driver.findElement(by.name(""));

        creditCardLink.click();

        //given more time a better way is probably to us parent/child xpaths but the link was unique so this was a quick way to grab the element.
        WebElement applyButton = driver.findElement(by.xpath("//a[@href='https://www.discovercard.com/application/website/apply?srcCde=KXPA&ICMPGN=ALL_CC_SECURED_APPLY_NOW_BTN&adobe_mc=MCMID%3D40496086677447153932392470092417576974%7CMCORGID%3D0D6C4673527839230A490D45%2540AdobeOrg%7CTS%3D1695336638&sv_session=d993154d45e5d7e6e1b5df42a07d0b6d&_gl=1*1wa7g1d*_ga*MTQ4ODY0NTU4NS4xNjk1MzI5Nzgz*_ga_3MJNPV4VSE*MTY5NTMzNjQzOC4yLjEuMTY5NTMzNjYzOC41OS4wLjA.&_ga=2.248225863.192376913.1695329783-1488645585.1695329783']"));
        
        applyButton.click();

        WebElement skipStep = driver.findElement(by.id("adaptive-skip-this-step"));

        skipStep.click();

        WebElement cashAdvanceRate = driver.findElement(by.className("cash-rate"));

        //get value and turn into a double to compare
        String value = cashAdvanceRate.getText();
        //remove % sign
        value = value.substring(0,str.length() - 1);
        double rate = Double.parseDouble(value);
        assertThat(rate, greaterThan(20));

        driver.quit();
   
    }



}