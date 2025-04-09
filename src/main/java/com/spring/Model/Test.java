package com.spring.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.repository.cdi.Eager;

@Entity
@Data
public class Test {
    @Id
     int id;
     String name;

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
