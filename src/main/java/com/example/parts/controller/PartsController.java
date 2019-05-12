package com.example.parts.controller;

import com.example.parts.dto.PartDto;
import com.example.parts.model.Part;
import com.example.parts.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class PartsController {

    @Autowired
    private PartsService partsService;

    @RequestMapping(method = POST, path = "/savepart", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void savePart(@RequestBody PartDto partDto) {
        partsService.save(partDto);
    }

    @RequestMapping(method = GET, path = "/getpart", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Part> getPart(@RequestParam(value = "id", required = false ) String id, @RequestParam(value = "nazwaCzesci", required = false) String nazwaCzesci, @RequestParam(value = "typ", required = false) String typ, @RequestParam(value = "stan", required = false) String stan) {
        List<Part> lista = partsService.parts.stream().filter(
                part -> part.getId().equals(id)
                        || part.getNazwaCzesci().equals(nazwaCzesci)
                        || part.getTyp().equals(typ)
                        || part.getStan().equals(stan)
                        || part.getNazwaCzesci().equals(nazwaCzesci) && part.getTyp().equals(typ)
                        || part.getNazwaCzesci().equals(nazwaCzesci) && part.getStan().equals(stan)
                        || part.getTyp().equals(typ) && part.getStan().equals(stan)
                        || part.getNazwaCzesci().equals(nazwaCzesci) && part.getStan().equals(stan) && part.getTyp().equals(typ))
                .collect(Collectors.toList());
        return lista;
    }

    @RequestMapping(method = PUT, path = "/putpart", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updatePart(@RequestParam(value = "id") String id, @RequestParam(value = "nazwaCzesci", required = false) String nazwaCzesci, @RequestParam(value = "typ", required = false) String typ, @RequestParam(value = "stan", required = false) String stan, @RequestParam(value = "opis", required = false) String opis) {
        partsService.update(id, nazwaCzesci, typ, stan, opis);
    }

    @RequestMapping(method = DELETE, path = "/deletepart", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletePart(@RequestParam(value = "id") String id) {
        Part deleteThisPart = partsService.parts.stream().filter(part -> part.getId().equals(id)).findFirst().orElse(null);
        partsService.delete(deleteThisPart);
    }
}
