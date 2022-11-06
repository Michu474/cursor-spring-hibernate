package com.example.cursorspringhibernate.repository;

import com.example.cursorspringhibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class DataHandler extends RepositoryBase {

    @Autowired
    private QueryRepository queryRepository;

    public DataHandler(QueryRepository userRepositoryMenu) {
        this.queryRepository = userRepositoryMenu;
    }


    public void updateUserCases(){

        System.out.println("Enter id");
        Long id = scanner.nextLong();

        System.out.println("Enter first name");
        String firsName = scanner.next();

        System.out.println("Enter last name");
        String lastName = scanner.next();

        System.out.println("Enter age");
        int age = scanner.nextInt();
        User user = new User(id,firsName,lastName,age);

        queryRepository.updateUser(user);

    }
    public void createUserCases(){

        System.out.println("Enter first name");
        String firsName = scanner.next();

        System.out.println("Enter last name");
        String lastName = scanner.next();

        System.out.println("Enter age");
        int age = scanner.nextInt();
        User user = new User(firsName,lastName,age);

        queryRepository.createUser(user);

    }

    public void searchCases() throws NullPointerException{

        System.out.println("What would you like to search with? Enter the parameter number." );
        System.out.println("1.id; 2.first name; 3.last name; 4.age" );

        int searchParameter = scanner.nextInt();

        if (searchParameter<0||searchParameter>4) {
            System.out.println("You entered the wrong value or parameter type ");
        }
        else {
            switch (searchParameter) {
                case (1):
                    System.out.println("Enter id");
                    Long idValue = scanner.nextLong();
                    queryRepository.getUsersById(idValue);
                    break;
                case (2):
                    System.out.println("Enter first name");
                    String firstValue = scanner.next();
                    queryRepository.getUsersByFirstName(firstValue);
                    break;
                case (3):
                    System.out.println("Enter last name");
                    String lastValue = scanner.next();
                    queryRepository.getUsersByLastName(lastValue);
                    break;

                case (4):
                    System.out.println("Enter age");
                    int ageValue = scanner.nextInt();
                    queryRepository.getUsersByAge(ageValue);

                default: {
                    System.out.println("You entered the wrong value!");
                    break;
                }
            }
        }
    }



}