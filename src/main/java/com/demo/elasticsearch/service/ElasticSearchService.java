package com.demo.elasticsearch.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.PrefixQuery;
import co.elastic.clients.elasticsearch.core.DeleteResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.demo.elasticsearch.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ElasticSearchService {


    private final ElasticsearchClient esSearchClient;

    private static final String PRODUCTS = "products";

    @Autowired
    public ElasticSearchService(ElasticsearchClient esClient) {
        this.esSearchClient = esClient;
    }

    public List<Product> search(String searchElement) throws IOException {

        List<Product> list = new ArrayList<>();


        BoolQuery boolQuery = BoolQuery.of(b->b
                                 .should(MatchQuery.of(m -> m.field("name").query(searchElement))._toQuery())
                                 .should(MatchQuery.of(p -> p.field("category").query(searchElement))._toQuery())
                                 .should(PrefixQuery.of(p -> p.field("description").value(searchElement))._toQuery())
                );


        SearchRequest searchRequest = SearchRequest.of(s ->s
                                        .index(PRODUCTS)
                                        .query(boolQuery._toQuery()));

        SearchResponse<Product> response = esSearchClient.search(searchRequest, Product.class);

        // Process the search response
        List<Hit<Product>> hitsList = response.hits().hits();

        for(Hit<Product> hit:hitsList){
            Product product = hit.source();
            list.add(product);

        }
        return list;
    }

    public String insertItemEntries(List<Product> products) {
        try {
            for (Product p : products) {
                IndexResponse response = esSearchClient.index(i -> i
                        .index(PRODUCTS)
                        .id(p.getUuid())
                        .document(p)
                );

                log.info("Indexed document with ID: {}, Response: {}", p.getUuid(), response.result());
            }

            log.info("Items inserted successfully!");

            return "Items Inserted Successfully";
        } catch (IOException e) {
            log.error("Error inserting items into Elasticsearch", e);
            return "Failed to insert items";
        }
    }

    public String deleteItemEntry(String elementIdToBeDeleted) throws IOException {

       DeleteResponse response =  esSearchClient.delete(d -> d.index(PRODUCTS).id(elementIdToBeDeleted));
       if(StringUtils.isEmpty(response.toString())){
            return "Item Deleted!!!!";
       }

       return null;

    }
}
