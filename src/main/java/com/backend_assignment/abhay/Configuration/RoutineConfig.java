//package com.backend_assignment.abhay.Configuration;
//
//import com.backend_assignment.abhay.Entity.Routine;
//import com.backend_assignment.abhay.Repository.RoutineRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Configuration
//public class RoutineConfig {
//    @Bean
//    CommandLineRunner commandLineRunnerRoutine(RoutineRepository repository) {
//        return args -> {
//            Routine routine1 = new Routine(
//                    200101L,
//                    LocalDate.of(2023, 5, 4),
//                    "10:00",
//                    "11:00",
//                    "LT-01",
//                    "Java",
//                    1L,
//                    1L
//
//
//
//            );
//            Routine routine2 = new Routine(
//
//                    200102L,
//                    LocalDate.of(2023, 5, 4),
//                    "11:00",
//                    "12:00",
//                    "LT-01",
//                    "Python",
//                    1L,
//                    2L
//            );
//            repository.saveAll(
//                    List.of(routine1, routine2));
//        };
//
//    }
//}
