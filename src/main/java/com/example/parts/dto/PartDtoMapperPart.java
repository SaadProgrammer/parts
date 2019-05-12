package com.example.parts.dto;

import com.example.parts.model.Part;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor

public class PartDtoMapperPart {

    public Part partDtoMapperPart(PartDto partDto) {
        String id = partDto.getIdDto();
        String nazwaCzesci = partDto.getNazwaCzesciDto();
        String typ = partDto.getTypDto();
        String stan = partDto.getStanDto();
        String opis = partDto.getOpisDto();
        return new Part(id, nazwaCzesci, typ, stan, opis);
    }

}
