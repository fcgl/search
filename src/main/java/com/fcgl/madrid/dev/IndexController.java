package com.fcgl.madrid.dev;

import com.fcgl.madrid.search.dataModel.Category;
import com.fcgl.madrid.search.dataModel.Merchant;
import com.fcgl.madrid.search.dataModel.Product;
import com.fcgl.madrid.search.repository.CategoryRepository;
import com.fcgl.madrid.search.repository.MerchantRepository;
import com.fcgl.madrid.search.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/dev")
public class IndexController {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    MongoClient mongoClient;

    @Autowired
    private ProductRepository repo;

    @Autowired
    private CategoryRepository catRepo;

    @Autowired
    private MerchantRepository merRepo;

    @GetMapping(value = "/test")
    public String test() {

        // save a product
        repo.save(new Product(1, "sprite", 12.0, new Date(), new Date(), 123, "pic.png", new ArrayList<String>()));
        repo.save(new Product(2, "cola", 32.0, new Date(), new Date(), 1233, "pic2.png", new ArrayList<String>()));

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

        return "check log";
    }
}
