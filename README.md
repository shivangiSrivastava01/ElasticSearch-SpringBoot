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

Docker Setup for Elastic Search
	1) Pull the elastic search docker image by using command: docker pull docker.elastic.co/elasticsearch/elasticsearch:8.13.0
 	2) run the image using command given below: 
  		docker run -p 9200:9200 -d --name elasticsearch \
		-e "discovery.type=single-node" \
		-e "xpack.security.enabled=false" \
		-e "xpack.security.http.ssl.enabled=false" \
		-e "xpack.license.self_generated.type=trial" \
		docker.elastic.co/elasticsearch/elasticsearch:8.13.0
  	3) Check the created container and image in docker.
   	4) Access Url http://localhost:9200 - to check the details about the elastic search container
    	5) Access Url http://localhost:9200/indexName - (this can be any name given to your index in entity class in your spring boot project)
     	6) The above url will give all the details of entries present in the elastic search DB

That's It!!!!!! Enjoy Exploring ElasticSearch :)
  
