package com.demo.ElasticSearch.repository;

import com.demo.ElasticSearch.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticSearchRepo extends ElasticsearchRepository<Product,Integer> {
}
