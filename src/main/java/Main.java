import config.MyConfig;
import dao.Dao;
import models.Account;
import models.Accountop;
import models.Personx;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.h2.engine.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.sql.*;
import java.util.Arrays;
import java.util.Date;



public class Main {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        var session = context.getBean("sessionFactoryBean");
        System.out.println(session.toString());

        /*
        //spring
        Dao dao = new Dao();
        Personx person = new Personx("dimas");

        Account account = new Account("1000");
        Accountop accountop = new Accountop(1000.12D,new Date());

        //accountop.setAccount(account);
        account.addAccountOp(accountop);
        //account.setPerson(person);
        person.addAcc(account);

        dao.save(person);

        System.out.println(dao.getListFromQuery("FROM Personx"));
        */
        /*
        Account account = new Account("1000");
        account.setPerson(person);
        person.addAcc(account);
        dao.update(person);
         */


        /*
        UserService userService = new UserService();
        User user = new User("Masha",26);
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari", "red");
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);

         */
    }

    public static void test() throws SQLException {
        Connection connection = DriverManager.getConnection("");
        PreparedStatement statement = connection.prepareStatement("?");
        statement.setInt(1,1);
    }


}
