package com.example.parts.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "nazwaCzesciDto")

public class PartDto {

    private String idDto;
    private String nazwaCzesciDto;
    private String typDto;
    private String stanDto;
    private String opisDto;

}
