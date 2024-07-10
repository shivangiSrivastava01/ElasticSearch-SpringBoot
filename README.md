# ElasticSearch-SpringBoot

Demo project for Elastic Search with Java Spring Boot Project

## Setup

### POM.xml
```xml
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
```

### Application.properties:

```
spring.data.elasticsearch.cluster-names=docker-cluster
spring.data.elasticsearch.cluster-node=localhost:9200
```

### Docker Setup for Elastic Search:

1) docker pull docker.elastic.co/elasticsearch/elasticsearch:8.13.0
2) docker run
```
docker run -p 9200:9200 -d --name elasticsearch \
-e "discovery.type=single-node" \
-e "xpack.security.enabled=false" \
-e "xpack.security.http.ssl.enabled=false" \
-e "xpack.license.self_generated.type=trial" \
docker.elastic.co/elasticsearch/elasticsearch:8.13.0
```

4) Check the created container and image in Docker.
5) Access the URL http://localhost:9200 to check the details about the Elastic Search container.
6) Access the URL http://localhost:9200/indexName (this can be any name given to your index in the entity class in your Spring Boot project).
7) The above URL will give all the details of entries present in the Elastic Search DB.

That's It!!!!!! Enjoy Exploring ElasticSearch :)
