package PageFactory;

import org.openqa.selenium.WebDriver;

public class BO {
    private WebDriver driver;
    private LoginPO loginPO;
    private HomePO homePO;
    private AskPO askPO;
    private UserSearchPO userSearchPO;

    private ChangeProfilePO changeProfilePO;


    public BO(WebDriver driver) {
        this.driver = driver;
        this.homePO = new HomePO(driver);
        this.loginPO = new LoginPO(driver);
        this.askPO = new AskPO(driver);
        this.userSearchPO = new UserSearchPO(driver);
        this.changeProfilePO = new ChangeProfilePO(driver);
    }

    public BO goHomePage() {
        homePO.getHomePage();
        return this;
    }

    public void pressJoinCommunity() {
        homePO.pressCommunity();
    }

    public BO login(String email, String password) {
        homePO.pressLogin();
        loginPO.fillEmail(email);
        loginPO.fillPassword(password);
        loginPO.clickLogin();
        return this;
    }

    public boolean verifyLogin() {
        return loginPO.verifyLogin();
    }

    public BO pressAskQuestion() {
        homePO.pressAsk();
        askPO.fillTitle("Want to add target=_blank to a href in php1");
        askPO.fillTags("php mysql href");
        askPO.fillArea("I want to add target=_blank to this php-code:\n" +
                "\n" +
                "Click me\n" +
                "\n" +
                "I have tried almost all possible syntax, but they all fails. The code it self works.");
        askPO.clickReview();
        askPO.clickPost();
        return this;
    }

    public BO pressTagSearch() {
        homePO.pressAsk();
        askPO.fillTitle("Want to add target=_blank to a href in php1");
        askPO.fillTags("php mysql href");
        askPO.fillArea("I want to add target=_blank to this php-code:\n" +
                "\n" +
                "Click me\n" +
                "\n" +
                "I have tried almost all possible syntax, but they all fails. The code it self works.");
        askPO.clickReview();
        askPO.clickPost();
        return this;
    }

    public BO pressUserSearch() {
        homePO.pressUser();
        userSearchPO.fillUser("Steave Jobs");
        userSearchPO.clickJobs();
        return this;
    }

    public BO pressProfile() {
        homePO.pressProfile();
        changeProfilePO.clickEdit();
        changeProfilePO.fillName("SteaveJobs");
        changeProfilePO.fillLocation("USA1");
        changeProfilePO.fillTitle("TEst1");
        changeProfilePO.fillArea("!!!!!!!Test!!!!!!!");
        changeProfilePO.fillGit("GitTest");
        changeProfilePO.fillRealName("Steave Jobs");
        changeProfilePO.clickSave();
        return this;
    }
}
