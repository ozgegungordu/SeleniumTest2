package pagesElements;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.assistedinject.Assisted;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;
import utilities.Parent;


@Getter
public class MainPageElements extends Parent{

    public MainPageElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="div[class*='netekstre'] div[class='right-icon']")
    private WebElement btnNetekstreModulu;

}
