package com.java.cyberchamis.repository;

import java.sql.Connection; 
import java.util.List;
import javax.servlet.http.HttpServletResponse; 
import javax.sql.DataSource;

import com.java.cyberchamis.model.Etape;

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
@RequestMapping("/api/etapes")
public class EtapeCRUD {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private EtapeRepository etapeRepo;
    @Autowired
    private QuestionRepository questionRepo;
    @Autowired
    private IndiceRepository indiceRepo;
    
    //recuperer tous les Etapes
    @GetMapping("/")
    List<Etape> readAllEtapes(HttpServletResponse response) {
        try(Connection connection = dataSource.getConnection()){
           
            return etapeRepo.findAll();

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

    //Recuperer une Etape avec son Id
    @GetMapping("/{etapeId}")
    Etape read(@PathVariable(value="etapeId") int id, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()){
            if(!etapeRepo.existsById(id)){
                response.setStatus(403);
                return null;
            }

            return  etapeRepo.findById(id).get();
         
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
        return null;
    }

    //Creer une nouvelle Etape
    @PostMapping("/{etapeId}")
    Etape create(@PathVariable(value="etapeId") int id,@RequestBody Etape etape, HttpServletResponse response){
         try(Connection connection = dataSource.getConnection()) {
            
            //L'Etape (id) existe deja
            if (etapeRepo.existsById(id)){
                response.setStatus(403);
                return null;
            } 

            //ajouter la nvlle etape dans la liste des etapes de son defi
            etape.getDefi().getEtapes().add(etape);
            //si la nouvelle Etape a une Question, ajouter cette Question dans la liste des Questions
            if (etape.getQuestion() != null){
                //si la Question a une Indice, ajouter cette Indice dans la liste des Indices
                if (etape.getQuestion().getIndice() != null){
                    indiceRepo.save(etape.getQuestion().getIndice());
                }
                questionRepo.save(etape.getQuestion());
            }
            //ajouter la nvlle etape dans la BD
            return etapeRepo.save(etape);
           
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
            }
        return null;
    }

    //Supprimer une Etape avec son Id
    @DeleteMapping("/{etapeId}") 
    void delete(@PathVariable(value="etapeId") int id, HttpServletResponse response){
        try(Connection connection = dataSource.getConnection()) {
            //l'Etape (id) n'existe pas
            if (!etapeRepo.existsById(id) ){
                response.setStatus(404);
                return;
            }

            etapeRepo.deleteById(id);

        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
    }
}
