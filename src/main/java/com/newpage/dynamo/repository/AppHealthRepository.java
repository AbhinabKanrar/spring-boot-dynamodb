/**
 * 
 */
package com.newpage.dynamo.repository;

import java.util.Date;
import java.util.List;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import com.newpage.dynamo.entity.AppHealth;

/**
 * @author abhinab
 *
 */
@EnableScan
public interface AppHealthRepository extends CrudRepository<AppHealth, String> {

  List<AppHealth> findByTimeStampBetween(Date startDate, Date endDate);

}
