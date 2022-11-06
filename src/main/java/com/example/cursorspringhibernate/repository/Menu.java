package com.example.cursorspringhibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class Menu extends RepositoryBase{

    @Autowired
    private QueryRepository queryRepository;

    @Autowired
    DataHandler dataHandler;
    public void run() throws NullPointerException{

        System.out.println("What would you like to do? Enter the parameter number." );
        System.out.println("1.Search users; 2.Create user; 3.Update User data; 4.All users; 0.Exit" );

        int searchParameter = scanner.nextInt();

        if (searchParameter<0||searchParameter>4)
        {
            System.out.println("You entered the wrong value or parameter type ");
            run();
        }
        else {

            switch (searchParameter) {
                case 1 -> {
                    dataHandler.searchCases();
                    run();
                }
                case 2 -> {
                    dataHandler.createUserCases();
                    run();
                }
                case 3 -> {
                    dataHandler.updateUserCases();
                    run();
                }
                case 4 -> {
                    queryRepository.getAllUsers();
                    run();
                }
                case 0 -> System.out.println("Exit");
                default -> {
                    System.out.println("You entered the wrong value!");
                    run();
                }
            }
        }
        scanner.close();

    }

}
