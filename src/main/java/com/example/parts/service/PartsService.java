package com.example.parts.service;

import com.example.parts.dto.PartDto;
import com.example.parts.dto.PartDtoMapperPart;
import com.example.parts.model.Part;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PartsService {

    public Set<Part> parts = new HashSet<>();

    public void save(PartDto partDto) {
        PartDtoMapperPart mapper = new PartDtoMapperPart();
        Part part = mapper.partDtoMapperPart(partDto);
        parts.add(part);
    }

    public void update(String id, String nazwaCzesci, String typ, String stan, String opis) {
        Part updateThisPart = parts.stream().filter(part -> part.getId().equals(id)).findFirst().orElse(null);
        if (nazwaCzesci != null) {
            updateThisPart.getNazwaCzesci().replace(updateThisPart.getNazwaCzesci(), nazwaCzesci);
        }
        if (typ != null) {
            updateThisPart.getTyp().replace(updateThisPart.getTyp(), typ);
        }
        if (stan != null) {
            updateThisPart.getStan().replace(updateThisPart.getStan(), stan);
        }
        if (opis != null) {
            updateThisPart.getOpis().replace(updateThisPart.getOpis(), opis);
        }
    }

    public void delete(Part part) {
        parts.remove(part);
    }
}
