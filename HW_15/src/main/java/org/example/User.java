package org.example;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {


    String job;
    String name;

    public User( String name, String job) {
        this.job = job;
        this.name = name;
    }
}
