package com.example.parts.service;

import com.example.parts.dto.PartDto;
import com.example.parts.dto.PartDtoMapperPart;
import com.example.parts.model.Part;
import org.junit.Assert;
import org.junit.Test;

public class PartsServiceTest {

    @Test
    public void funkcjaSprwdzaSave() {
        //given
        PartsService ps = new PartsService();
        PartDto partDto = new PartDto(1, "koło", "sportowe", "powyginane", "do wymiany");
        //when
        ps.save(partDto);
        //then
        Assert.assertNotNull(ps.parts);
        Assert.assertTrue(ps.parts.size()>0);
    }

    @Test
    public void funkcjaSprwdzaUpdate() {
        //given
        PartDtoMapperPart mapper = new PartDtoMapperPart();
        PartsService ps = new PartsService();
        PartDto partDto = new PartDto(1, "koło", "sportowe", "powyginane", "trzeba wiemienić");
        ps.save(partDto);
        //when
        ps.update(1, "", "miejskie", "nowe", "ok");
        //then
        Assert.assertNotNull(ps.parts);
        Assert.assertTrue(ps.parts.size()>=1);
    }

    @Test
    public void funkcjaSprwdzaDelete() {
        //given
        PartDtoMapperPart mapper = new PartDtoMapperPart();
        PartsService ps = new PartsService();
        PartDto partDto = new PartDto(1, "koło", "sportowe", "powyginane", "trzeba wiemienić");
        ps.save(partDto);
        Part deleteThisPart = ps.parts.stream().filter(part->part.getId().equals(partDto.getIdDto())).findFirst().orElse(null);
        //when
        ps.delete(deleteThisPart);
        //then
        Assert.assertTrue(ps.parts.size()<=0);
    }
}
