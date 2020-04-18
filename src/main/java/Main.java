import springPackage.config.RoleStorage;
import springPackage.models.Personx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");

        RoleStorage storage = applicationContext.getBean(RoleStorage.class);
        storage.add(new Personx("nanasdn"));

    }
}
