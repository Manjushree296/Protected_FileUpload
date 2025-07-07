package com.example.FileUploader;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;

@SpringBootApplication // ✅ This was missing!
public class FileUploaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploaderApplication.class, args);
	}

	@PostConstruct
	public void initFirebase() {
		try {
			FileInputStream serviceAccount = new FileInputStream("src/main/resources/serviceAccountKey.json");
			FirebaseOptions options = FirebaseOptions.builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.build();
			FirebaseApp.initializeApp(options);
			System.out.println("✅ Firebase initialized successfully");
		} catch (Exception e) {
			System.err.println("❌ Firebase initialization failed: " + e.getMessage());
		}
	}
}
