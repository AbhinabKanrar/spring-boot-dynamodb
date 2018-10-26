package com.newpage.dynamo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.newpage.dynamo.entity.AppHealth;
import com.newpage.dynamo.service.DBService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DynamoApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
public class DynamoApplicationTests {

  AppHealth appHealth;

  @Autowired
  DBService dbService;

  @Before
  public void init() {
    appHealth = new AppHealth();
    appHealth.setApp("Mint-Cog");
    appHealth.setTimeStamp(new Date());
    appHealth.setSubjectId(10);
    appHealth.setSessionId(2);
    appHealth.setTaskVersion(7);
    appHealth.setTaskBlock("Calibration");
    appHealth.setTrailId(1);
    appHealth.setErrrorReason(null);
    appHealth.setJson(null);
    appHealth.setStatus(true);
  }

  @Test
  public void givenPojo_save_expectId() {
    appHealth = dbService.saveOrUpdate(appHealth);
    Assert.assertNotNull(appHealth.getId());
  }

  @Test
  public void givenPojo_saveAndDelete_expectNoId() {
    appHealth = dbService.saveOrUpdate(appHealth);
    dbService.delete(appHealth.getId());
  }

  @Test
  public void givenDateTimeRange_search_expect_result() {
    Assert.assertNotNull(dbService.find(
        Date.from(LocalDate.now().minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant()),
        Date.from(LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant())));;
  }

}
