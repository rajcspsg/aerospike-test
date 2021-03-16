package com.demo.aerospike;

import com.demo.aerospike.config.AerospikeConfig;
import com.demo.aerospike.entity.User;
import com.demo.aerospike.repositories.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;

public class MySpringDataAerospikeDemo {

    public static void main(String []args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AerospikeConfig.class);

        UserRepository repository = ctx.getBean(UserRepository.class);

        //repository.deleteAll();

        HashMap<String, String> daveMap = new HashMap<>();
        daveMap.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());

        User dave = new User("Dave-01", daveMap);
        /*//repository.createIndex(User.class, "user_name_index_repository", "name", IndexType.STRING);


        User donny = new User("Dave-02", new HashMap<>());
        User oliver = new User("Oliver-01", new HashMap<>());
        User carter = new User("Carter-01", new HashMap<>());
        User boyd = new User("Boyd-01", new HashMap<>());
        User stefan = new User("Stefan-01", new HashMap<>());
        User leroi = new User("Leroi-01", new HashMap<>());
        User leroi2 = new User("Leroi-02", new HashMap<>());
        User alicia = new User("Alicia-01", new HashMap<>());

        Arrays.asList(oliver,
                dave, donny, carter, boyd, stefan, leroi, leroi2, alicia).forEach(x -> repository.save(x));

        Iterable<User> savedIterableUsers = repository.findAll();

        List<User> savedUsers= StreamSupport.stream(savedIterableUsers.spliterator(), false)
                .collect(Collectors.toList());

        System.out.println(savedUsers);

*/
        //HashMap<String, String> daveMap = new HashMap<>();
        daveMap.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        daveMap.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());

        User newDave = new User("Dave-01", daveMap);
        newDave.setTestString("testStr");
        newDave.setTestString2("testStr2");
        repository.save(newDave);

        Optional<User> davenew = repository.findById(dave.getId());
        System.out.println("new dave is \n" + davenew);

    }
}
