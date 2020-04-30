package config;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

//https://www.baeldung.com/hibernate-4-spring
//http://samolisov.blogspot.com/2009/06/hibernate-spring.html

@Configuration
@ComponentScan("dao")
public class MyConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource basicDataSource = new DriverManagerDataSource();
        basicDataSource.setDriverClassName("org.h2.Driver");
        basicDataSource.setUrl("jdbc:h2:~/test2");
        basicDataSource.setUsername("sa");
        basicDataSource.setPassword("");

        return basicDataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
        final LocalSessionFactoryBean factoryBean =
                new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("models");

        final Properties properties = new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.hbm2ddl","validate");
        factoryBean.setHibernateProperties(properties);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(DataSource dataSource, SessionFactory sessionFactory){
        final HibernateTransactionManager tr = new HibernateTransactionManager();
        tr.setDataSource(dataSource);
        tr.setSessionFactory(sessionFactory);
        return tr;
    }
}
