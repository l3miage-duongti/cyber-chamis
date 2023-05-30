package com.java.cyberchamis;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class RestServer {

    public static void main(String[] args) throws IOException {
        //find better way to implement
        FileInputStream serviceAccount = new FileInputStream("C:\\Users\\Tien\\Desktop\\Khoi's folder\\Personal projects\\Cyber Chami\\cyber-chami-server\\src\\main\\resources\\serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);

        SpringApplication.run(RestServer.class, args);
    }

}
