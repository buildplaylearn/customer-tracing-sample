package br.com.tracing.customer.entity;

import br.com.tracing.customer.dto.CustomerDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "CUSTOMER")
public class Customer implements Serializable {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private LocalDate birthDate;

    public Customer() {
    }

    public Customer(String id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public CustomerDTO toDto(){
        return new CustomerDTO(this.id,this.name,this.birthDate);
    }
}
