package org.example;

import lombok.Data;

import java.util.List;

@Data
public class Group {

    int id;
    String title;

    List<Link> links;
}
