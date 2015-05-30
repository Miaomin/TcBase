# TcBase
1. download h2 and unzip
http://www.h2database.com/html/download.html

2. Connect h2
Navigate to h2/bin and execute:
java -cp h2*.jar org.h2.tools.Server

3. Login and Create table "Relations" 
sql ref:src/main/resources/dbsql


4. Navigate to TcBase and execute:
mvn spring-boot:run
