package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("UAZ", 3151)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("LADA", 2110)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("GAZ", 24)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("BMW", 5)));
      userService.add(new User("User5", "Lastname5", "user5@mail.ru", new Car("LADA", 2101)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car model = " + user.getCar().getModel());
         System.out.println("Car serial = " + user.getCar().getSeries());
         System.out.println();
      }

      System.out.println("------------------------------------------------");
      User ladaDriver = userService.getUserCar("LADA", 2110);
      System.out.println(ladaDriver);

      context.close();
   }
}
