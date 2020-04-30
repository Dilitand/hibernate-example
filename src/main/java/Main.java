import config.MyConfig;
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

        System.out.println(dao.getListFromQuery("FROM Personx"));
    }

    public static void test() throws SQLException {
        Connection connection = DriverManager.getConnection("");
        PreparedStatement statement = connection.prepareStatement("?");
        statement.setInt(1,1);
    }


}
