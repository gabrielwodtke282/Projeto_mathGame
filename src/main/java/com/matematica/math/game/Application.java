package com.matematica.math.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application {

    static Scanner SC =  new Scanner(System.in);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

        while (true) {
            System.out.println("=== MENU PRINCIPAL ===");
            SC.next();
        }
	}
}
