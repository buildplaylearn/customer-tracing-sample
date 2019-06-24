package br.com.tracing.customer.repository;

import br.com.tracing.customer.entity.Customer;
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.runtime.ApplicationConfiguration;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Singleton
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private ApplicationConfiguration applicationConfiguration;

    public CustomerRepository(@CurrentSession EntityManager entityManager,
                              ApplicationConfiguration applicationConfiguration) {
        this.entityManager = entityManager;
        this.applicationConfiguration = applicationConfiguration;
    }

    @Transactional
    public Customer save(Customer customer) {
        this.entityManager.persist(customer);
        return customer;
    }

    @Transactional
    public Optional<Customer> findById(String id){
        return Optional.ofNullable(this.entityManager.find(Customer.class,id));
    }

}
