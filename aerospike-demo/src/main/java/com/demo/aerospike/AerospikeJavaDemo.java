package com.demo.aerospike;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import java.util.Map;

public class AerospikeJavaDemo {

    public static void main(String[] args) {
        AerospikeClient client = new AerospikeClient("localhost", 3000);
        Key k1 = new Key("test", "UserRecord", "15A8DECD98A445A5BBC64C06EAE882E6");
        Record record = client.get(null, k1);
        Map<String, Object> bins = record.bins;
        bins.put("envelope", "env1");
        bins.put("createdTS", 0L);
        bins.put("updatedTS", 0L);
        System.out.println("record is "+ bins);
        int binSize = bins.size();
        System.out.println("binSize = " + binSize);
        Bin[] binArray =  bins.entrySet().stream().map(x -> new Bin(x.getKey(), x.getValue())).toArray(Bin[]::new);
        client.put(null, k1,binArray);

    }
}
