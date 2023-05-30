package com.java.cyberchamis.repository;

import java.sql.Connection; 
import java.util.List;
import javax.servlet.http.HttpServletResponse; 
import javax.sql.DataSource;

import com.java.cyberchamis.model.Chami;

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
@RequestMapping("/api/chamis")
public class ChamiCRUD {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private DefiRepository defiRepo;
    @Autowired
    private ChamiRepository chamiRepo;
    @Autowired
    private EtapeRepository etapeRepo;
    @Autowired
    private QuestionRepository questionRepo;
    @Autowired
    private IndiceRepository indiceRepo;

    //GET all Chamis
    @GetMapping("/")
    List<Chami> readAllChamis(HttpServletResponse response) {
        try(Connection connection = dataSource.getConnection()){
    
            return chamiRepo.findAll();

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

    //GET Chami par ID
    @GetMapping("/{chamiId}")
    Chami read(@PathVariable(value="chamiId") String id, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()){
            //si le Chami (id) n'existe pas
            if(!chamiRepo.existsById(id)){
                response.setStatus(403);
                return null;
            }

            return  chamiRepo.findById(id).get();
         
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    //GET Chami par Email
    @GetMapping("/email/{chamiEMAIL}")
    Chami readByEmail(@PathVariable(value="chamiEMAIL") String email, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()){
            //si le Chami avec $EMAIL n'existe pas
            if(!chamiRepo.existsByEmail(email)){
                response.setStatus(403);
                return null;
            }

            return  chamiRepo.findByEmail(email);
         
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
        return null;
    }

    @PostMapping("/{chamiId}")
    Chami create(@PathVariable(value="chamiId") String id,@RequestBody Chami c, HttpServletResponse response){
         try(Connection connection = dataSource.getConnection()) {
            
            //L'id (login) ou l'email du nouveau Chami existe deja
            if (chamiRepo.existsById(id) || chamiRepo.existsByEmail(c.getEmail())){
                response.setStatus(403);
                return null;
            }
            
            //ajouter le nv defi dans la liste des defis de son auteur
            return chamiRepo.save(c);
           
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
            }
        return null;
    }

    //Ici on peut seulement Update l'age et la description d'un Chami
    //Son Login et Email est inchangeable une fois cree
    @PutMapping("/{chamiId}")
    Chami update(@PathVariable(value = "chamiId") String id, @RequestBody Chami chami,
            HttpServletResponse response) {
        try (Connection connection = dataSource.getConnection()) {
            // Le Chami (id) a modifier n'existe pas dans Database
            if (!chamiRepo.existsById(id)) {
                response.setStatus(404);
                return null;
            }

            //recuperer le Chami courant a modifier
            Chami chami_courant = chamiRepo.findById(id).get();
            chami_courant.setAge(chami.getAge());
            chami_courant.setDescription(chami.getDescription());

            return chamiRepo.save(chami_courant);

        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
        return null;
    }

    @DeleteMapping("/{chamiId}") 
    void delete(@PathVariable(value="chamiId") String id, HttpServletResponse response){
        try(Connection connection = dataSource.getConnection()) {
            //le Chami (id) n'existe pas
            if (!chamiRepo.existsById(id) ){
                response.setStatus(404);
                return;
            }
            /* //recuperer le Chami a supprimer
            Chami c = chamiRepo.findById(id).get();
            
            //supprimer ses Defis 
            for (Defi d: c.getDefis()){
                //supprimer les indices, questions et etapes de ce Defi
                for (Etape e: d.getEtapes()){
                    indiceRepo.deleteById(e.getQuestion().getIndice().getId());
                    questionRepo.deleteById(e.getQuestion().getId());
                    etapeRepo.delete(e);
                }
                defiRepo.delete(d);
            } */

            //supprimer le Chami dans Database
            chamiRepo.deleteById(id);

        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
    }
}
