package service;

import com.domain.Advertisement;
import com.domain.Author;
import com.repository.AdvertisementRepository;
import com.repository.AuthorRepository;
import com.service.CrudService;
import config.TestConfigApp;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfigApp.class)
@WebAppConfiguration
@Sql(scripts = {"classpath:scripts/truncate_advertisement_table.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class AdvertisementServiceTest {
    @Autowired
    AdvertisementRepository repository;

    @Autowired
    CrudService<Advertisement> service;
}
