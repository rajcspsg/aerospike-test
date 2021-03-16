package com.demo.aerospike.repositories;

import org.springframework.data.aerospike.repository.AerospikeRepository;
import technorati.tut.dso.UserRecord;

public interface UserRecordRepository extends AerospikeRepository<UserRecord, String> {
}
