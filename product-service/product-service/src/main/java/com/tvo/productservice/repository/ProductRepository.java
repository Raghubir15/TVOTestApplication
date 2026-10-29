package com.tvo.productservice.repository;

import com.tvo.productservice.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

//  static in memory data
@Repository
public class ProductRepository {

    public List<Product> findByCustomerId(String customerId) {

        return List.of(
                new Product(
                        customerId,
                        "P100",
                        "SERVICE TVO-Today"
                ),
                new Product(
                        customerId,
                        "P200",
                        "SERVICE TVO-Kids"
                ),
                new Product(
                        customerId,
                        "P300",
                        "SERVICE TVO-learn"
                )
        );
    }
}
