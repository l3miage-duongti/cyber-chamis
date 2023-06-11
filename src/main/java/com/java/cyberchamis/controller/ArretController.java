package com.java.cyberchamis.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.java.cyberchamis.model.Arret;
import com.java.cyberchamis.repository.ArretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/arrets")
public class ArretController {

    @Autowired
    private ArretRepository arretRepository;

    @GetMapping("/")
    List<Arret> getAll(HttpServletResponse response) {
        return arretRepository.findAll();
    }

    @GetMapping("/{codeTAG}")
    Arret getById(@PathVariable(value="codeTAG") String codeTag, HttpServletResponse response){
        //si l'arret n'existe pas
        if(!arretRepository.existsById(codeTag)){
            response.setStatus(403);
            return null;
        }
        return  arretRepository.findById(codeTag).get();
    }


    @PostMapping("/")
    Arret create(@RequestBody Arret arret, HttpServletResponse response){
        //Les donnees du nouveau Arret existe deja (codeTag, lien)
        if (arretRepository.existsById(arret.getCodeTAG()) || arretRepository.existsByLienStreetMap(arret.getLienStreetMap())){
                response.setStatus(403);
                return null;
        }
        return arretRepository.save(arret);
    }

    @PutMapping("/{codeTAG}")
    Arret update(@PathVariable(name = "codeTAG") String codeTag, @RequestBody Arret arret, HttpServletResponse response){
        if (arretRepository.existsById(arret.getCodeTAG()) || arretRepository.existsByLienStreetMap(arret.getLienStreetMap())){
            response.setStatus(403);
            return null;
        }
        return arretRepository.save(arret);
    }

    @DeleteMapping("/{codeTAG}")
    void delete(@PathVariable(name = "codeTAG") String codeTag, HttpServletResponse response){
        if (!arretRepository.existsById(codeTag)){
            response.setStatus(403);
            return;
        }
        arretRepository.deleteById(codeTag);
    }
}