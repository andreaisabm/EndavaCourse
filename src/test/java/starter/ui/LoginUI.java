package starter.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {

    public static final By USER_NAME = By.id("user-name");
    public static final By USER_PASSWORD = By.id("password");
    public static final Target LOGIN_BUTTON = Target.the("Login button").located(By.id("login-button"));
    public static final Target BURGER_BUTTON = Target.the("Burger button").located(By.id("react-burger-menu-btn"));
    public static final Target LOGOUT_BUTTON = Target.the("Logout button").located(By.id("logout_sidebar_link"));


}
