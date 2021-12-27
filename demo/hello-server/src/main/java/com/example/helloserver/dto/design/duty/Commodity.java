package com.example.helloserver.dto.design.duty;
import lombok.Data;

import java.util.List;

@Data
public class Commodity {
    private List<Item> item;
}