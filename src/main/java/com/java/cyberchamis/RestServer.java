package com.java.cyberchamis;

//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
//import java.util.Objects;

@SpringBootApplication
public class RestServer {

    public static void main(String[] args) throws IOException {
//        ClassLoader classLoader = RestServer.class.getClassLoader();
//
//        //find better way to implement
//        File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
//        FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());
//
//        FirebaseOptions options = FirebaseOptions.builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
//                .build();
//
//        System.out.println("InitializeApp");
//        FirebaseApp.initializeApp(options);
        SpringApplication.run(RestServer.class, args);
        System.out.println("CyberChamis - Back end STARTED ....\n");
    }

}
