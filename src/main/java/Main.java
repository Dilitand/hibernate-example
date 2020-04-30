import config.MyConfig;
import dao.DaoSpringIpl;
import models.Account;
import models.Accountop;
import models.Personx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        DaoSpringIpl springIpl = context.getBean("daospring", DaoSpringIpl.class);

        Personx personx = makePersonx();
        springIpl.save(personx);

        List list = springIpl.getListFromQuery("FROM Personx");
        System.out.println(list);
    }

    public static Personx makePersonx(){
        Personx person = new Personx("dimas");

        Account account = new Account("1000");
        Accountop accountop = new Accountop(1000.12D, new Date());

        //accountop.setAccount(account);
        account.addAccountOp(accountop);
        //account.setPerson(person);
        person.addAcc(account);

        return person;
    }
}
