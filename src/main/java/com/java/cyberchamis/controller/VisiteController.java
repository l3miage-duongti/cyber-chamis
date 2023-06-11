package com.java.cyberchamis.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.java.cyberchamis.model.Visite;
import com.java.cyberchamis.repository.ChamiRepository;
import com.java.cyberchamis.repository.VisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/visites")
public class VisiteController {

    @Autowired
    private VisiteRepository visiteRepository;
    @Autowired
    private ChamiRepository chamiRepository;
//    @Autowired
//    private DefiRepository defiRepo;


    //Recuperer tous les Visites
    @GetMapping("/")
    List<Visite> getAll(HttpServletResponse response) {
        return visiteRepository.findAll();
    }

    //Recuperer tous les Visites d'un Chami
    @GetMapping("/chami/{username}")
    List<Visite> getAllFromChami(@PathVariable(value="username") String username){
        //to do: check if user exists

        return  visiteRepository.findAllByChami(chamiRepository.findById(username).get());
    }
//
//    //Recuperer tous les Visites d'un Defi
//    @GetMapping("/defi/{defiId}")
//    List<Visite> readFromDefi(@PathVariable(value="defiId") int defiId, HttpServletResponse response){
//        try (Connection connection = dataSource.getConnection()){
//            //Si le Defi n'existe pas dans la BD
//            if(!defiRepo.existsById(defiId)){
//                response.setStatus(403);
//                return null;
//            }
//            //Renvoyer la liste des Visites de ce Chami
//            return  visiteRepo.findAllByDefi(defiRepo.findById(defiId).get());
//
//        } catch (Exception e) {
//            response.setStatus(500);
//            System.err.println(e.getMessage());
//        }
//        return null;
//    }

    //Creer une nouvelle Visite
    @PostMapping("/")
    Visite create(@RequestBody Visite v, HttpServletResponse response){
        //si la nouvelle Visite (id) existe deja
        if (visiteRepository.existsById(v.getId())){
            response.setStatus(403);
            return null;
        }
        return visiteRepository.save(v);
    }

    //Supprimer une Visite avec son Id
    @DeleteMapping("/{visiteId}")
    void delete(@PathVariable(value="visiteId") int id, HttpServletResponse response){
        //le Visite (id) n'existe pas
        if (!visiteRepository.existsById(id) ){
            response.setStatus(404);
            return;
        }

        visiteRepository.deleteById(id);
    }
}
