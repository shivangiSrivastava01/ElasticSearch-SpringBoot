package com.demo.elasticsearch.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.demo.elasticsearch.repository")
public class ElasticSearchConfiguration {

        @Bean
        public ElasticsearchClient client() {

            String serverUrl = "http://localhost:9200";

            RestClient restClient = RestClient.builder(HttpHost.create(serverUrl)).build();

            ElasticsearchTransport elasticsearchTransport = new RestClientTransport(restClient,new JacksonJsonpMapper());

            return new ElasticsearchClient(elasticsearchTransport);

        }
    }
