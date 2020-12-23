package eu.dariah.has.ddrs.service;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * From: https://github.com/sanaulla123/samples/blob/master/recaptcha-demo/src/main/java/info/sanaulla/recaptchademo/RecaptchaService.java
 */

@Service
public class RecaptchaService {

    private static final Logger LOG = LogManager.getLogger(RecaptchaService.class);

    @Value("${recaptcha.secret}")
    private String recaptchaSecret;

    private static final String GOOGLE_RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

    private final RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public RecaptchaService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public String verifyRecaptcha(String ip, String recaptchaResponse){
        Map<String, String> body = new HashMap<>();
        body.put("secret", recaptchaSecret);
        body.put("response", recaptchaResponse);
        body.put("remoteip", ip);
        LOG.debug("Request body for recaptcha: " + body.toString());
        ResponseEntity<Map> recaptchaResponseEntity =
                restTemplateBuilder.build()
                        .postForEntity(GOOGLE_RECAPTCHA_VERIFY_URL+
                                        "?secret={secret}&response={response}&remoteip={remoteip}",
                                body, Map.class, body);
        LOG.debug("Response from recaptcha: " + recaptchaResponseEntity.toString());
        Map<String, Object> responseBody = recaptchaResponseEntity.getBody();
        boolean recaptchaSucess = (Boolean)responseBody.get("success");
        if (!recaptchaSucess) {
            List<String> errorCodes = (List)responseBody.get("error-codes");
            return errorCodes.stream().collect(Collectors.joining(", "));
        } else {
            return StringUtils.EMPTY;
        }
    }
}