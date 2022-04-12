package pagesElements;

import com.google.inject.Binder;
import com.google.inject.Module;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;
import utilities.Parent;

@Getter
public class LoginPageElements extends Parent{

    public LoginPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#username")
    private WebElement inputUserName;
    @FindBy(css = "#password")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[normalize-space()='Giriş Yap']")
    private WebElement btnLogin;


    public void InvalidLogin() {
        sendKeysFunction(getInputUserName(), "ortaknetekstre@yandex.com");
        sendKeysFunction(getInputPassword(), "Kd!cyhz4");
        clickFunction(getBtnLogin());
    }

}
