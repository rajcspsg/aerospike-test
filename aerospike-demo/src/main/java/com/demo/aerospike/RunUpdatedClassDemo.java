package com.demo.aerospike;

import com.demo.aerospike.config.AerospikeConfig;
import com.demo.aerospike.entity.User;
import com.demo.aerospike.repositories.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.HashMap;
import java.util.UUID;

public class RunUpdatedClassDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AerospikeConfig.class);

        UserRepository repository = ctx.getBean(UserRepository.class);


        HashMap<String, String> daveMap = new HashMap<>();
        daveMap.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());

        User dave = new User("Dave-01", daveMap);
        dave.setEnvelope("env1");
        dave.setTestString3("test3");
        repository.save(dave);

        System.out.println("updated dave is " + dave);
    }
}
