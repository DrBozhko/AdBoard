package controller;

import com.controller.RubricController;
import com.domain.Rubric;
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
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import util.RubricUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfigApp.class)
@WebAppConfiguration
public class RubricControllerTest {
   public static final ObjectMapper MAPPER = new ObjectMapper();

    @Mock
    CrudService<Rubric> service;

    @InjectMocks
    private RubricController controller;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .setControllerAdvice(new HandlerException ())
                .build();
    }

    @Test
    public void shouldSaveRubricObject() throws Exception {
        Mockito.doNothing().when(service).save(ArgumentMatchers.any(Rubric.class));

        Rubric car = RubricUtil.getRubric();

        String json = MAPPER.writeValueAsString(car);

        mockMvc.perform(post("/rubrics/rubric")
        .content(json)
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().is(200));
    }

    @Test
    public void shouldUpdateRubricObject() throws Exception {
        Mockito.doNothing().when(service).save(ArgumentMatchers.any(Rubric.class));

        Rubric car = RubricUtil.getRubric();

        String json = MAPPER.writeValueAsString(car);

        mockMvc.perform(put("/rubrics/rubric")
        .content(json)
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().is(200));
    }

    @Test
    public void shouldGetRubricObject() throws Exception {

        Rubric car = RubricUtil.getRubric();
        car.setId(5);
        car.setVersion(8);


        Mockito.when(service.findById(ArgumentMatchers.anyInt())).thenReturn(car);


        mockMvc.perform(MockMvcRequestBuilders.get("/rubrics/rubric/{id}", 5))
        .andDo(print())
                .andExpect(jsonPath("id").value(5))
                .andExpect(jsonPath("version").value(8))
                .andExpect(jsonPath("name").value("Car"))
        .andExpect(status().is(200));
    }

    @Test
    public void shouldDeleteRubricObject() throws Exception {

        Mockito.doNothing().when(service).save(ArgumentMatchers.any(Rubric.class));

        mockMvc.perform(MockMvcRequestBuilders.delete("/rubrics/rubric/{id}", 5))
        .andDo(print())
        .andExpect(status().is(200));
    }


    @Test
    public void shouldSaveRubricObjectWithFail() throws Exception {
        Mockito.doNothing().when(service).save(ArgumentMatchers.any(Rubric.class));

        Rubric car = RubricUtil.getRubric();
        car.setName("C");

        String json = MAPPER.writeValueAsString(car);

        MvcResult result = mockMvc.perform(post("/rubrics/rubric")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotAcceptable())
                .andReturn();

        String content = result.getResponse().getContentAsString();

        Assert.assertTrue(content.contains("size must be between 2 and 20"));
    }
}
