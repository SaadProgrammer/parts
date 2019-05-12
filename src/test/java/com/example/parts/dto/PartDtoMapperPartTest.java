package com.example.parts.dto;

import org.junit.Assert;
import org.junit.Test;

public class PartDtoMapperPartTest {

    @Test
    public void funkcjaSprwdzaPartsDtoMapperPart(){
        //given
        PartDtoMapperPart pdmp = new PartDtoMapperPart();
        PartDto partDto = new PartDto("1","koło","sportowe","powyginane","trzeba wiemienić");
        //when
        pdmp.partDtoMapperPart(partDto);
        //then
        Assert.assertNotNull(partDto);
        Assert.assertTrue(pdmp.partDtoMapperPart(partDto).getId().equals(partDto.getIdDto()));
    }
}
