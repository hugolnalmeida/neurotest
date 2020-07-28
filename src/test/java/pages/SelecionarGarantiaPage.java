package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelecionarGarantiaPage extends BasePage{

    //Propriedades que vão estar disponíveis dentro da classe para navegar entre os métodos
    private String nome_console;
    private String textoParaValidar;

    //Construtor que herda atributo de BasePage
    public SelecionarGarantiaPage(String nome_console, WebDriver navegador) {
        super(navegador);
        this.nome_console = nome_console;
    }

    //Método que seleciona o tempo de garantia
    public SelecionarGarantiaPage selectOption() {

        //Clicar na opção com XPath "//span[text()="+ 12 meses"]"
        navegador.findElement(By.xpath("//span[text()=\"+ 12 meses\"]")).click();

        //Retorna a própria página
        return this;
    }

    //Método que clica em continuar a compra até a página da Cesta de compras
    public CestaPage continueToBasket(){

        //Clicar em continuar através do XPath "//span[text()="Continuar"]"
        navegador.findElement(By.xpath("//span[text()=\"Continuar\"]")).click();

        //Retorna página da Cesta de compras
        return new CestaPage(nome_console,textoParaValidar,navegador);
    }

    //Método de abordagem funcional: reúne todos os métodos da page
    public CestaPage selectToBasket(){
        selectOption();
        continueToBasket();
        return new CestaPage(nome_console,textoParaValidar,navegador);
    }
}
