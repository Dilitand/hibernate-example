import springPackage.config.RoleStorage;
import springPackage.models.Personx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

public class Main {


    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        Personx personx = applicationContext.getBean(Personx.class);
//        personx.setName("test");
//        System.out.println(personx.getName());
//
//        RoleStorage storage = applicationContext.getBean(RoleStorage.class);
//        //System.out.println(storage.toString());
//        storage.add(new Personx("nanasdn"));

    }

    public static void test() throws SQLException {
        Connection connection = DriverManager.getConnection("");
        PreparedStatement statement = connection.prepareStatement("?");
        statement.setInt(1,1);
    }


}
