package com.example.springlearn.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author : jiangchanghong
 * @version : 2019-11-22 09:07
 **/
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class JdbcTest {
  private final TransactionTemplate transactionTemplate;

  @Autowired
  JdbcTemplate jdbcTemplate;
  @Autowired
  SimpleJdbcInsert simpleJdbcInsert;

  @Bean
  public SimpleJdbcInsert simpleJdbcInsert(JdbcTemplate jdbcTemplate) {
   SimpleJdbcInsert simpleJdbcInsert1 = new SimpleJdbcInsert(jdbcTemplate);
    simpleJdbcInsert1.withTableName("t1");
    return simpleJdbcInsert1;
  }
  @PostConstruct
  public void init() {
    jdbcTemplate.execute("create table t1(id int,name varchar)");
    Map<String, Object> map = new HashMap<>();
    map.put("id", 1);
    map.put("name", "name1");
    simpleJdbcInsert.execute(map);
    List<Map<String, Object>> mapList = jdbcTemplate.queryForList("select * from t1");
    mapList.forEach(stringObjectMap -> System.out.println(stringObjectMap.toString()));
  }
  public JdbcTest(PlatformTransactionManager transactionManager) {
    this.transactionTemplate = new TransactionTemplate(transactionManager);

    // the transaction settings can be set here explicitly if so desired
    this.transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
    this.transactionTemplate.setTimeout(30); // 30 seconds
    // and so forth...
  }
  @Transactional
  public void tx() {
    System.out.println("start....");

    if ("ss".length() > 0) {
      throw new NullPointerException("null");
    }
    System.out.println("end....");
  }

}
