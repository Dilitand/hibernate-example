import dao.Dao;
import models.Account;
import models.Accountop;
import models.Personx;

import java.sql.*;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
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

        /*
        Account account = new Account("1000");
        account.setPerson(person);
        person.addAcc(account);
        dao.update(person);
         */

        System.out.println(dao.getListFromQuery("FROM Personx"));

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
