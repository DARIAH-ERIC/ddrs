package eu.dariah.has.ddrs.service;

import eu.dariah.has.ddrs.DdrsTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ShibbolethAuthenticationProviderTest extends DdrsTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
    }

    @Test
    public void adminEndpoint_withoutAdminCredentials_returnsRedirect() throws Exception {
        System.out.println(mockMvc.perform(get("/admin/")).andReturn().getResponse().getContentAsString());
        mockMvc.perform(get("/admin/")).andExpect(status().is3xxRedirection());
    }

    @Test
    public void adminEndpoint_withValidAdminCredentials_returnsOk() throws Exception {
        mockMvc.perform(get("/admin/").requestAttr("unique-id", "myUniqueId"))
                .andExpect(status().isOk());
    }

    @Test
    public void adminEndpoint_withInvalidBackendAdminCredentials_returnsRedirect() throws Exception {
        mockMvc.perform(get("/admin/").requestAttr("not_unique-id", "myWhatever"))
                .andExpect(status().is3xxRedirection());
    }
}
