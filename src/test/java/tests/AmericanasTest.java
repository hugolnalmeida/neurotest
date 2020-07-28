package tests;

import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Web;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "AmericanasTestData.csv")
public class AmericanasTest {
    WebDriver navegador;

    @Before
    public void setUp(){

        //Cria navegador e vai até o site escolhido
        navegador = Web.createChrome();
    }

    //Método de teste utilizando arquivo .csv para inputs
    @Test
    public void testConsole(@Param(name="produto")String produto, @Param(name="cep")String cep){

        //Digitar "PS4" no campo de busca de XPath "//input[@id='h_search-input']"
        navegador.findElement(By.xpath("//input[@id=\"h_search-input\"]")).sendKeys(produto);

        // Clicar no botão de pesquisa (Lupa) de XPath "//button[@id='h_search-btn']"
        navegador.findElement(By.xpath("//button[@id=\"h_search-btn\"]")).click();

        //Identificar o primeiro texto "console" da página através do XPath "//h2[@class='TitleUI-bwhjk3-15 khKJTM TitleH2-sc-1wh9e1x-1 gYIWNc']"
        WebElement console = navegador.findElement(By.xpath("//h2[@class=\"TitleUI-bwhjk3-15 khKJTM TitleH2-sc-1wh9e1x-1 gYIWNc\"]"));

        //Guarda o texto do console para validar posteriormente
        String nome_console = console.getText();

        //Clicar no elemento com o texto "console"
        console.click();

        //Digitar cep no campo disponível para cep do site de XPath "//input[@id='freight-field']"
        navegador.findElement(By.xpath("//input[@id=\"freight-field\"]")).sendKeys(cep);

        //Clicar no link com texto "Ok" de XPath "//span[text()=\"Ok\"]";
        navegador.findElement(By.xpath("//span[text()=\"Ok\"]")).click();

        //Aguarda 10 segundos até que os valores de frete sejam carregados
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='freight-options__PriceContainer-cesh2v-2 liUVaa ViewUI-sc-1ijittn-6 iXIDWU']//span[@class=\"freight-options__SlashedText-cesh2v-1 fUojCD TextUI-sc-12tokcy-0 bLZSPZ\"]")));

        //Identificar o valor do frete através do XPath "//div[@class='freight-options__PriceContainer-cesh2v-2 liUVaa ViewUI-sc-1ijittn-6 iXIDWU']/span[@class='TextUI-sc-12tokcy-0 LbEgj']"
        WebElement frete = navegador.findElement(By.xpath("//div[@class=\"freight-options__PriceContainer-cesh2v-2 liUVaa ViewUI-sc-1ijittn-6 iXIDWU\"]//span[@class=\"TextUI-sc-12tokcy-0 LbEgj\"]"));

        //Imprime valores de frete
        System.out.println(frete.getText());

        //Clicar em "comprar" identificado pelo XPath "//span[text()="comprar"]"
        navegador.findElement(By.xpath("//span[text()=\"comprar\"]")).click();

        //Clicar na opção com XPath "//span[text()="+ 12 meses"]"
        navegador.findElement(By.xpath("//span[text()=\"+ 12 meses\"]")).click();

        //Clicar em continuar através do XPath "//span[text()="Continuar"]"
        navegador.findElement(By.xpath("//span[text()=\"Continuar\"]")).click();

        //Identifica o produto na cesta através do XPath "//a[@class='link-default clearfix']"
        WebElement compra = navegador.findElement(By.xpath("//a[@class=\"link-default clearfix\"]"));

        //Pega o texto do produto
        String textoParaValidar = compra.getText();

        //Compara o texto do produto na cesta com o texto do produto selecionado no início do teste
        assertEquals( nome_console, textoParaValidar.toLowerCase());
    }

    @After
    public void tearDown(){
        //Fecha browser
        navegador.close();
    }
}
