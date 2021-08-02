# Spring-boot-data-H2-embedded
Esta aplicación es desarrollada como challenge para la empresa W2M.
La misma cuenta con una base de datos en memoria H2 con propositos demo.
Tecnología SpringBoot y Java 11.

**Application.properties**

```
spring.datasource.url=jdbc:h2:mem:TEST;DB_CLOSE_DELAY=-1;
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.platform=h2
spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
```

This single interface will do all the magic for you

```
public interface EmployeeService extends JpaRepository<Employee, Integer>{
}
```

**Correr la aplicación sin Docker**

```
> mvn clean install
> java -jar target/spring-h2-demo.jar
```

**Correr la aplicación con Docker**
```
> mvn clean install
> docker build -t springboot-h2-sample
> docker run -d -p 8080:8080 springboot-h2-sample

> docker stop <image-name>
```
