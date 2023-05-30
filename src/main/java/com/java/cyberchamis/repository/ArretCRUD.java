package com.java.cyberchamis.repository;

import java.sql.Connection; 
import java.util.List;
import javax.servlet.http.HttpServletResponse; 
import javax.sql.DataSource;

import com.java.cyberchamis.model.Arret;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 


@RestController
@CrossOrigin
@RequestMapping("/api/arrets")
public class ArretCRUD {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private ArretRepository arretRepo;

    @GetMapping("/")
    List<Arret> readAllChamis(HttpServletResponse response) {
        try(Connection connection = dataSource.getConnection()){
    
            return arretRepo.findAll();

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

    @GetMapping("/{arretId}")
    Arret read(@PathVariable(value="arretId") String id, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()){
            //si l'arret n'existe pas
            if(!arretRepo.existsById(id)){
                response.setStatus(403);
                return null;
            }

            return  arretRepo.findById(id).get();
         
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
        return null;
    }
    

    @PostMapping("/{arretId}")
    Arret create(@PathVariable(value="arretId") String id,@RequestBody Arret a, HttpServletResponse response){
         try(Connection connection = dataSource.getConnection()) {
            
            //Les donnees du nouveau Arret existe deja (id, code, nom de l'arret)
            if (arretRepo.existsById(id) || arretRepo.existsByCodeTAG(a.getCodeTAG()) 
                || arretRepo.existsByLienStreetMap(a.getLienStreetMap())){
                response.setStatus(403);
                return null;
            }
        
            //ajouter le nv defi dans la liste des defis de son auteur
            return arretRepo.save(a);
           
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
            }
        return null;
    }
}
