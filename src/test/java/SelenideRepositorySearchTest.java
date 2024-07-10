import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearchTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
    }

    @Test
    void  shouldJUnitCode(){
        open("/selenide/selenide");
        $("#repository-container-header").$("#wiki-tab").click();
        $("#wiki-wrapper").$(byText("Soft assertions")).click();
        //$$(".markdown-heading").findBy(text("JUnit5")); // в начале сделала таким способом, потом подсматрела в чате телеги и переделала
        $("a#user-content-3-using-junit5-extend-test-class")
                .shouldHave(href("#3-using-junit5-extend-test-class"))
                .scrollIntoView(true);
    }
}
