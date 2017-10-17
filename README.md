[![Build Status][travis-badge]][travis-badge-url]

![](./img/spring-shell.png) ![](./img/plus.png) ![](./img/spring-boot.png)

Spring Shell 2 Examples with Tests
========================================

[Spring Shell 2.0.0](https://docs.spring.io/spring-shell/docs/2.0.0.M2/reference/htmlsingle/#_getting_started) 
with [Spring Boot 2.0.0](https://docs.spring.io/spring-boot/docs/2.0.0.M5/reference/htmlsingle/) examples along with unit and integration testings.

### Build
Execute the following command from the parent directory to build the jar file:
```
mvn clean install
```

### Run
From the parent directory, executte the following coommand to start the application:
```
java -jar target/spring-shell-example-1.0.0.jar
```

You should notice the application starting up,
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::             (v2.0.0.M5)

2017-10-17 16:11:18.065  INFO 21210 --- [           main] com.basaki.Application                   : Starting Application on jdoe-001 with PID 21210 (/Users/john.doe/spring-shell-example/target/spring-shell-example-1.0.0.jar started by john doe in /Users/john.doe/Development/examples/spring-shell-example)
2017-10-17 16:11:18.069  INFO 21210 --- [           main] com.basaki.Application                   : No active profile set, falling back to default profiles: default
2017-10-17 16:11:18.144  INFO 21210 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@34033bd0: startup date [Tue Oct 17 16:11:18 PDT 2017]; root of context hierarchy
2017-10-17 16:11:19.547  INFO 21210 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
indra:>
```

Once the application starts up, type `add 1 2` to add up two integers. You should notice `3` in the terminal.
```
indra:>add 1 2
3
indra:>
```

[travis-badge]: https://travis-ci.org/indrabasak/spring-shell-example.svg?branch=master
[travis-badge-url]: https://travis-ci.org/indrabasak/spring-shell-example/