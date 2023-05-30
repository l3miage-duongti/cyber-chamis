package com.java.cyberchamis.repository;

import java.sql.Connection; 
import java.util.List;
import javax.servlet.http.HttpServletResponse; 
import javax.sql.DataSource;

import com.java.cyberchamis.model.Materiel;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 


@RestController
@CrossOrigin
@RequestMapping("/api/materiels")
public class MaterielCRUD {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private MaterielRepository materielRepo;
    @Autowired
    private EtapeRepository etapeRepo;

    //Recuperer tous les Materiels
    @GetMapping("/")
    List<Materiel> allMateriels(HttpServletResponse response) {
        try(Connection connection = dataSource.getConnection()){
            
            return materielRepo.findAll();

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

    //Recuperer tous les Materiels d'une Etape
    @GetMapping("/etape/{etapeId}")
    List<Materiel> read(@PathVariable(value="etapeId") int etapeId, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()){
            //Si l'Etape n'existe pas dans la BD
            if(!etapeRepo.existsById(etapeId)){
                response.setStatus(403);
                return null;
            }
            //Renvoyer la liste de Materiels de cette Etape
            return  materielRepo.findAllByEtape(etapeRepo.findById(etapeId).get());
         
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
        return null;
    }

    //Supprimer un Materiel avec son Id
    @DeleteMapping("/{materielId}") 
    void delete(@PathVariable(value="matereielId") int id, HttpServletResponse response){
        try(Connection connection = dataSource.getConnection()) {
            //le Materiel (id) n'existe pas
            if (!materielRepo.existsById(id) ){
                response.setStatus(404);
                return;
            }

            materielRepo.deleteById(id);

        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
    }
}
