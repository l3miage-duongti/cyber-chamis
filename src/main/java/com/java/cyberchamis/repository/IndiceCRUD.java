package com.java.cyberchamis.repository;

import java.sql.Connection; 
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.java.cyberchamis.model.Indice;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 


@RestController
@CrossOrigin
@RequestMapping("/api/indices")
public class IndiceCRUD {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private IndiceRepository indiceRepo;

    @GetMapping("/")
    List<Indice> allIndices(HttpServletResponse response) {
        try(Connection connection = dataSource.getConnection()){
    
            return indiceRepo.findAll();

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

    @GetMapping("/{indiceId}")
    Indice read(@PathVariable(value="indiceId") int id, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()){
            if(!indiceRepo.existsById(id)){
                response.setStatus(403);
                return null;
            }

            return  indiceRepo.findById(id).get();
         
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
        return null;
    }
}
