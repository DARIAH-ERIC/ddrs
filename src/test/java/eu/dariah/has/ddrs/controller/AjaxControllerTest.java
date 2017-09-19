package eu.dariah.has.ddrs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.dariah.has.ddrs.model.SearchObject;
import eu.dariah.has.ddrs.service.Re3dataQueryList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by yoannmoranville on 15/05/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AjaxControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

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

}
