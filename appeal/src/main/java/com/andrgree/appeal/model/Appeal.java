package com.andrgree.appeal.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class Appeal {
    public Appeal(String name) {
        this.name = name;
    }

    String name;
}
