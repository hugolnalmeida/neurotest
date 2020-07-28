package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    //Construtor que herda atributo de BasePage
    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    //Método que digita nome do produto no campo de busca
    public HomePage typeProduct(String produto) {

        //Digitar "PS4" no campo de busca de XPath "//input[@id='h_search-input']"
        navegador.findElement(By.xpath("//input[@id=\"h_search-input\"]")).sendKeys(produto);

        //Retorna a própria página
        return this;
    }
    //Método que clica no botão de busca
    public ProdutosEncontradosPage search(){
        // Clicar no botão de pesquisa (Lupa) de XPath "//button[@id='h_search-btn']"
        navegador.findElement(By.xpath("//button[@id=\"h_search-btn\"]")).click();

        //Retorna página com os produtos encontrados na busca
        return new ProdutosEncontradosPage(navegador);
    }

    //Método de abordagem funcional: reúne todos os métodos da page
    public ProdutosEncontradosPage searchProduct(String produto){
        typeProduct(produto);
        search();
        return new ProdutosEncontradosPage(navegador);
    }
}
