package com.acko.ackoservice;

import com.acko.ackoservice.model.CustomerModel;
import com.acko.ackoservice.model.OrderModel;
import com.acko.ackoservice.model.StudentModel;
import com.acko.ackoservice.repository.CartRepository;
import com.acko.ackoservice.repository.CustomerRepository;
import com.acko.ackoservice.repository.OrderRepository;
import com.acko.ackoservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AckoServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AckoServiceApplication.class, args);
    }


    @Autowired
    private StudentRepository studentRepository;


    public void run(String... args) {


        StudentModel student1 = new StudentModel(1L, "SAYED", "BENGALORE", "IT", 56);
        StudentModel student2 = new StudentModel(2L, "sudharshan", "HYDERABD", "CSE", 59);
        StudentModel student3 = new StudentModel(3L, "DHONI", "RANCHI", "MECH", 32);
        StudentModel student4 = new StudentModel(4L, "VIRAT", "DELHI", "IT", 78);
        StudentModel student5 = new StudentModel(5L, "ROHITH", "HYDERABD", "CSE", 90);
        StudentModel student6 = new StudentModel(6L, "JADEJA", "JAMNAGAR", "MECH", 23);
        StudentModel student7 = new StudentModel(7L, "DINES KARTHIK", "CHENNAI", "IT", 45);
        StudentModel student8 = new StudentModel(8L, "BUMRA", "MUMBAI", "ECE", 95);
        StudentModel student9 = new StudentModel(9L, "SHAMI", "KOLKATA", "CSE", 90);
        StudentModel student10 = new StudentModel(10L, "BHUVI", "KANPUR", "MECH", 28);
        StudentModel student11 = new StudentModel(11L, "SACHIN", "MUMBAI", "MECH", 48);
        StudentModel student12 = new StudentModel(12L, "SAURAV", "KOLKATA", "CSE", 68);
        StudentModel student13 = new StudentModel(13L, "DRAVID", "BENGALORE", "MECH", 21);
        StudentModel student14 = new StudentModel(14L, "Abdul", "BENGALORE", "IT", 56);
        StudentModel student15 = new StudentModel(15L, "SHOIB", "BENGALORE", "IT", 56);
        StudentModel student16 = new StudentModel(16L, "NANDU", "BENGALORE", "IT", 56);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);
        studentRepository.save(student7);
        studentRepository.save(student8);
        studentRepository.save(student9);
        studentRepository.save(student10);
        studentRepository.save(student11);
        studentRepository.save(student12);
        studentRepository.save(student13);
        studentRepository.save(student14);
        studentRepository.save(student15);
        studentRepository.save(student16);


    }
}

/*

DTO CONVERTER
1) https://www.youtube.com/watch?v=QcctJokqdrg

Cache
______________________
Generic
JCache (JSR-107) (EhCache 3, Hazelcast, Infinispan, and others)
EhCache 2.x
Hazelcast
Infinispan
Couchbase
Redis
Caffeine
Simple


To START REDIS SERVER

GO TO REDIS FOLDER OPEN TERMINAL -- STARt SERVER:
src/redis-server
default port : 6379

Redis Client
src/redis-cli

 */
