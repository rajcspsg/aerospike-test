package com.demo.aerospike.config;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.data.aerospike.convert.AerospikeTypeAliasAccessor;
import org.springframework.data.aerospike.convert.CustomConversions;
import org.springframework.data.aerospike.convert.MappingAerospikeConverter;
import org.springframework.data.aerospike.core.AerospikeExceptionTranslator;
import org.springframework.data.aerospike.core.AerospikeTemplate;
import org.springframework.data.aerospike.mapping.AerospikeMappingContext;
import org.springframework.data.aerospike.mapping.AerospikeSimpleTypes;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
import java.util.Collections;

@Configuration
@EnableAerospikeRepositories(basePackages = "com.demo.aerospike.repositories")
public class AerospikeConfig {

    public @Bean(destroyMethod = "close") AerospikeClient aerospikeClient() {

        ClientPolicy policy = new ClientPolicy();
        policy.failIfNotConnected = true;
        //String localhost = "172.28.128.3";
        String localhost = "localhost";

        return new AerospikeClient(policy, localhost, 3000);
    }

    public @Bean AerospikeTemplate aerospikeTemplate() {
        CustomConversions conversions = new CustomConversions(Collections.emptyList(), AerospikeSimpleTypes.HOLDER);
        AerospikeTypeAliasAccessor accessor = new AerospikeTypeAliasAccessor();
        MappingAerospikeConverter converter = new MappingAerospikeConverter(new AerospikeMappingContext(), conversions, accessor);
        AerospikeMappingContext context = new AerospikeMappingContext();
        context.setDefaultNameSpace("test");
        return  new AerospikeTemplate(aerospikeClient(), "test", converter, context, new AerospikeExceptionTranslator(){
            @Override
            public DataAccessException translateExceptionIfPossible(RuntimeException ex) {
                ex.printStackTrace();
                return new DataAccessException(ex.getMessage()) {
                };
            }
        });
        //return new AerospikeTemplate(aerospikeClient(), "test");
    }


}
