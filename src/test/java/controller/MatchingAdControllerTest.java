package controller;

import com.controller.AuthorController;
import com.controller.MadController;
import com.domain.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.handler.HandlerException;
import com.service.CrudService;
import config.TestConfigApp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import util.AdvertisementUtil;
import util.MatchingAdUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfigApp.class)
@WebAppConfiguration
public class MatchingAdControllerTest {
    public static final ObjectMapper MAPPER = new ObjectMapper();

    @Mock
    CrudService<MatchingAd> service;

    @InjectMocks
    private MadController controller;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .setControllerAdvice(new HandlerException())
                .build();
    }

    @Test
    public void shouldSaveMadObject() throws Exception {
        Mockito.doNothing().when(service).save(ArgumentMatchers.any(MatchingAd.class));

        MatchingAd matchingAd = MatchingAdUtil.getMatchingAd();

        String json = MAPPER.writeValueAsString(matchingAd);

        mockMvc.perform(post("/mads/mad")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void shouldUpdateMadObject() throws Exception {
        Mockito.doNothing().when(service).save(ArgumentMatchers.any(MatchingAd.class));

        MatchingAd matchingAd = MatchingAdUtil.getMatchingAd();
        
        String json = MAPPER.writeValueAsString(matchingAd);

        mockMvc.perform(put("/mads/mad")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));
    }

}
