# ElasticSearch-SpringBoot
Demo project for Elastic Search with Java Spring Boot Project

Setup:

POM.xml:
        <dependency>
			<groupId>co.elastic.clients</groupId>
			<artifactId>elasticsearch-java</artifactId>
			<version>8.14.2</version>
		</dependency>

		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.17.0</version>
		</dependency>
  
Application.properties
spring.data.elasticsearch.cluster-names=docker-cluster
spring.data.elasticsearch.cluster-node=localhost:9200
  
