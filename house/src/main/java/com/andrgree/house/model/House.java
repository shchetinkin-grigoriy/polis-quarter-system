package com.andrgree.house.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@Data
@Setter
@Getter
@NoArgsConstructor
public class House {

    private String name;

    private String profile;

    public House(String name) {
        this.name = name;
    }
}
