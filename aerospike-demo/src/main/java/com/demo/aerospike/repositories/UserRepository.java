package com.demo.aerospike.repositories;

import com.demo.aerospike.entity.User;
import org.springframework.data.aerospike.repository.AerospikeRepository;

import java.util.List;

public interface UserRepository extends AerospikeRepository<User, String> {

}
