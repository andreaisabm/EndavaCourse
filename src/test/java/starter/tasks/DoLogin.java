package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.LoginUI;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DoLogin{

/*    private String userName;

    private String userPassword;

    public DoLogin(String userName, String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }*/

    public static Performable withCredentials(String userName, String userPassword){
        return Task.where("{0} tries to Login",
                WaitUntil.the(LoginUI.USER_NAME, isVisible()).forNoMoreThan(20L).seconds(),
                Enter.theValue(userName).into(LoginUI.USER_NAME),
                Enter.theValue(userPassword).into(LoginUI.USER_PASSWORD),
                Click.on(LoginUI.LOGIN_BUTTON)
        );
        //return instrumented(DoLogin.class, userName, userPassword);
    }

    public static Performable logOut(){
        return Task.where("{0} tries to log out",
                Click.on(LoginUI.BURGER_BUTTON),
                Click.on(LoginUI.LOGOUT_BUTTON)
        );
        //return instrumented(DoLogin.class, userName, userPassword);
    }

/*    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginUI.USER_NAME, isVisible()),
                Enter.theValue(userName).into(LoginUI.USER_NAME),
                Enter.theValue(userPassword).into(LoginUI.USER_PASSWORD),
                Click.on(LoginUI.LOGIN_BUTTON)
        );
    }*/
}
