package com.example.cursorspringhibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Scanner;

public abstract class RepositoryBase {
    @PersistenceContext
    protected EntityManager manager ;

    protected Scanner scanner = new Scanner(System.in);

}
