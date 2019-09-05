package com.example.parts.service;

import com.example.parts.dto.PartDto;
import com.example.parts.dto.PartDtoMapperPart;
import com.example.parts.model.Part;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PartsService {

    public Set<Part> parts = new HashSet<>();

    private Integer increase(Integer checkId, List<Integer> listId) {
        Integer newId;
        if (listId.contains(checkId)) {
            Integer increaseId = checkId + 1;
            newId = increase(increaseId, listId);
        } else {
            newId = checkId;
        }
        return newId;
    }

    private Part duplicateIdCheck(Part part) {
        List<Part> partsList = new ArrayList<>(parts);
        List<Integer> listId = new ArrayList<>();
        for (int i = 0; i < partsList.size(); i++) {
            listId.add(partsList.get(i).getId());
        }
        Integer checkId = part.getId();
        Integer correctId = increase(checkId, listId);
        Part correctPart = new Part(correctId, part.getNazwaCzesci(), part.getTyp(), part.getStan(), part.getOpis());
        return correctPart;
    }

    public void save(PartDto partDto) {
        PartDtoMapperPart mapper = new PartDtoMapperPart();
        Part part = mapper.partDtoMapperPart(partDto);
        Part checkIdPart = duplicateIdCheck(part);
        parts.add(checkIdPart);
    }

    public void update(Integer id, String nazwaCzesci, String typ, String stan, String opis) {
        Part updateThisPart = parts.stream().filter(part -> part.getId().equals(id)).findFirst().orElse(null);

        String nowaNazwaCzesci;
        String nowyTyp;
        String nowyStan;
        String nowyOpis;

        if (nazwaCzesci != null && nazwaCzesci.length() != 0) {
            nowaNazwaCzesci = updateThisPart.getNazwaCzesci().replace(updateThisPart.getNazwaCzesci(), nazwaCzesci);
        } else {
            nowaNazwaCzesci = updateThisPart.getNazwaCzesci();
        }
        if (typ != null && typ.length() != 0) {
            nowyTyp = updateThisPart.getTyp().replace(updateThisPart.getTyp(), typ);
        } else {
            nowyTyp = updateThisPart.getTyp();
        }
        if (stan != null && stan.length() != 0) {
            nowyStan = updateThisPart.getStan().replace(updateThisPart.getStan(), stan);
        } else {
            nowyStan = updateThisPart.getStan();
        }
        if (opis != null && opis.length() != 0) {
            nowyOpis = updateThisPart.getOpis().replace(updateThisPart.getOpis(), opis);
        } else {
            nowyOpis = updateThisPart.getOpis();
        }

        Part updatedPart = new Part(id, nowaNazwaCzesci, nowyTyp, nowyStan, nowyOpis);

        delete(updateThisPart);
        parts.add(updatedPart);
    }

    public void delete(Part part) {
        parts.remove(part);
    }
}
