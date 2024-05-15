package com.example.demo;



import com.example.demo.model.Episodio;
import com.example.demo.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class AluraSpringBootApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AluraSpringBootApplication.class, args);
	}

    @Override                   //metodoMain
    public void run(String... args) throws Exception {
        Principal menu = new Principal();
        menu.exibeMenu();


         }



    }

