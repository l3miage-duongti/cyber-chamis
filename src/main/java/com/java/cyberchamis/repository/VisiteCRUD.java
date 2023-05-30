package com.java.cyberchamis.repository;

import java.sql.Connection; 
import java.util.List;
import javax.servlet.http.HttpServletResponse; 
import javax.sql.DataSource;

import com.java.cyberchamis.model.Visite;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 


@RestController
@CrossOrigin
@RequestMapping("/api/visites")
public class VisiteCRUD {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private VisiteRepository visiteRepo;
    @Autowired
    private ChamiRepository chamiRepo;
    @Autowired
    private DefiRepository defiRepo;
    

    //Recuperer tous les Visites
    @GetMapping("/")
    List<Visite> allVisites(HttpServletResponse response) {
        try(Connection connection = dataSource.getConnection()){
            
            return visiteRepo.findAll();

        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
            response.setStatus(500);
        }
        Throwable e = new Throwable();
        try {
            response.getOutputStream().print(e.getMessage());
        } catch (Exception e2) {
            System.err.println(e2.getMessage());
        }
        System.err.println(e.getMessage());
        return null;
    }

    //Recuperer tous les Visites d'un Chami
    @GetMapping("/chami/{login}")
    List<Visite> readFromChami(@PathVariable(value="login") String login, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()){
            //Si le Chami n'existe pas dans la BD
            if(!chamiRepo.existsById(login)){
                response.setStatus(403);
                return null;
            }
            //Renvoyer la liste des Visites de ce Chami
            return  visiteRepo.findAllByChami(chamiRepo.findById(login).get());
         
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
        return null;
    }

    //Recuperer tous les Visites d'un Defi
    @GetMapping("/defi/{defiId}")
    List<Visite> readFromDefi(@PathVariable(value="defiId") int defiId, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()){
            //Si le Defi n'existe pas dans la BD
            if(!defiRepo.existsById(defiId)){
                response.setStatus(403);
                return null;
            }
            //Renvoyer la liste des Visites de ce Chami
            return  visiteRepo.findAllByDefi(defiRepo.findById(defiId).get());
         
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
        return null;
    }

    //Creer une nouvelle Visite
    @PostMapping("/")
    Visite create(@RequestBody Visite v, HttpServletResponse response){
        try(Connection connection = dataSource.getConnection()) {
            //si la nouvelle Visite (id) existe deja
            if (visiteRepo.existsById(v.getId())){
                response.setStatus(403);
                return null;
            }
            
            return visiteRepo.save(v);
           
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
        return null;
    }

    //Supprimer une Visite avec son Id
    @DeleteMapping("/{visiteId}") 
    void delete(@PathVariable(value="visiteId") int id, HttpServletResponse response){
        try(Connection connection = dataSource.getConnection()) {
            //le Visite (id) n'existe pas
            if (!visiteRepo.existsById(id) ){
                response.setStatus(404);
                return;
            }

            visiteRepo.deleteById(id);

        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
    }
}
