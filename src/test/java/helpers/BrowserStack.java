package helpers;

import config.BrowserStackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class BrowserStack {
    public static String videoUrl(String sessionId) {
        BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class);

        String login = config.name();
        String pass = config.key();
        String session = config.session();

        return given()
                .auth().basic(login, pass)
                .when()
                .get(session + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");
    }
}