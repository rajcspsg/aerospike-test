
<b><h7><u>Installing Aerospike</u></h7></b>

Install Docker for Mac in your local if you have mac system and Docker toolbox if you have windows laptop.
Verify whether installation is successful by executing docker info.
Run the aerospike server in docker container. 

`docker run -d -p 3000:3000 -p 3001:3001 -p 3002:3002 -p 3003:3003 --name aerospike aerospike/aerospike-server`


The <i><t>aerospike-test</t></i> consists of 2 sub projects

1. aerospike-demo and
2. aerospike-benchmark-demo

<b><u><h7> aerospike-demo</h7></u></b>

This project has 2 flavor of java client to interact with aerospike.\
The plain java client for connecting with Aerospike `com.demo.aerospike.AerospikeDemo`.\
The Spring data version of aerospike to version is `com.demo.aerospike.MySpringDataAerospikeDemo`.


<b><h7><u>aerospike-benchmark-demo</u></h7></b>

This project depends on aerospike-demo and benchmarks the CRUD operations on aerospike.

Run this project using the command `gradle :aerospike-benchmark-demo:jmh --stacktrace` 

