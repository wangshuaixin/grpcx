# grpcx
Grpcx is a rpc framework based on grpc. Compare to grpc,  a service register center based on zookeeper is added and load blance service is implemented.  
[![Build Status](https://travis-ci.org/laddcn/grpcx.svg?branch=master)](https://travis-ci.org/laddcn/grpcx)
[![Coverage Status](https://coveralls.io/repos/github/laddcn/grpcx/badge.svg?branch=master)](https://coveralls.io/github/laddcn/grpcx?branch=master)
![](https://img.shields.io/github/license/laddcn/grpcx.svg)

# How to Build and Depoly

### Requirement:  
JDK1.6+   
Zookeeper3+  
Git  
Eclipse  

### Download sourcecode:  
```sh
$ git clone https://github.com/laddcn/grpcx.git   
```
### Build project:  
```sh  
cd to grpcx  
$ mvn install  
$ mvn eclipse:eclipse  
```

### Import maven project to eclipse: 

* grpcx:  
parent project 

* grpcx_core:  
common project, in which register,heartbeat,loadblance functions are implemented  

* grpcx_register:  
register center project, which supports register and heartbeat services  

* grpcx_demo_provider:  
provider demo project 

* grpcx_demo_consumer:  
consumer demo project  

* grpcx_monitor:  
monitor project which shows service informations(service name, related consumers and providers) based on spring boot  

### Run project:    
* Start register:  
Run cn.ladd.grpcx.register.server.RegisterServer in grpcx_register project  

* Start provider: 
Run cn.ladd.grpcx.provider.Provider in grpcx_demo_provider project  

* Start consumer:  
Run cn.ladd.grpcx.consumer.Consumer in grpcx_demo_consumer project  

When you see "Result from remote of 1+3=4" from Consumer console, grpcx project is build successfully!

 



















