package tasks;

import models.LoginCredentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.LoginPage;

public class LoginTaskCorrect  implements Task {

    LoginCredentials credentials;

    public LoginTaskCorrect(LoginCredentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LoginPage.BTN_LOGIN));
        actor.attemptsTo(Enter.theValue(credentials.getIdentification()).into(LoginPage.TXT_CEDULA));
        actor.attemptsTo(Enter.theValue(credentials.getPassword()).into(LoginPage.TXT_PAASWORD));
        actor.attemptsTo(Click.on(LoginPage.BTN_INICIAR));

    }
    public static LoginTaskCorrect inThePage(LoginCredentials credentials){
        return Tasks.instrumented(LoginTaskCorrect.class,credentials);
    }
}
