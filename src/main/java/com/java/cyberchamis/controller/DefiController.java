package com.java.cyberchamis.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.java.cyberchamis.model.Defi;
import com.java.cyberchamis.repository.ArretRepository;
import com.java.cyberchamis.repository.ChamiRepository;
import com.java.cyberchamis.repository.DefiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/defis")
public class DefiController {

    @Autowired
    private DefiRepository defiRepository;
    @Autowired
    private ChamiRepository chamiRepository;
    @Autowired
    private ArretRepository arretRepository;

    @GetMapping("/")
    List<Defi> getAll() {
        return defiRepository.findAll();
    }

    //Recuperer tous les Defis d'un Chami
    @GetMapping("/chami/{username}")
    List<Defi> getAllFromChami(@PathVariable(value="username") String username, HttpServletResponse response){
        //todo :si le Chami n'existe pas ?
        return  defiRepository.findAllByAuteur(chamiRepository.findById(username).get());
    }

    //Recuperer un Defi avec son Id
    @GetMapping("/{defiId}")
    Defi getById(@PathVariable(value="defiId") int id, HttpServletResponse response){
        //si le Defi n'existe pas
        if(!defiRepository.existsById(id)){
            response.setStatus(403);
            return null;
        }
        return  defiRepository.findById(id).get();
    }

    @GetMapping("/arret/{codeTAG}")
    List<Defi> getAllByDepart (@PathVariable(value = "codeTAG") String codeTag, HttpServletResponse response){
        if(!arretRepository.existsById(codeTag)){
            response.setStatus(403);
            return null;
        }
        return defiRepository.findAllByDepart( arretRepository.findById(codeTag).get() );
    }

    @PostMapping("/")
    Defi create (@RequestBody Defi defi){
        //todo: handle errors
        return defiRepository.save(defi);
    }

    @PutMapping("/{defiId}")
    Defi update (@PathVariable(value = "defiId") int id, @RequestBody Defi defi, HttpServletResponse response){
        if (!defiRepository.existsById(id) ){
            response.setStatus(404);
            return null;
        }
        return defiRepository.save(defi);
    }

    //Supprimer un Defi avec son Id
    @DeleteMapping("/{defiId}")
    void deleteById(@PathVariable(value="defiId") int id, HttpServletResponse response){
        //le Defi (id) n'existe pas
        if (!defiRepository.existsById(id) ){
            response.setStatus(404);
            return;
        }
        defiRepository.deleteById(id);
    }

}
