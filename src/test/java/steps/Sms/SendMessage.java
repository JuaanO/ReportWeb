package steps.Sms;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import steps.TestBase;

public class SendMessage extends TestBase {
    private final WebDriver driver;
    public SendMessage(WebDriver driver){
        this.driver = driver;
    }
    
    @When("^el usuario escoge realizar una campana masiva de sms$")
    public void elUsuarioEscogeRealizarUnaCampanaMasivaDeSms() {
        
    }

    @And("^le usuario selecciona la (.*?) de destinatario$")
    public void leUsuarioSeleccionaLaFuenteDeDestinatario() {
    }

    @And("^le usuario selecciona (.*?) de mensaje$")
    public void leUsuarioSeleccionaTipoDeMensaje() {
        
    }

    @And("el usuario carga el archivo")
    public void elUsuarioCargaElArchivo() {
        
    }

    @And("el usuario selecciona selecciona llena los datos")
    public void elUsuarioSeleccionaLaColumnaConLosNumenros() {

    }

    @And("^el usuario presiona siguiente$")
    public void elUsuarioPresionaSiguiente() {
        
    }

    @Then("el suaurio puede verificar los datos ingresados son correctos")
    public void elSuaurioPuedeVerificarLosDatosIngresadosSonCorrectos() {
    }

    @And("^el usuario ingresa (.*?) del paso 2$")
    public void elUsuarioIngresaLosDatosDelPaso(String datos) {
    }

    @And("^el usuario ingresa un nombre de campana$")
    public void elUsuarioIngresaUnNombreDeCampana() {

    }
}
