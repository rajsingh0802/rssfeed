# Added Requirement understaning + System Design Architecture  + Database architecture 
# Java8+SpringBoot+JSoup+ROME
## Web blogs and RSS feed generator
Spring Boot based example application for website blogs and RSS feed generation.

## Technologies

+ Spring Boot/Gradle/JSoup/Rome/Lombok/Cassandra(Better here) or Postgresql

## Configuration

+ Create Cassandra/PostgreSQL database and configure connection in **application.properties**
+ Build with Gradle

    `./gradlew build`


## Endpoints

+ **GET /rssblog** – all blogs scrap websites on demand

+ **GET /generaterssfeed** – Get general RSS feed

+ **GET /generaterssfeed/<TARGET_WEBSITE_ID>** – Get RSS feed for specific website


## More information

+ Blog post: [Web scraper and RSS feed generator with Spring Boot](https://blog.mestwin.net/web-scraper-and-rss-feed-generator-with-spring-boot/)
