package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createChrome(){
        //Abrir navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hugo leonardo\\drivers\\chromedriver83.exe");
        WebDriver navegador = new ChromeDriver();

        //Navegar até a página
        navegador.get("https://www.americanas.com.br/");

        //Temporizador para visualizar melhor o teste
        navegador.manage().timeouts().implicitlyWait (40, TimeUnit.SECONDS);

        //Retorna o navegador criado
        return navegador;
    }
}
