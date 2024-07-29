package com.demo.elasticsearch.repository;

import com.demo.elasticsearch.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticSearchRepo extends ElasticsearchRepository<Product,Integer> {
}
