import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class FunctionalTests {

    @BeforeEach
    public void setup() {
        // Instância dos objetos
        Global.capabilitiesMethods = new CapabilitiesMethods();
        // Instância do driver
        Global.driver = Global.capabilitiesMethods.browserConfig();
        Global.trello = new Trello(Global.driver);
        Global.trello.paginaInicial();



    }

    @Test
    public void loginTrello() {

        // logar
        Global.trello.login();

        Global.trello.criarQuadro("teste");                     // criarQuadro
        Global.trello.criarLista("teste");                      // criarLista
        Global.trello.criarCartao("teste", "teste");            // criarCartao        
        Global.trello.criarTag("teste", "teste", "//button[@data-testid='color-tile-green_light']"); 
        Global.trello.removerTag("teste", "teste");             // removerTag
        Global.trello.excluirCartao("teste", "teste");          // excluirCartao
        Global.trello.excluirLista("teste");                    // excluirLista
        Global.trello.excluirQuadro();                          // excluirQuadro
        Global.trello.logout();                                 // logout
    }

    @Test
    public void loopTrello() {

        Global.trello.login();

        // loop criação
        Global.trello.loopCriacao();

        // loop exclusão
        Global.trello.loopExclusao();

        Global.trello.logout();
    }

    @Test
    public void loopTrelloRandom() {

        Global.trello.login();

        // loop criação random
        Global.trello.loopCriacaoRandom();

        // loop exclusão
        Global.trello.loopExclusao();

        Global.trello.logout();
    }

    @Test
    public void fecharQuadros() {

        Global.trello.login();

        Global.trello.fecharQuadros("//li[contains(@class,'boards-page-board-section-list-item')]");

        Global.trello.logout();
    }

    @AfterEach
    public void teardown() {
        // Screenshot
        Global.capabilitiesMethods.screeanShot(Global.driver);

        // Finalização do browser
        try {
            if (Global.driver != null) {
                Global.driver.close();
                //Global.driver.quit();
            }
        } catch (Exception ex) {
            System.out.println("Erro ao finalizar o teste ou tirar o print: " + ex.getMessage());
        }
    }
}