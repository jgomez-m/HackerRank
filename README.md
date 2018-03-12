This project is a parser in Java that parses web server access log file, loads the log to MySQL and checks if a given IP makes more than a certain number of requests for the given duration.

It was built using Uncle Bob Clean Archtecture design, and made to keep low use of memory, no matter the file size.

## Project Archtecture
SpringBoot
Spring Batch
MySql

## How to run
To run it, simple run the command:

$ java -jar Parser.jar --accesslog=access.log --startDate=2017-01-01.13:00:00 --duration=hourly --threshold=100 

Important!
This application require an instance of MySQL running in port 3306 at localhost.

To regenerate the JAR

$ mvn clean package

The new file will be under /target

## SQL
The Sql's requested are inside the /SQL folder
