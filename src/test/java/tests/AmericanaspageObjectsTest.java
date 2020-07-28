package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.CestaPage;
import pages.HomePage;
import suporte.Web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "AmericanasTestData.csv")
public class AmericanaspageObjectsTest {

    //Atributo de navegação
    private WebDriver navegador;

    @Before
    public void setUp(){
        //Abrir navegador
        navegador = Web.createChrome();
    }

    @Test
    public void americanasTest(@Param(name="produto")String produto, @Param(name="cep")String cep){
        //Método que reúne todos os métodos das pages e executa o teste completo
        CestaPage finalPage = new HomePage(navegador)
                .searchProduct(produto)
                .selectAndClickProduct()
                .buyWithFreight(cep)
                .selectToBasket().identify();

        //Compara os textos do produto na cesta com o do produto selecionado no início do teste, ignorando letras maiúsculas
        assertEquals( finalPage.getNome_console() , finalPage.getTextoParaValidar().toLowerCase());
    }

    @After
    public void tearDown(){
        //Fechar navegador
        navegador.quit();
    }
}
