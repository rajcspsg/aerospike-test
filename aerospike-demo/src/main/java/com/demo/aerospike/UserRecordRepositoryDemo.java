package com.demo.aerospike;

import com.demo.aerospike.config.AerospikeConfig;
import com.demo.aerospike.repositories.UserRecordRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import technorati.tut.dso.UserRecord;
import java.util.Optional;

public class UserRecordRepositoryDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AerospikeConfig.class);

        UserRecordRepository repository = ctx.getBean(UserRecordRepository.class);

        Optional<UserRecord> r = repository.findById("AEE84E58631045EABE38522182D92567");
        repository.deleteAll();
        System.out.println(r);

        //r.map(ur ->  {ur.setEnvelope("env1"); return ur;});
        //repository.saveAll(Arrays.asList(r.get()));
    }
}
