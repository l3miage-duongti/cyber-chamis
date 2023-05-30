package com.java.cyberchamis.repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse; 
import javax.sql.DataSource;

import com.java.cyberchamis.model.Defi;
import com.java.cyberchamis.model.Etape;
import com.java.cyberchamis.model.Indice;
import com.java.cyberchamis.model.Question;

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
@RequestMapping("/api/defis")
public class DefiCRUD {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private DefiRepository defiRepo;
    @Autowired
    private ChamiRepository chamiRepo;

    @GetMapping("/")
    List<Defi> allDefis(HttpServletResponse response) {
        try(Connection connection = dataSource.getConnection()){
    
            return defiRepo.findAll();

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

    //Recuperer tous les Defis d'un Chami
    @GetMapping("/chami/{login}")
    List<Defi> readAllFromChami(@PathVariable(value="login") String login, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()){
            //si le Chami n'existe pas
            if(!chamiRepo.existsById(login)){
                response.setStatus(403);
                return null;
            }

            return  defiRepo.findAllByAuteur(chamiRepo.findById(login).get());
         
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
        return null;
    }

    //Recuperer un Defi avec son Id
    @GetMapping("/{defiId}")
    Defi read(@PathVariable(value="defiId") int id, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()){
            //si le Defi n'existe pas
            if(!defiRepo.existsById(id)){
                response.setStatus(403);
                return null;
            }

            return  defiRepo.findById(id).get();
         
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
        return null;
    }
    

    @PostMapping("/")
    Defi create(@RequestBody Defi d, HttpServletResponse response){
         try(Connection connection = dataSource.getConnection()) {
            
            //Creer un nv Defi sans ses etapes
            Defi nv_defi = new Defi(d.getTitre(), d.getDateDeCreation(), d.getDescription(), d.getArret(), new ArrayList<>(), d.getAuteur(), d.getEpilogue());
        
    
           //Ajouter les etapes de ce nouveau Defi
            for (Etape e: d.getEtapes()){
                
                //ajouter l'Indice dans la nouvelle Question
                //et Question dans Etape si != null
                if (e.getQuestion() != null){
                    Question nv_question = e.getQuestion();
                    nv_question.setId((new Question()).getId());

                    Indice nv_indice = e.getQuestion().getIndice();
                    if (nv_indice != null){
                        nv_indice.setId((new Indice()).getId());
                    }
                }
                
                //ajouter l'Etape dans le nouveau Defi
                Etape nv_etape = e;
                nv_etape.setId((new Etape()).getId());
                nv_defi.addEtape(nv_etape);
            } 
            //sauvegarder le nouveau Defi dans BD
            return defiRepo.save(nv_defi);
           
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
        return null;
    }

    //Supprimer un Defi avec son Id
    @DeleteMapping("/{defiId}") 
    void delete(@PathVariable(value="defiId") int id, HttpServletResponse response){
        try(Connection connection = dataSource.getConnection()) {
            //le Defi (id) n'existe pas
            if (!defiRepo.existsById(id) ){
                response.setStatus(404);
                return;
            }
            /*
            Defi d = defiRepo.findById(id).get();
            //supprimer les indices, questions et etapes de ce Defi
            for (Etape e: d.getEtapes()){
                indiceRepo.deleteById(e.getQuestion().getIndice().getId());
                questionRepo.deleteById(e.getQuestion().getId());
                etapeRepo.delete(e);
            }
            */
            //supprimer le Defi dans Database
            defiRepo.deleteById(id);

        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
    }

}
