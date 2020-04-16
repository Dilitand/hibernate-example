package config;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

//https://www.baeldung.com/hibernate-4-spring
//http://samolisov.blogspot.com/2009/06/hibernate-spring.html

@Configuration
@EnableTransactionManagement
public class MyConfig {

    @Bean
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.h2.Driver");
        basicDataSource.setUrl("jdbc:h2:~/test2");
        basicDataSource.setUsername("sa");
        basicDataSource.setPassword("");

        return basicDataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        Properties properties = new Properties();
        properties.setProperty()

        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan(
                new String[] { "org.baeldung.spring.persistence.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto",
                        env.getProperty("hibernate.hbm2ddl.auto"));
                setProperty("hibernate.dialect",
                        env.getProperty("hibernate.dialect"));
                setProperty("hibernate.globally_quoted_identifiers",
                        "true");
            }
        };
}
