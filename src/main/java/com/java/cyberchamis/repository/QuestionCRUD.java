package com.java.cyberchamis.repository;

import java.sql.Connection; 
import java.util.List;
import javax.servlet.http.HttpServletResponse; 
import javax.sql.DataSource;

import com.java.cyberchamis.model.Question;

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
@RequestMapping("/api/questions")
public class QuestionCRUD {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private QuestionRepository questionRepo;
    @Autowired
    private IndiceRepository indiceRepo;

    @GetMapping("/")
    List<Question> allQuestions(HttpServletResponse response) {
        try(Connection connection = dataSource.getConnection()){
            
            return questionRepo.findAll();

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

    @GetMapping("/{questionId}")
    Question read(@PathVariable(value="questionId") int id, HttpServletResponse response){
        try (Connection connection = dataSource.getConnection()){
            if(!questionRepo.existsById(id)){
                response.setStatus(403);
                return null;
            }

            return  questionRepo.findById(id).get();
         
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
        }
        return null;
    }

    @PostMapping("/{questionId}")
    Question create(@PathVariable(value="questionId") int id,@RequestBody Question q, HttpServletResponse response){
         try(Connection connection = dataSource.getConnection()) {
            
            //La question (id) existe deja
            if (questionRepo.existsById(id)){
                response.setStatus(403);
                return null;
            } 

            //si la Question a une Indice, ajouter cette Indice dans la liste des Indices
            if (q.getIndice() != null){
                indiceRepo.save(q.getIndice());
            }
            
            //ajouter la nvlle question dans la BD
            return questionRepo.save(q);
           
        } catch (Exception e) {
            response.setStatus(500);
            System.err.println(e.getMessage());
            }
        return null;
    }

}
