package service;

import com.domain.Rubric;
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
import util.RubricUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfigApp.class)
@WebAppConfiguration
@Sql(scripts = {"classpath:scripts/truncate_rubric_table.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class RubricServiceTest {

    @Autowired
    RubricRepository repository;

    @Autowired
    CrudService<Rubric> service;

    @Test
    public void shouldSaveRubricObject() {
        Rubric rubric = RubricUtil.getRubric();

        service.save(rubric);

        Rubric rubric1 = repository.findById(1).get();

        Assert.assertEquals(rubric, rubric1);

    }

    @Test
    public void shouldUpdateRubricObject() {
        Rubric rubric = RubricUtil.getRubric();

        repository.save(rubric);

        Rubric rubric1 = repository.findById(1).get();

        rubric1.setName("Phones");

        service.update(rubric1);

        Rubric rubric2 = repository.findById(1).get();

        rubric1.setVersion(1);

        Assert.assertEquals(rubric1, rubric2);

    }
}
