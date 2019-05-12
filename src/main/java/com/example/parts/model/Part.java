package com.example.parts.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Part {

    private String id;
    private String nazwaCzesci;
    private String typ;
    private String stan;
    private String opis;

}
