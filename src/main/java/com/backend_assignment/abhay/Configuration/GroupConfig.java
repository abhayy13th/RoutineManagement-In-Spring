//package com.backend_assignment.abhay.Configuration;
//
//import com.backend_assignment.abhay.Entity.Group;
//import com.backend_assignment.abhay.Repository.GroupRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class GroupConfig {
//    @Bean
//    CommandLineRunner commandLineRunnerGroup(GroupRepository repository) {
//        return args -> {
//            Group L3C2 = new Group(
//                    45L,
//                    "L3C2",
//                    "Computing"
//            );
//            repository.saveAll(
//                    List.of(L3C2));
//        };
//
//    }
//}
