import jakarta.mail.MessagingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Trello {

    private WebDriver driver;

    public Trello(WebDriver driver) {
        this.driver = driver;
    }

    public void paginaInicial() {
        driver.get("https://trello.com/");
    }

    //elementos
    private static String acceptCookies = "onetrust-accept-btn-handler";
    private static String menuHamburguer = "//button[@data-testid='menubutton']";
    private static String lnkLogin = "//div[contains(@class,'Buttonsstyles__ButtonGroup')]/a[contains(@data-uuid,'login')]";
    private static String user = "//input[contains(@id,'username')]";
    private static String btnSubmit = "login-submit";
    private static String password = "password";
    private static String codeVerification = "//div[contains(@data-testid,'otp-input-index')]";
    private static String promptMfa = "mfa-promote-dismiss";
    private static String preferencesCookies = "//span[@data-testid='experiment-one-button-icon']";
    private static String creatFrame = "//button[@data-testid='create-board-tile']/div/span";
    private static String creatFrameList = "//li[@data-testid='create-board-tile']/div/p/span";
    private static String nameFrame = "//input[contains(@class,'nch-textfield__input')]";
    private static String btnCreatFrame = "//button[contains(@data-testid,'create-board-submit-button')]";
    private static String board = "//ol[@id='board']";
    private static String btnCollapseDesktop = "//button[@data-testid='workspace-navigation-collapse-button']";
    private static String portal = "//div[@class='atlaskit-portal']";
    private static String txtareaListName = "//textarea[@data-testid='list-name-textarea']";
    private static String btnListComposer = "//button[contains(@data-testid,'list-composer')]";
    private static String nameList = "//*[*[textarea[@data-testid='list-name-textarea']]//button[contains(@data-testid,'list-composer-add')]]//textarea";
    private static String btnSaveList = "//button[@data-testid='list-composer-add-list-button']";
    private static String closeNewList = "//span[@data-testid='CloseIcon']";
    private static String nameCard = "//textarea[contains(@data-testid,'list-card-composer-textarea')]";
    private static String saveCard = "//button[contains(@data-testid,'list-card-composer-add-card-button')]";
    private static String menuTag = "//button[contains(text(),'Etiquetas')]";
    private static String btnNewTag = "//button[text()='Criar uma nova etiqueta']";
    private static String btnCreat = "//button[contains(text(),'Criar')]";
    private static String btnCloseTag = "//button[contains(@aria-label,'pop-over')]";
    private static String btnCloseCard = "//button[contains(@aria-label,'Fechar caixa de diálogo')]//span[contains(@data-testid,'CloseIcon')]";
    private static String tagSelected = "//*[input[@aria-checked='true']]/span/span";
    private static String btnMenuArquive = "//button[@data-testid='card-back-archive-button']";
    private static String exclude = "//button[@data-testid='card-back-delete-card-button']";
    private static String confirmExclude = "//button[@data-testid='popover-confirm-button']";
    private static String showMenu = "//button[@aria-label='Mostrar Menu']";
    private static String btnItensArquiveted = "//button[div[contains(text(),'Itens arquivados')]]";
    private static String btnAlternList = "//button[normalize-space(text())='Listas']";
    private static String confirmExcludeList = "//button[contains(text(),'Excluir')]";
    private static String btnCloseExcludeList = "//button[contains(@aria-label,'Fechar pop-over')]";
    private static String btnShowMenu = "//*[button[@data-testid='board-share-button']]/button[@aria-label='Mostrar Menu']";
    private static String btnCloseFrame = "//button[div[normalize-space(text())='Fechar quadro']]";
    private static String removeIcon = "//*[*[span[@data-testid='RemoveIcon']]]";
    private static String closeBoardConfirmOne = "//button[@data-testid='popover-close-board-confirm']";
    private static String closeBoardDelete = "//button[contains(@data-testid,'close-board-delete')]";
    private static String closeBoardDeleteExclude = "//button[contains(@data-testid,'close-board-delete') and normalize-space(text())='Excluir']";
    private static String headMember = "//section[@data-testid='header-member-menu-popover']";
    private static String btnOpenHeaderMemberMenu = "//button[contains(@class,'open-header-member-menu')]";
    private static String btnLogout = "//button[contains(@data-testid,'logout')]";
    private static String btnSecondLogout = "//button[contains(@data-testid,'logout-button')]";
    private static String boardIcon = "//span[@data-testid='BoardIcon']";
    private static String preferences = "//span[@data-testid='experiment-one-button-icon']";
    private static String bannerNews = "//h2[contains(text(),'Conheça as novidades')]";
    private static String btnIgnore = "//button[span[contains(text(),'Ignorar')]]";
    private static String btnIOk = "//button[span[contains(text(),'OK')]]";
    private static String addTag = "//button[contains(@aria-label,'etiqueta')]";
    private static String openActions = "//button[contains(@data-testid,'card-back')and contains(@aria-label,'Ações')]";
    private static String btnArquiveList = "//button[contains(@data-testid,'archive')]";
    private static String lnkSmallNav = "//a[contains(text(),'Log in') and contains(@class,'SmallNav')]";


    public void login() {


        // Clica no botão de aceitar cookies
        Global.capabilitiesMethods.waitVisible(
                Global.driver, By.id(acceptCookies));
        Global.capabilitiesMethods.click(
                Global.driver, By.id(acceptCookies), 1000);

        // Verifica se existe o menu hambúrguer
        if (Global.capabilitiesMethods.isVisible(
                Global.driver, By.xpath(menuHamburguer))) {

            // Clica no menu hambúrguer
            Global.capabilitiesMethods.click(
                    Global.driver, By.xpath(menuHamburguer), 1000);

            // Clica no botão login
            if (Global.capabilitiesMethods.isVisible(
                    Global.driver,
                    By.xpath(lnkLogin)

            )) {
                Global.capabilitiesMethods.click(
                        Global.driver,
                        By.xpath(lnkLogin),
                        1000
                );
            }
            if (Global.capabilitiesMethods.isVisible(
                    Global.driver,
                    By.xpath(lnkSmallNav)

            )) {
                Global.capabilitiesMethods.click(
                        Global.driver,
                        By.xpath(lnkSmallNav),
                        1000
                );
            }

        }

        // Verifica se existe outro botão de login
        if (Global.capabilitiesMethods.isVisible(
                Global.driver,
                By.xpath(lnkLogin))) {

            Global.capabilitiesMethods.click(
                    Global.driver,
                    By.xpath(lnkLogin),
                    1000
            );
        }

        // Preenche e envia o username
        Global.capabilitiesMethods.sendKeys(Global.driver, By.xpath(user), Global.user);

        // Clica no login
        Global.capabilitiesMethods.click(Global.driver, By.id(btnSubmit), 2000);
        Global.capabilitiesMethods.waitForPageLoad(Global.driver);

        // Aguarda campo de senha
        Global.capabilitiesMethods.waitExists(Global.driver, By.id(password));

        // Preenche senha
        Global.capabilitiesMethods.sendKeys(Global.driver, By.id(password), Global.pass);

        // Clica em acessar
        Global.capabilitiesMethods.click(Global.driver, By.id(btnSubmit), 3000);
        Global.capabilitiesMethods.waitForPageLoad(Global.driver);
        // Caso precise digitar código de verificação (OTP)
        if (Global.capabilitiesMethods.isVisible(
                Global.driver, By.xpath(codeVerification))) {
            String codigo = null;
            try {
                codigo = Global.capabilitiesMethods.obterCodigoVerificacaoGmailJakarta();
            } catch (MessagingException | IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (codigo == null || codigo.isBlank()) {
                throw new RuntimeException("Falha ao obter o código de verificação do Gmail.");
            }


            int indiceDoisPontos = codigo.lastIndexOf("código:");

            codigo = codigo.substring(indiceDoisPontos, indiceDoisPontos + 14);
            codigo = codigo.replace("código:", "").trim();

            int contador = 0;
            for (char key : codigo.toCharArray()) {
                Global.capabilitiesMethods.sendKeys(
                        Global.driver,
                        By.xpath("//div[contains(@data-testid,'otp-input-index-" + contador + "-container')]/input"),
                        String.valueOf(key)
                );
                contador++;
            }
        }

        // Remove o prompt de MFA caso apareça
        if (Global.capabilitiesMethods.exists(Global.driver, By.id(promptMfa))) {
            Global.capabilitiesMethods.click(
                    Global.driver, By.id(promptMfa),50);
        }
    }

    public void criarQuadro(String novoQuadro) {

        // espera a página carregar
        Global.capabilitiesMethods.wait(3000);
        Global.capabilitiesMethods.waitForPageLoad(Global.driver);

        // fecha as preferências de cookies (se existirem)
        if (Global.capabilitiesMethods.exists(Global.driver, By.xpath(preferencesCookies))) {
            Global.capabilitiesMethods.click(
                    Global.driver,
                    By.xpath(preferencesCookies),
                    1000
            );
        }

        Global.capabilitiesMethods.waitForPageLoad(Global.driver);
        //verifica se o banner de novidades está aberto e fecha
        if (Global.capabilitiesMethods.isVisible(Global.driver, By.xpath(bannerNews))) {
            Global.capabilitiesMethods.click(
                    Global.driver,
                    By.xpath(btnIgnore),
                    2000
            );

        }
        //verifica se o banner com o botão ok está visivel e fecha
        if (Global.capabilitiesMethods.isVisible(Global.driver, By.xpath(btnIOk))) {
            Global.capabilitiesMethods.click(
                    Global.driver,
                    By.xpath(btnIOk),
                    1000
            );
        }
        // clica no botão "criar quadro"
        if (Global.capabilitiesMethods.exists(Global.driver, By.xpath(creatFrame))) {
            Global.capabilitiesMethods.scrollToElement(
                    Global.driver,
                    By.xpath(creatFrame)
            );
            Global.capabilitiesMethods.click(
                    Global.driver,
                    By.xpath(creatFrame),
                    1000
            );
        }
        //verifica se o banner com o botão ok está visivel e fecha
        if (Global.capabilitiesMethods.isVisible(Global.driver, By.xpath(btnIOk))) {
            Global.capabilitiesMethods.click(
                    Global.driver,
                    By.xpath(btnIOk),
                    2000
            );
        }

        if (Global.capabilitiesMethods.exists(Global.driver, By.xpath(creatFrameList))) {
            Global.capabilitiesMethods.scrollToElement(
                    Global.driver,
                    By.xpath(creatFrameList)
            );
            for (int i = 0; i < 3; i++) {
                Global.capabilitiesMethods.click(
                        Global.driver,
                        By.xpath(creatFrameList),
                        1000
                );
                if (Global.capabilitiesMethods.isVisible(
                        Global.driver,
                        By.xpath(nameFrame))) {
                    i = 3;
                }
            }

        }

        // preenche o nome do quadro
        Global.capabilitiesMethods.sendKeys(
                Global.driver,
                By.xpath(nameFrame),
                novoQuadro
        );

        // cria o quadro
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(btnCreatFrame),
                1000
        );
    }

    public void acessarQuadro(String nomeQuadro) {
        // clica no link para acessar o quadro
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath("//div[contains(@title,'" + nomeQuadro + "')]"),
                1000
        );
    }

    public void criarLista(String novaLista) {

        // Aguarda até que o elemento exista
        for (int i = 0; i < 3; i++) {
            if (Global.capabilitiesMethods.exists(Global.driver,
                    By.xpath(board))) {
                i = 3;
            }
        }

        // Recolhe a aba Área de Trabalho
        if (Global.capabilitiesMethods.isDisplayed(Global.driver,
                By.xpath(btnCollapseDesktop))) {

            Global.capabilitiesMethods.click(
                    Global.driver,
                    By.xpath(btnCollapseDesktop),
                    1000
            );
        }

        // Se existe portal aberto, pressiona ESC
        if (Global.capabilitiesMethods.isDisplayed(Global.driver,
                By.xpath(portal))) {

            Global.capabilitiesMethods.pressionarEsc(Global.driver);
        }

        // Verifica se a área para digitar o nome da lista está aberta
        if (!Global.capabilitiesMethods.isDisplayed(Global.driver,
                By.xpath(txtareaListName))) {

            Global.capabilitiesMethods.click(
                    Global.driver,
                    By.xpath(btnListComposer),
                    1000
            );
        }

        // Preenche o nome da lista
        Global.capabilitiesMethods.sendKeys(
                Global.driver,
                By.xpath(nameList),
                novaLista
        );

        // Salva a lista
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(btnSaveList),
                1000
        );

        // Cancela/fecha o criador de lista
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(closeNewList),
                1000
        );
    }

    public void criarCartao(String nomeLista, String novoCartao) {

        // Novo cartão
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath("//div[div[div/textarea[contains(text(),'" + nomeLista + "')]]]/div[@data-testid='list-footer']/button[contains(@data-testid,'list-add-card')]"),
                1000
        );

        // Nomeia o cartão
        Global.capabilitiesMethods.sendKeys(
                Global.driver,
                By.xpath(nameCard),
                novoCartao
        );

        // Salva
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(saveCard),
                1000
        );
    }

    public void criarTag(String nomeLista, String nomeCartao, String xPathCor) {

        if (xPathCor == null) {
            xPathCor = "";
        }

        // Abre o cartão
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath("//*[div[div/textarea[contains(text(),'" + nomeLista + "')]]]//a[@data-testid='card-name' and text()='" + nomeCartao + "']"),
                1000
        );
        Global.capabilitiesMethods.waitForPageLoad(Global.driver);

        // Seleciona o menu tag
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(menuTag),
                1000
        );

        // Botão nova etiqueta
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(btnNewTag),
                3000
        );
        Global.capabilitiesMethods.waitForPageLoad(Global.driver);

        // Se necessário, rolar até a cor
        if (!Global.capabilitiesMethods.isVisible(Global.driver, By.xpath(xPathCor))) {
            Global.capabilitiesMethods.scrollToElement(Global.driver, By.xpath(xPathCor));
        }

        // Escolhe a cor
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(xPathCor),
                1000
        );

        if (!Global.capabilitiesMethods.isVisible(Global.driver, By.xpath(btnCreat))) {
            Global.capabilitiesMethods.scrollToElement(Global.driver, By.xpath(btnCreat));
        }

        // Botão criar
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(btnCreat),
                1000
        );


        if (!Global.capabilitiesMethods.isVisible(Global.driver, By.xpath(btnCloseTag))) {
            Global.capabilitiesMethods.scrollToElement(Global.driver, By.xpath(btnCloseTag));
        }

        // Fecha a edição da etiqueta
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(btnCloseTag),
                1000
        );

        if (!Global.capabilitiesMethods.isVisible(Global.driver, By.xpath(btnCloseCard))) {
            Global.capabilitiesMethods.scrollToElement(Global.driver, By.xpath(btnCloseCard));
        }

        // Fecha a edição do cartão
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(btnCloseCard),
                1000
        );
    }

    public void removerTag(String nomeLista, String nomeCartao) {

        // abre o cartão
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath("//*[div[div/textarea[contains(text(),'" + nomeLista + "')]]]//a[@data-testid='card-name' and text()='" + nomeCartao + "']"),
                1000
        );

        // seleciona o menu tag
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(addTag),
                1000
        );


        if (!Global.capabilitiesMethods.isVisible(Global.driver, By.xpath(tagSelected))) {
            Global.capabilitiesMethods.scrollToElement(Global.driver, By.xpath(tagSelected));
        }

        // desmarca a tag
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(tagSelected),
                1000
        );

        // fecha a edição da etiqueta
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(btnCloseTag),
                1000
        );

        // fecha a edição do cartão
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(btnCloseCard),
                1000
        );
    }

    public void excluirCartao(String nomeLista, String nomeCartao) {

        // abre o cartão
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath("//*[div[div/textarea[contains(text(),'" + nomeLista + "')]]]//a[@data-testid='card-name' and text()='" + nomeCartao + "']"),
                1000
        );
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(openActions),
                1000
        );

        // rola até o menu arquivar
        if (!Global.capabilitiesMethods.isVisible(Global.driver, By.xpath(btnMenuArquive))) {
            Global.capabilitiesMethods.waitForPageLoad(Global.driver);
            Global.capabilitiesMethods.scrollToElement(Global.driver, By.xpath(btnMenuArquive));
        }

        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(btnMenuArquive),
                1000
        );

        // excluir
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(exclude),
                1000
        );

        // confirma exclusão
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(confirmExclude),
                1000
        );
    }

    public void excluirLista(String nomeLista) {

        // abre a lista
        Global.capabilitiesMethods.tentarClicarElemento(
                Global.driver, By.xpath(
                        "//div[div/textarea[contains(text(),'" + nomeLista + "')]]//button[@data-testid='list-edit-menu-button']"), 1000);

        // seleciona o menu arquivar
        if (!Global.capabilitiesMethods.isVisible(Global.driver,
                By.xpath(btnArquiveList))) {

            Global.capabilitiesMethods.scrollToElement(
                    Global.driver,
                    By.xpath(btnArquiveList)
            );
        }

        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(btnArquiveList),
                1000
        );

        // abre o menu
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(showMenu),
                1000
        );

        // abre os itens arquivados
        if (!Global.capabilitiesMethods.isVisible(Global.driver,
                By.xpath(btnItensArquiveted))) {

            Global.capabilitiesMethods.scrollToElement(
                    Global.driver,
                    By.xpath(btnItensArquiveted));
        }
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(btnItensArquiveted), 1000);


        // botão alternar para listas
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(btnAlternList),
                1000
        );

        // botão excluir lista
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath("//*[span[contains(text(), '" + nomeLista + "')]]//button//span[contains(@data-testid,'TrashIcon')]"),
                1000
        );

        // confirma exclusão
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(confirmExcludeList),
                1000
        );

        // fechar
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(btnCloseExcludeList),
                1000
        );
    }

    public void excluirQuadro() {

        // Aguarda a página carregar (se necessário)
        // Global.capabilitiesMethods.waitForPageLoad(Global.driver);

        if (Global.capabilitiesMethods.isVisible(
                Global.driver,
                By.xpath(btnShowMenu))) {

            // Abre o menu
            Global.capabilitiesMethods.click(
                    Global.driver,
                    By.xpath(btnShowMenu),
                    1000
            );
        }

        // Seleciona "Fechar quadro"
        if (Global.capabilitiesMethods.exists(
                Global.driver,
                By.xpath(btnCloseFrame))) {

            if (!Global.capabilitiesMethods.isVisible(
                    Global.driver,
                    By.xpath(btnCloseFrame))) {

                Global.capabilitiesMethods.scrollToElement(
                        Global.driver,
                        By.xpath(btnCloseFrame)
                );
            }

            Global.capabilitiesMethods.wait(2000);

            Global.capabilitiesMethods.click(
                    Global.driver,
                    By.xpath(btnCloseFrame),
                    2000
            );
        }
        // Seleciona fechamento do quadro via ícone "Remove"
        else if (Global.capabilitiesMethods.exists(
                Global.driver,
                By.xpath(removeIcon))) {

            if (!Global.capabilitiesMethods.isVisible(
                    Global.driver,
                    By.xpath(removeIcon))) {

                Global.capabilitiesMethods.scrollToElement(
                        Global.driver,
                        By.xpath(removeIcon)
                );
            }

            Global.capabilitiesMethods.wait(2000);

            Global.capabilitiesMethods.click(
                    Global.driver,
                    By.xpath(removeIcon),
                    2000
            );
        }

        Global.capabilitiesMethods.wait(2000);

        // Confirmação 1
        if (!Global.capabilitiesMethods.isVisible(
                Global.driver,
                By.xpath(closeBoardConfirmOne))) {

            Global.capabilitiesMethods.scrollToElement(
                    Global.driver,
                    By.xpath(closeBoardConfirmOne)
            );
        }

        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(closeBoardConfirmOne),
                2000
        );

        // Reabre o menu se necessário
        if (Global.capabilitiesMethods.isVisible(
                Global.driver,
                By.xpath(btnShowMenu))) {

            Global.capabilitiesMethods.click(
                    Global.driver,
                    By.xpath(btnShowMenu),
                    2000
            );
        }

        // Confirmação 2
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(closeBoardDelete),
                2000
        );

        // Excluir definitivamente
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(closeBoardDeleteExclude),
                2000
        );
    }

    public void logout() {

        // Verifica se o menu já está visível
        if (!Global.capabilitiesMethods.isVisible(
                Global.driver,
                By.xpath(headMember))) {

            // Abre o menu
            Global.capabilitiesMethods.click(
                    Global.driver,
                    By.xpath(btnOpenHeaderMemberMenu),
                    2000
            );
        }
        Global.capabilitiesMethods.waitForPageLoad(Global.driver);


        if (!Global.capabilitiesMethods.isVisible(Global.driver, By.xpath(btnLogout))) {
            Global.capabilitiesMethods.scrollToElement(Global.driver, By.xpath(btnLogout));
        }

        // Primeiro clique de logout
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(btnLogout),
                1000
        );

        // Segundo clique de logout (confirmação)
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(btnSecondLogout),
                2000
        );
    }

    public void loopCriacao() {

        Global.trello.criarQuadro("testeLoop"); // criarQuadro

        List<String> cores = List.of(
                "color-tile-red",
                "color-tile-blue_light",
                "color-tile-green_light"
        );

        int contCartao = 1;

        for (int i = 1; i < 4; i++) {

            Global.trello.criarLista("Lista " + i); // criarLista

            // cartões com cores diferentes por lista
            for (String cor : cores) {
                Global.trello.criarCartao("Lista " + i, "Cartão " + contCartao);
                Global.trello.criarTag(
                        "Lista " + i,
                        "Cartão " + contCartao,
                        "//button[@data-testid='" + cor + "']"
                );

                contCartao++;
            }

            contCartao = 1;
        }
    }

    public void loopCriacaoRandom() {

        Global.trello.criarQuadro("testeTrelloRandom"); // criarQuadro

        int contCartao = 1;

        for (int i = 1; i < 4; i++) {

            Global.trello.criarLista("Lista " + i); // criarLista

            while (contCartao < 4) {

                String cor;

                Global.trello.criarCartao("Lista " + i, "Cartão " + contCartao); // criarCartao

                // gera cor aleatória e atribui a variável cor
                cor = geraCorTagRandom();

                Global.trello.criarTag(
                        "Lista " + i,
                        "Cartão " + contCartao,
                        "//button[@data-testid='" + cor + "']"
                ); // criarTag

                contCartao++;
            }

            contCartao = 1;
        }

        // Assert.assertTrue(Global.capabilitiesMethods.exists(), "Logo não encontrado");
    }

    public void loopExclusao() {

        // Global.trello.acessarQuadro("testeLoopRandom");

        for (int i = 3; i > 0; i--) {

            for (int j = 3; j > 0; j--) {
                Global.trello.removerTag("Lista " + i, "Cartão " + j); // excluirTag
            }

            for (int k = 3; k > 0; k--) {
                Global.trello.excluirCartao("Lista " + i, "Cartão " + k); // excluirCartao
            }

            Global.trello.excluirLista("Lista " + i); // excluirLista
        }

        Global.trello.excluirQuadro(); // excluirQuadro
    }

    public String geraCorTagRandom() {
        List<String> listaCor = Arrays.asList(
                "color-tile-green_light",
                "color-tile-yellow_dark",
                "color-tile-orange",
                "color-tile-red",
                "color-tile-purple",
                "color-tile-purple",
                "color-tile-lime_dark",
                "color-tile-pink_dark",
                "color-tile-black_light",
                "color-tile-sky"
        );

        Random rand = new Random(System.currentTimeMillis());
        String cor = listaCor.get(rand.nextInt(listaCor.size()));
        return cor;
    }

    public void fecharQuadros(String xPath) {

        // Aguarda e clica no ícone do quadro (BoardIcon)
        Global.capabilitiesMethods.click(
                Global.driver,
                By.xpath(boardIcon),
                2000
        );

        // Fecha preferências de cookies (se aparecer)
        if (Global.capabilitiesMethods.exists(
                Global.driver,
                By.xpath(preferences)
        )) {

            Global.capabilitiesMethods.click(
                    Global.driver,
                    By.xpath(preferences),
                    2000
            );
        }

        int quantidade = Global.capabilitiesMethods.countElements(Global.driver, By.xpath(xPath));
        quantidade = quantidade - 1;

        for (int i = quantidade; i >= 1; i--) {

            Global.capabilitiesMethods.wait(2000);

            String elementoXPath = xPath + "[" + i + "]";

            if (!Global.capabilitiesMethods.isVisible(Global.driver, By.xpath(elementoXPath))) {

                for (int j = 0; j < 3; j++) {

                    Global.capabilitiesMethods.scrollToElement(Global.driver, By.xpath(elementoXPath));

                    if (Global.capabilitiesMethods.isVisible(Global.driver, By.xpath(elementoXPath))) {

                        Global.capabilitiesMethods.click(
                                Global.driver,
                                By.xpath(elementoXPath),
                                2000
                        );
                        j = 3; // força saída do loop interno
                    }
                }

            } else {

                Global.capabilitiesMethods.click(
                        Global.driver,
                        By.xpath(elementoXPath),
                        2000
                );
            }

            // Exclui o quadro
            Global.trello.excluirQuadro();
        }
    }


}

