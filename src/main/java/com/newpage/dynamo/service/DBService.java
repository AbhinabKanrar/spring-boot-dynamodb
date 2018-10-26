/**
 * 
 */
package com.newpage.dynamo.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.newpage.dynamo.entity.AppHealth;
import com.newpage.dynamo.repository.AppHealthRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author abhinab
 *
 */
@Component
@Slf4j
public class DBService {

  @Autowired
  private AppHealthRepository appHealthRepository;

  public AppHealth saveOrUpdate(AppHealth appHealth) {
    try {
      return appHealthRepository.save(appHealth);
    } catch (Exception e) {
      log.error("Unable to save the record : {}", appHealth);
      throw e;
    }
  }

  public void delete(String id) {
    try {
      appHealthRepository.deleteById(id);
    } catch (Exception e) {
      log.error("Unable to delete the record : {}", id);
      throw e;
    }
  }

  public List<AppHealth> find(Date startDate, Date endDate) {
    try {
      return appHealthRepository.findByTimeStampBetween(startDate, endDate);
    } catch (Exception e) {
      log.error("Unable to find the records : {} -> {}", startDate, endDate);
      throw e;
    }
  }

}
