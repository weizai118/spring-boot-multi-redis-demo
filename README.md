# spring-boot-jpa-mongo-redis-demo
## 1、项目简介
spring-boot-data-jpa和spring-boot-data-mongodb常见各种操作的Demo。
- 封装了对MySQL和MongoDB操作的公共的可扩展的两个Base接口；
- 封装了操作Redis的公共接口；

基于Spring Boot 1.5.9和JDK1.8，希望能够帮到你。如果帮到你了，请给我一个星星。
## 2、项目技术点
* spring-boot-starter-data-jpa
* spring-boot-starter-data-mongodb
* spring-boot-starter-data-redis
## 3、如何使用？
### 1、BaseJpaRepository
1. 定义实体类对应的Repository直接继承自`BaseJpaRepository`，就可以直接注入使用；
2. `BaseJpaRepository`接口中提供了多数场景中的诸多CURD方法，还提供了自定义操作方式；
3. 包`com.lilian.repo.mysql`代码中有示例；
### 2、BaseMongoRepository
1. 定义实体类对应的Repository直接继承自`BaseMongoRepository`，就可以直接注入使用；
2. `BaseMongoRepository`接口中提供了多数场景中的诸多CURD方法，还提供了自定义操作方式；
3. 包`com.lilian.repo.mongo`代码中有示例；
### 3、BaseRedisRepository
1. 直接注入`BaseRedisRepository`接口就可以使用接口中定义的所有方法；
2. 自定义方法建议根据方法操作的数据类型在对应的父接口中定义，然后在`SimpleBaseRedisRepository`中实现该方法；
