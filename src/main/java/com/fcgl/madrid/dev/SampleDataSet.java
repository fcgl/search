package com.fcgl.madrid.dev;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcgl.madrid.search.dataModel.Category;
import com.fcgl.madrid.search.dataModel.Merchant;
import com.fcgl.madrid.search.dataModel.Product;
import com.fcgl.madrid.search.dataModel.elasticsearch.ProductSearch;
import com.fcgl.madrid.search.repository.CategoryRepository;
import com.fcgl.madrid.search.repository.MerchantRepository;
import com.fcgl.madrid.search.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class SampleDataSet {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleDataSet.class);

    @Autowired
    ElasticsearchTemplate template;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ProductRepository repo;

    @Autowired
    private CategoryRepository catRepo;

    @Autowired
    private MerchantRepository merRepo;


    /**
     * Populates the same products for mongodb and elasticsearch
     */
    public void populateData() {
        populateElasticSearch();
        populateMongoDb();
    }

    private void populateElasticSearch() {
        List<ProductSearch> products = new ArrayList<>();
        ProductSearch product1 = new ProductSearch(1L, "coca cola", 12.4, 345453453, "pic1.png", "soda", 6.78);
        ProductSearch product2 = new ProductSearch(2L, "chicken", 2.4, 345455343, "pic2.png", "poultry", 8.78);
        ProductSearch product3 = new ProductSearch(3L, "banana", 1.4, 345463343, "pic3.png", "fruit", 9.78);

        products.add(product1);
        products.add(product2);
        products.add(product3);

        try {
            if (!template.indexExists(ProductSearch.getIndexName())) {
                template.createIndex(ProductSearch.getIndexName());
            }
            ObjectMapper mapper = new ObjectMapper();
            List<IndexQuery> queries = new ArrayList<>();
            for (ProductSearch productSearch : products) {
                IndexQuery indexQuery = new IndexQuery();
                indexQuery.setId(productSearch.getId().toString());
                indexQuery.setSource(mapper.writeValueAsString(productSearch));
                indexQuery.setIndexName(ProductSearch.getIndexName());
                indexQuery.setType(ProductSearch.getTypeName());
                queries.add(indexQuery);
            }
            if (queries.size() > 0) {
                template.bulkIndex(queries);
            }
            template.refresh(ProductSearch.getTypeName());
            LOGGER.info("BulkIndex completed: {}");
        } catch (Exception e) {
            LOGGER.error("Error bulk index", e);
        }
    }

    private void populateMongoDb() {
        // save a product
        repo.save(new Product(1, "coca cola", 12.4, new Date(), new Date(), 345453453, "pic.png", new ArrayList<String>(Arrays.asList("soda"))));
        repo.save(new Product(2, "chicken", 2.4, new Date(), new Date(), 345455343, "pic2.png", new ArrayList<String>(Arrays.asList("poultry"))));
        repo.save(new Product(3, "chicken", 1.4, new Date(), new Date(), 345463343, "pic3.png", new ArrayList<String>(Arrays.asList("fruit"))));

        // save a few categories
        catRepo.save(new Category(1, "Beverages", "drinks", new Date(), new Date()));
        catRepo.save(new Category(2, "Dessert", "sweet food", new Date(), new Date()));

        //save a few merchants
        merRepo.save(new Merchant(1, "Walmart", "Palo Alto, CA", new Date(), new Date(), new ArrayList<>()));
        merRepo.save(new Merchant(2, "Target", "Fenway, MA", new Date(), new Date(), new ArrayList<>()));

        // fetch all customers
        System.out.println("findAll():");
        System.out.println("-------------------------------");

        System.out.println("Products: ");
        for (Product prod : repo.findAll()) {
            System.out.println(prod);
        }

        System.out.println("Categories: ");
        for (Category cat : catRepo.findAll()) {
            System.out.println(cat);
        }

        System.out.println("Merchants: ");
        for (Merchant mer : merRepo.findAll()) {
            System.out.println(mer);
        }

        System.out.println("Product found with findByName('cola'):");
        System.out.println("--------------------------------");
        System.out.println(repo.findByName("cola"));
    }
}