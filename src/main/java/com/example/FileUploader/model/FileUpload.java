package com.example.FileUploader.model;

public class FileUpload {
    private String id;
    private String name;
    private String email;
    private String content;
    private String fileName;

    public FileUpload() {
        // Default constructor required for Firestore serialization/deserialization
    }

    public FileUpload(String name, String email, String content, String fileName) {
        this.name = name;
        this.email = email;
        this.content = content;
        this.fileName = fileName;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
