package config;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

//https://www.baeldung.com/hibernate-4-spring
//http://samolisov.blogspot.com/2009/06/hibernate-spring.html

@Configuration
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
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource){
        final LocalSessionFactoryBean factoryBean =
                new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("models");
        return factoryBean;
    }
}
