package org.example.onlinrshop.repository;
import org.example.onlinrshop.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    List<Customer> findAllByName(String name);
//    List<Customer> findAll();

    List<Customer> findAllByAddress(String name);
}
