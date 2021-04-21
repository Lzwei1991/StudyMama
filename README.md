# StudyMama
NUS-ISS Masters of Technology
Architecturing Software Solutions
Practice Module Project

**IDE:** Eclipse IDE 2021‑03 https://www.eclipse.org/downloads/

**Database:**  MySQL Community https://dev.mysql.com/downloads/installer/

**API Tester:** Postman https://www.postman.com/downloads/

**Language:** Java SE Development Kit 8u281 https://www.oracle.com/sg/java/technologies/javase/javase-jdk8-downloads.html

**Logs Analysis**:
ElastiSearch, Logstash, Kibana (ELK)
ELK stack gives you the ability to aggregate logs from all your systems and applications, analyze these logs, and create visualizations for application and infrastructure monitoring, faster troubleshooting, security analytics

Frameworks
-
SpringBoot 2.4.4
https://start.spring.io/

Dependencies
```
Spring Web
Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.

Spring Security
Highly customizable authentication and access-control framework for Spring applications.

JSON Web Token Security
JSON Web Tokens are an open, industry standard RFC 7519 method for representing claims securely between two parties.

Spring Data JPA
Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate

MySQL Driver
MySQL JDBC and R2DBC driver.

Swagger
Swagger is an Interface Description Language for describing RESTful APIs expressed using JSON. 
```

MySQL
-
MySQL is an open-source relational database management system.

**Schema**
```
CREATE SCHEMA `studymama` ;
```
**User**
CREATE USER 'studymama'@'localhost' IDENTIFIED BY 'studymama@123';
GRANT ALL PRIVILEGES ON studymama.* TO 'studymama'@'localhost';
FLUSH PRIVILEGES;

**User Table**
```
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```

ElasticSearch
-
Elasticsearch is a search engine based on the Lucene library. It provides a distributed, multitenant-capable full-text search engine with an HTTP web interface and schema-free JSON documents.
https://www.elastic.co/downloads/elasticsearch

Kibana
-
Kibana is a data visualization dashboard for Elasticsearch. It provides visualization capabilities on top of the content indexed on an Elasticsearch cluster.
https://www.elastic.co/downloads/kibana


Logstash
-
Logstash is a free and open server-side data processing pipeline that ingests data from a multitude of sources, transforms it, and then sends it to your favorite "stash."
https://www.elastic.co/downloads/logstash

FileBeat
-
Filebeat is a lightweight shipper for forwarding and centralizing log data. Installed as an agent on your servers, Filebeat monitors the log files or locations that you specify, collects log events, and forwards them either to Elasticsearch or Logstash for indexing.
https://www.elastic.co/downloads/beats/filebeat

Swagger
-
Swagger is an Interface Description Language for describing RESTful APIs expressed using JSON. Swagger is used together with a set of open-source software tools to design, build, document, and use RESTful web services. Swagger includes automated documentation, code generation, and test-case generation.
