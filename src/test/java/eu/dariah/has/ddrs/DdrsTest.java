package eu.dariah.has.ddrs;

import org.junit.BeforeClass;

public class DdrsTest {
    @BeforeClass
    public static void addEnvironmentVariables() {
        System.setProperty("DDRS_PASSWORD", "1111");
        System.setProperty("ES_URL", "1111");
        System.setProperty("ES_USERNAME", "1111");
        System.setProperty("ES_PASSWORD", "1111");
        System.setProperty("CAPTCHA_SECRET", "1111");
        System.setProperty("CAPTCHA_SITE", "1111");
    }
}
