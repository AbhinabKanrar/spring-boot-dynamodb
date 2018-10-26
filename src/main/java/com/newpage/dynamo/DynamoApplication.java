package com.newpage.dynamo;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author abhinab
 *
 */
@SpringBootApplication
@EnableDynamoDBRepositories(basePackages = "com.newpage.dynamo.repository")
public class DynamoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DynamoApplication.class, args);
  }

}
