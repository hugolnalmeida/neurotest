package pages;

import org.openqa.selenium.WebDriver;

//Classe base para todas as pages
public class BasePage {

    //Propriedade que vai estar disponível dentro da classe para navegar entre os métodos
    protected WebDriver navegador;

    //Construtor recebendo uma instância do WebDriver
    public BasePage(WebDriver navegador){
        this.navegador = navegador;
    }
}
