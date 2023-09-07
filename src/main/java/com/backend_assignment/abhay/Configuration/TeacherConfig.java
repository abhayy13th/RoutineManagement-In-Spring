//package com.backend_assignment.abhay.Configuration;
//
//import com.backend_assignment.abhay.Entity.Teacher;
//import com.backend_assignment.abhay.Repository.TeacherRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class TeacherConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(TeacherRepository repository) {
//        return args -> {
//            Teacher tom = new Teacher(
//                    "Tom",
//                    "Java",
//                    "tom@gmail.com",
//                    "Part-Time");
//
//
//            Teacher abhay = new Teacher(
//                    "Abhay",
//                    "Python",
//                    "abhay@gmail.com",
//                    "Full-Time");
//
//            repository.saveAll(
//                    List.of(tom, abhay));
//
//        };
//
//
//    }
//}
