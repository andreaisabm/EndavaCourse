package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import starter.navigation.NavigateTo;
import starter.questions.OnThePrincipalPage;
import starter.questions.SwagLabsStoreQuestions;
import starter.tasks.DoLogin;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginStepDefinitions {

    @Given("{actor} is a {}")
    public void userNavigatesToHomepage(Actor actor, String customerType){
        actor.wasAbleTo(NavigateTo.theSauceHomePage());
    }

    @When("{actor} tries to login")
    public void userTriesToLogin(Actor actor){
        actor.attemptsTo(
                DoLogin.withCredentials("standard_user",
                        "secret_sauce")
        );
    }

    @When("{actor} tries to login with username {} and password {}")
    public void userTriesToLoginWithCredentials(Actor actor, String userName, String password){
        actor.attemptsTo(
                DoLogin.withCredentials(userName,
                        password)
        );
    }

    @When("{actor} tries to log out")
    public void userTriesToLoginWithCredentials(Actor actor){
        userTriesToLogin(actor);
        actor.attemptsTo(
                DoLogin.logOut()
        );
    }

    @Then("{actor} should see products list")
    public void userShouldSeeProductList(Actor actor){
        actor.should(
                seeThat("The display title",
                        OnThePrincipalPage.theTitleIs(),equalTo("PRODUCTS")
                )
        );

        theActorInTheSpotlight().should(
                seeThat(
                        "the display tile", SwagLabsStoreQuestions.ProductsAvailable(), equalTo("PRODUCTS")
                )
        );
    }

    @Then("{actor} should see the log in page")
    public void userShouldSeeLoginPage(Actor actor){
        theActorInTheSpotlight().should(
                seeThat(
                        "the display page", SwagLabsStoreQuestions.successLogOut(), equalTo(true)
                )
        );
    }



}
