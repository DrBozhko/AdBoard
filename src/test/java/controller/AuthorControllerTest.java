package controller;


import com.controller.AuthorController;
import com.domain.Author;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.handler.HandlerException;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import util.AuthorUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfigApp.class)
@WebAppConfiguration
public class AuthorControllerTest {
    public static final ObjectMapper MAPPER = new ObjectMapper();

    @Mock
    CrudService<Author> service;

    @InjectMocks
    private AuthorController controller;

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
        Mockito.doNothing().when(service).save(ArgumentMatchers.any(Author.class));

        Author author = AuthorUtil.getAuthor();

        String json = MAPPER.writeValueAsString(author);

        mockMvc.perform(post("/authors/author")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void shouldUpdateAuthorObject() throws Exception {
        Mockito.doNothing().when(service).save(ArgumentMatchers.any(Author.class));

        Author author = AuthorUtil.getAuthor();

        String json = MAPPER.writeValueAsString(author);

        mockMvc.perform(post("/authors/author")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void shouldGetAuthorObject() throws Exception {
        Author author = AuthorUtil.getAuthor();
        author.setId(5);
        author.setVersion(2);

        Mockito.when(service.findById(ArgumentMatchers.anyInt())).thenReturn(author);

        mockMvc.perform(MockMvcRequestBuilders.get("/authors/author/{id}", 11))
                .andDo(print())
                .andExpect(jsonPath("id").value(5))
                .andExpect(jsonPath("version").value(2))
                .andExpect(jsonPath("name").value("Johny"))
                .andExpect(status().is(200));
    }

    @Test
    public void shouldDeleteAuthorObject() throws Exception {
        Mockito.doNothing().when(service).save(ArgumentMatchers.any(Author.class));

        mockMvc.perform(MockMvcRequestBuilders.delete("/authors/author/{id}", 11))
                .andDo(print())
                .andExpect(status().is(200));
    }
}
