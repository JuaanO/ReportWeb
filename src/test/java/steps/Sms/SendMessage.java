package steps.Sms;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import steps.TestBase;

import static java.lang.Thread.sleep;

public class SendMessage extends TestBase {
//    private final WebDriver driver;
//
//    public SendMessage(WebDriver driver){
//        this.driver = driver;
//    }
    
    @When("^el usuario escoge realizar una campana masiva de sms$")
    public void elUsuarioEscogeRealizarUnaCampanaMasivaDeSms() {
        smsPage.chooseMassiveCampaign();
    }

    @And("^le usuario selecciona la (.*?) de destinatario$")
    public void leUsuarioSeleccionaLaFuenteDeDestinatario(String fuente) throws InterruptedException {
        smsPage.chooseDataSource(fuente);
    }

    @And("^le usuario selecciona (.*?) de mensaje$")
    public void leUsuarioSeleccionaTipoDeMensaje(String tipo) {
        smsPage.chooseTypeMessage(tipo);
        
    }

    @And("el usuario carga el archivo")
    public void elUsuarioCargaElArchivo() {
        
    }

    @And("el usuario selecciona selecciona llena los datos")
    public void elUsuarioSeleccionaLaColumnaConLosNumenros() {

    }

    @And("^el usuario presiona siguiente$")
    public void elUsuarioPresionaSiguiente() throws InterruptedException {

        smsPage.nextStep();
        sleep(3000);
    }

    @Then("el suaurio puede verificar los datos ingresados son correctos")
    public void elSuaurioPuedeVerificarLosDatosIngresadosSonCorrectos() {
    }

    @And("^el usuario ingresa (.*?) del paso 2$")
    public void elUsuarioIngresaLosDatosDelPaso(String datos) throws InterruptedException {
        sleep(3000);
        smsPage.message(datos);
    }

    @And("^el usuario ingresa un nombre de campana$")
    public void elUsuarioIngresaUnNombreDeCampana() throws InterruptedException {

        sleep(3000);
        smsPage.inputChampaignName();
    }

    @And("escoge el grupo")
    public void escogeElGrupo() {
        smsPage.chooseGroup();
    }

    @And("carga el grupo")
    public void cargaElGrupo() {
        smsPage.loadGroup();
    }

    @And("presiona siguiente")
    public void presionaSiguiente() throws InterruptedException {
        sleep(4000);
        driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
        sleep(4000);
    }
}
