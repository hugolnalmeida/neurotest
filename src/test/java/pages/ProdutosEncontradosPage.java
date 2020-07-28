package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdutosEncontradosPage extends BasePage {
    //Propriedades que vão estar disponíveis dentro da classe para navegar entre os métodos
    private WebElement console;
    private String nome_console;

    //Construtor que herda atributo de BasePage
    public ProdutosEncontradosPage(WebDriver navegador) {
        super(navegador);
    }

    //Método que identifica o primeiro produto e guarda seu nome
    public ProdutosEncontradosPage select() {

        //Identificar o primeiro texto "console" da página através do XPath "//h2[@class='TitleUI-bwhjk3-15 khKJTM TitleH2-sc-1wh9e1x-1 gYIWNc']"
        console = navegador.findElement(By.xpath("//h2[@class=\"TitleUI-bwhjk3-15 khKJTM TitleH2-sc-1wh9e1x-1 gYIWNc\"]"));

        //Guarda o texto do console para validar posteriormente
        nome_console = console.getText();

        //Retorna própria página
        return this;
    }

    //Método que clica no produto e retorna página de calcular frete
     public CalcularFretePage clickProduct(){
        //Clicar no elemento com o texto "console"
        console.click();

        //Retorna a página para cálculo do frete
        return new CalcularFretePage(nome_console,navegador);
    }

    //Método de abordagem funcional: reúne todos os métodos da page
    public CalcularFretePage selectAndClickProduct(){
        select();
        clickProduct();
        return new CalcularFretePage(nome_console,navegador);
    }
}
