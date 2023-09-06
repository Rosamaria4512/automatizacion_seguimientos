package com.co.izy.tasks;


import com.co.izy.models.Credentials;
import com.co.izy.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


public class LoginTaskCorrect implements Task {
Credentials credentials;

    public LoginTaskCorrect(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LoginPage.BTN_LOGIN));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actor.attemptsTo(Enter.theValue(credentials.getUsername()).into(LoginPage.TXT_CEDULA));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actor.attemptsTo(Enter.theValue(credentials.getPassword()).into(LoginPage.TXT_PAASWORD));
        actor.attemptsTo(Click.on(LoginPage.BTN_INICIAR));

    }
    public static LoginTaskCorrect inThePage(Credentials credentials){
        return Tasks.instrumented(LoginTaskCorrect.class,credentials);
    }
}
