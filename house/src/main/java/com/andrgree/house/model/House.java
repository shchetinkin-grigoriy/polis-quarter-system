package com.andrgree.house.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Data
@Setter
@Getter
//@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Transient
    private Appeal appeal;

    private String profile;

    public House(String name) {
        this.name = name;
    }

    public House() {    }
}
