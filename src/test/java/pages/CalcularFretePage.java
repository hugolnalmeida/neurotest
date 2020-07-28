package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalcularFretePage extends BasePage{
    //Propriedades que vão estar disponíveis dentro da classe para navegar entre os métodos
    private String nome_console;

    //Construtor que herda atributo de BasePage
    public CalcularFretePage(String nome_console, WebDriver navegador) {
        super(navegador);
        this.nome_console = nome_console;
    }

    //Método que digita cep
    public CalcularFretePage typeCep(String cep) {

        //Digitar cep no campo disponível para cep do site de XPath "//input[@id='freight-field']"
        navegador.findElement(By.xpath("//input[@id=\"freight-field\"]")).sendKeys(cep);

        //Retorna a própria página
        return this;
    }

    //Método que calcula frete conforme cep digitado
    public CalcularFretePage clickOk() {

        //Clicar no link com texto "Ok" de XPath "//span[text()=\"Ok\"]";
        navegador.findElement(By.xpath("//span[text()=\"Ok\"]")).click();

        //Aguarda 10 segundos até que os valores de frete sejam carregados
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='freight-options__PriceContainer-cesh2v-2 liUVaa ViewUI-sc-1ijittn-6 iXIDWU']//span[@class=\"freight-options__SlashedText-cesh2v-1 fUojCD TextUI-sc-12tokcy-0 bLZSPZ\"]")));

        //Retorna a própria página
        return this;
    }

    //Método que identifica frete e imprime valor no console
    public CalcularFretePage saveFreight() {
        //Identificar o valor do frete através do XPath "//div[@class='freight-options__PriceContainer-cesh2v-2 liUVaa ViewUI-sc-1ijittn-6 iXIDWU']/span[@class='TextUI-sc-12tokcy-0 LbEgj']"
        WebElement freight = navegador.findElement(By.xpath("//div[@class=\"freight-options__PriceContainer-cesh2v-2 liUVaa ViewUI-sc-1ijittn-6 iXIDWU\"]//span[@class=\"TextUI-sc-12tokcy-0 LbEgj\"]"));

        //Imprime valores de frete no console
        System.out.println(freight.getText());

        //Retorna a própria página
        return this;
    }

    //método que clica em comprar e vai até a página de selecionar garantia
    public SelecionarGarantiaPage buy(){

        //Clicar em "comprar" identificado pelo XPath "//span[text()="comprar"]"
        navegador.findElement(By.xpath("//span[text()=\"comprar\"]")).click();

        //Retorna página para seleção da garantia
        return new SelecionarGarantiaPage(nome_console,navegador);
    }

    //Método de abordagem funcional: reúne todos os métodos da page
    public SelecionarGarantiaPage buyWithFreight(String cep){
        typeCep(cep);
        clickOk();
        saveFreight();
        buy();
        return new SelecionarGarantiaPage(nome_console,navegador);
    }
}
