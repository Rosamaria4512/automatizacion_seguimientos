package com.co.izy.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target BTN_LOGIN = Target.the("click al boton inciar sesion")
            .locatedBy("//a[@href='#/login']");

    public static final Target TXT_CEDULA = Target.the("ingresa identficacion")
            .locatedBy("//input[@id='identificacion_usuario']");
    public static final Target TXT_PAASWORD = Target.the("ingresa contrasena")
            .locatedBy("//input[@id='password_usuario']");

    public static final Target BTN_INICIAR = Target.the("CLICK EN EL BOTON")
            .locatedBy("//button[@id='usuario']");
}
