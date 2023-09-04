package com.utn.controllerConRepo;


import com.utn.controllerConRepo.entidades.Persona;
import com.utn.controllerConRepo.repositorios.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ControllerConRepoApplication {

	@Autowired
	PersonaRepositorio personaRepository;
	public static void main(String[] args) {
		SpringApplication.run(ControllerConRepoApplication.class, args);

		System.out.println(" Probando el el controlador de Persona y funcionando");
	}


	@Bean
	CommandLineRunner init(PersonaRepositorio personaRepository) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");
			Persona persona = Persona.builder()
					.nombre("Juan")
					.apellido("Pérez")
					.edad(30)
					.build();


			// Guardar el objeto Persona en la base de datos
//        PersonaRepository personaRepository = context.getBean(PersonaRepository.class);
			personaRepository.save(persona);

			// Recuperar el objeto Persona desde la base de datos
			Persona personaRecuperada = personaRepository.findById(persona.getId()).orElse(null);
			if (personaRecuperada != null) {
				System.out.println("Nombre: " + personaRecuperada.getNombre());
				System.out.println("Apellido: " + personaRecuperada.getApellido());
				System.out.println("Edad: " + personaRecuperada.getEdad());
			}

		};




	}


	}
