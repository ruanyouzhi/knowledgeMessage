>mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate

>mvn flyway:migrate

>找到占用8080的进程netstat -ano|findstr "8080"
>taskkill -PID *** -F
>set global time_zone='+8:00';
java -jar -Dspring.active=production target/knowledgemessage-0.0.1-SNAPSHOT.jar