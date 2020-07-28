package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class CestaPage extends BasePage {

    //Propriedades que vão estar disponíveis dentro da classe para navegar entre os métodos
    private String nome_console;
    private String textoParaValidar;

    //Construtor que herda atributo de BasePage
    public CestaPage(String nome_console, String textoParaValidar, WebDriver navegador) {
        super(navegador);
        this.nome_console = nome_console;
        this.textoParaValidar = textoParaValidar;
    }

    //Método que identifica produto na cesta e pega seu nome
    public CestaPage identification() {
        //Identifica o produto na cesta através do XPath "//a[@class='link-default clearfix']"
        WebElement compra = navegador.findElement(By.xpath("//a[@class=\"link-default clearfix\"]"));

        //Pega o texto do produto
        textoParaValidar = compra.getText();

        //Retorna a própria página
        return this;
    }

    //Método de abordagem funcional: reúne todos os métodos da page
    public CestaPage identify(){
        identification();
        return this;
    }

    //Métodos GETs e SETs para manipular Strings da classe

    public String getNome_console() {
        return nome_console;
    }

    public void setNome_console(String nome_console) {
        this.nome_console = nome_console;
    }

    public String getTextoParaValidar() {
        return textoParaValidar;
    }

    public void setTextoParaValidar(String textoParaValidar) {
        this.textoParaValidar = textoParaValidar;
    }
}
