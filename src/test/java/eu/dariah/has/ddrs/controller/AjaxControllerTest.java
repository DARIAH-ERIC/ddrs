package eu.dariah.has.ddrs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.dariah.has.ddrs.DdrsTest;
import eu.dariah.has.ddrs.model.SearchObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by yoann on 15.05.17.
 * The AJAX controller test class, in order to test retrieving of results into a fragment HTML page.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AjaxControllerTest extends DdrsTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * Test a real result coming from ES via our AJAX controller
     * @throws Exception Whenever something in the test went wrong
     */
    @Test
    public void refreshResultTest() throws Exception {
        SearchObject searchObject = new SearchObject();
        Map<String, String> searchParameters = new HashMap<>(2);
        searchParameters.put("institutions.country.raw", "FRA");
        searchParameters.put("repositoryLanguages.text.raw", "deu");
        searchObject.setSearchParameters(searchParameters);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(searchObject);
        mockMvc.perform(
                post("/refreshResults")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
                        .sessionAttr("searchObject", searchObject))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", "text/html;charset=UTF-8"))
                .andExpect(content().string(containsString("There are")));
    }

    /**
     * Test a real empty result coming from ES via our AJAX controller (empty because we use inexistant parameters)
     * @throws Exception Whenever something in the test went wrong
     */
    @Test
    public void refreshResultEmptyTest() throws Exception {
        SearchObject searchObject = new SearchObject();
        Map<String, String> searchParameters = new HashMap<>(2);
        searchParameters.put("institutions.country.raw", "FRAGGGGG");
        searchParameters.put("repositoryLanguages.text.raw", "deuGGGGG");
        searchObject.setSearchParameters(searchParameters);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(searchObject);
        mockMvc.perform(
                post("/refreshResults")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
                        .sessionAttr("searchObject", searchObject))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", "text/html;charset=UTF-8"))
                .andExpect(content().string(containsString("There are no")));
    }
}
