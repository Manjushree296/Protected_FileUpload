package com.example.FileUploader.controller;

import com.example.FileUploader.model.FileUpload;
import com.example.FileUploader.service.FirebaseService;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")  // Allows requests from frontend (e.g., localhost:5500 or 3000)
public class FileUploadController {

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping("/upload")
    public String uploadResume(@RequestParam("name") String name,
                               @RequestParam("resume") MultipartFile[] files) {
        try {
            Tika tika = new Tika();
            for (MultipartFile file : files) {
                String content = tika.parseToString(file.getInputStream());

                // You can later get actual email from auth or UI input
                FileUpload resume = new FileUpload(name, "email@example.com", content, file.getOriginalFilename());

                firebaseService.saveResume(resume);
            }
            return "{\"status\":\"success\", \"message\":\"All resumes saved\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\", \"message\":\"" + e.getMessage() + "\"}";
        }
    }

    @GetMapping("/resumes")
    public List<FileUpload> getAllResumes() {
        try {
            return firebaseService.getAllResumes();
        } catch (Exception e) {
            System.err.println("Error fetching resumes: " + e.getMessage());
            return List.of();  // Return empty list if error occurs
        }
    }

    @DeleteMapping("/resume/{id}")
    public String deleteResume(@PathVariable String id) {
        try {
            firebaseService.deleteResume(id);
            return "{\"status\":\"success\", \"message\":\"Resume deleted successfully\"}";
        } catch (Exception e) {
            return "{\"status\":\"error\", \"message\":\"" + e.getMessage() + "\"}";
        }
    }
}
