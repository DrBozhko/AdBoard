package controller;

import com.controller.AdvertisementController;
import com.controller.AuthorController;
import com.domain.Advertisement;
import com.domain.Author;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.handler.HandlerException;
import com.service.AdvertisementService;
import com.service.CrudService;
import config.TestConfigApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import util.AdvertisementUtil;
import util.AuthorUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfigApp.class)
@WebAppConfiguration
public class AdvertisementControllerTest {
    public static final ObjectMapper MAPPER = new ObjectMapper();

    @Mock
    AdvertisementService service;

    @InjectMocks
    private AdvertisementController controller;

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
    public void shouldSaveAuthorObject() throws Exception {
        Mockito.doNothing().when(service).save(ArgumentMatchers.any(Advertisement.class));

        Advertisement advertisement = AdvertisementUtil.getAdvertisement();

        String json = MAPPER.writeValueAsString(advertisement);

        mockMvc.perform(post("/advertisements/advertisement")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));
    }

    public void shouldUpdateAdvertisementObject() throws Exception {
        Mockito.doNothing().when(service).save(ArgumentMatchers.any(Advertisement.class));

        Advertisement advertisement = AdvertisementUtil.getAdvertisement();

        String json = MAPPER.writeValueAsString(advertisement);

        mockMvc.perform(post("/advertisements/advertisement")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));
    }


}
