package com.java.cyberchamis.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.java.cyberchamis.model.Chami;
import com.java.cyberchamis.repository.ChamiRepository;
import com.java.cyberchamis.repository.DefiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/chamis")
public class ChamiController {
    @Autowired
    private DefiRepository defiRepository;
    @Autowired
    private ChamiRepository chamiRepository;

    //GET all Chamis
    @GetMapping("/")
    List<Chami> getAll() {
        //todo: handle errors
        return chamiRepository.findAll();
    }

    //GET Chami par ID
    @GetMapping("/{chamiId}")
    Chami getById(@PathVariable(value="chamiId") String id, HttpServletResponse response){
        if(!chamiRepository.existsById(id)){
            response.setStatus(403);
            return null;
        }
        //todo: handle errors
        return  chamiRepository.findById(id).get();
    }

    //GET Chami par Email
    @GetMapping("/email/{chamiEmail}")
    Chami getByEmail(@PathVariable(value="chamiEmail") String email, HttpServletResponse response){
        //si le Chami avec $EMAIL n'existe pas
        if(!chamiRepository.existsByEmail(email)){
            response.setStatus(403);
            return null;
        }
        return  chamiRepository.findByEmail(email);
    }

    @PostMapping("/")
    Chami create(@RequestBody Chami chami, HttpServletResponse response){
        //L'id (login) ou l'email du nouveau Chami existe deja
        if (chamiRepository.existsById(chami.getUsername()) || chamiRepository.existsByEmail(chami.getEmail())){
            response.setStatus(409);
            return null;
        }

        //ajouter le nv defi dans la liste des defis de son auteur
        return chamiRepository.save(chami);
    }

    //Ici on peut seulement Update l'age et la description d'un Chami
    //Son Login et Email est inchangeable une fois cree
    @PutMapping("/{chamiId}")
    Chami update(@PathVariable(value = "chamiId") String id, @RequestBody Chami chami, HttpServletResponse response) {
            // Le Chami (id) a modifier n'existe pas dans Database
            if (!chamiRepository.existsById(id)) {
                response.setStatus(404);
                return null;
            }

            //recuperer le Chami courant a modifier
            Chami chami_courant = chamiRepository.findById(id).get();
            chami_courant.setAge(chami.getAge());
            chami_courant.setDescription(chami.getDescription());

            return chamiRepository.save(chami_courant);
    }

    @DeleteMapping("/{chamiId}")
    void delete(@PathVariable(value="chamiId") String id, HttpServletResponse response){
        //le Chami (id) n'existe pas
        if (!chamiRepository.existsById(id) ){
            response.setStatus(404);
            return;
        }
        chamiRepository.deleteById(id);
    }
}
