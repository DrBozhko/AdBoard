package service;

import com.domain.Author;
import com.domain.Rubric;
import com.repository.AuthorRepository;
import com.repository.RubricRepository;
import com.service.CrudService;
import config.TestConfigApp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import util.AuthorUtil;
import util.RubricUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfigApp.class)
@WebAppConfiguration
@Sql(scripts = {"classpath:scripts/truncate_author_table.sql",
        "classpath:scripts/truncate_phone_table.sql",
        "classpath:scripts/truncate_mail_table.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class AuthorServiceTest {
    @Autowired
    AuthorRepository repository;

    @Autowired
    CrudService<Author> service;

    @Test
    public void shouldSaveAuthorObject() {
        Author author = AuthorUtil.getAuthor();

        service.save(author);

        Author author1 = repository.findById(1);

        Assert.assertEquals(author.getId(), author1.getId());
        Assert.assertEquals(author.getVersion(), author1.getVersion());
        Assert.assertEquals(author.getPhones().get(0), author1.getPhones().get(0));

    }

    @Test
    public void shouldUpdateRubricObject() {
        Author author = AuthorUtil.getAuthor();

        repository.save(author);

        Author author1 = repository.findById(1);

        author1.setName("NotJohny");

        service.update(author1);

        Author author2 = repository.findById(1);

        author1.setVersion(1);

        Assert.assertEquals(author1.getId(), author2.getId());
        Assert.assertEquals(author1.getVersion(), author2.getVersion());
        Assert.assertEquals(author1.getPhones().get(0), author2.getPhones().get(0));

    }
}
