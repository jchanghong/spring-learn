package com.example.springlearn.data;

import org.springframework.context.annotation.Configuration;
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
