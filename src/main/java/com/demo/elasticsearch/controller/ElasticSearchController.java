package com.demo.elasticsearch.controller;

import com.demo.elasticsearch.entity.Product;
import com.demo.elasticsearch.service.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
public class ElasticSearchController {

    @Autowired
    private ElasticSearchService esService;

    @GetMapping("/search/{searchElement}")
    public List<Product> getAllData(@PathVariable String searchElement) throws IOException {
        return esService.search(searchElement);
    }

    @PostMapping("/addItems")
    public String insertItems(@RequestBody List<Product> products) throws IOException {
        return esService.insertItemEntries(products);
    }

    @DeleteMapping(value="/delete/{elementIdToBeDeleted}")
    public String deleteItem(@PathVariable String elementIdToBeDeleted) throws IOException {

            return esService.deleteItemEntry(elementIdToBeDeleted);
    }
}
