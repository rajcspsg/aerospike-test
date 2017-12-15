package benchmark;

import com.demo.aerospike.config.AerospikeConfig;
import com.demo.aerospike.entity.User;
import com.demo.aerospike.repositories.UserRepository;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;

public class AerospikeCreateBenchMarkDemo {

    @State(Scope.Benchmark)
    public static class AerospikeCreateBenchmarkPlan {

        @Param({ "10" })
        public int iterations;

        public List<User> persons = new ArrayList<>();

        public UserRepository repository;

        Random rand = new Random();

        @Setup(Level.Invocation)
        public void setUp() {
            ApplicationContext ctx = new AnnotationConfigApplicationContext(AerospikeConfig.class);
            repository = ctx.getBean(UserRepository.class);

            for(int i=0; i < iterations; i++) {
                persons.add(generateUser());
            }
        }

        private User generateUser() {
            String id = UUID.randomUUID().toString();

            HashMap<String, String> eUserIds = new HashMap<>();

            for (int i =0; i < 20; i++) {
                String key = UUID.randomUUID().toString();
                String value = UUID.randomUUID().toString();
                eUserIds.put(key, value);
            }
            return new User(id, eUserIds);
        }
    }

    @Fork(value = 1, warmups = 2)
    @Benchmark
    @BenchmarkMode({Mode.All})
    @Warmup(iterations = 5)
    public void createUser(AerospikeCreateBenchmarkPlan plan) {
        plan.persons.forEach(p -> plan.repository.save(p));
    }

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(AerospikeCreateBenchMarkDemo.class.getSimpleName()).forks(1).build();

        new Runner(options).run();
    }

}
