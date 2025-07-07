package com.example.FileUploader.service;

import com.example.FileUploader.model.FileUpload;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirebaseService {

    private static final String COLLECTION_NAME = "resumes";

    public void saveResume(FileUpload resume) throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> future = db.collection(COLLECTION_NAME).add(resume);
        DocumentReference docRef = future.get();
        System.out.println("✅ Resume saved with ID: " + docRef.getId());
    }

    public List<FileUpload> getAllResumes() throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<FileUpload> resumes = new ArrayList<>();

        for (QueryDocumentSnapshot doc : documents) {
            FileUpload resume = doc.toObject(FileUpload.class);
            resume.setId(doc.getId()); // Set the Firestore doc ID into the Resume object
            resumes.add(resume);
        }

        return resumes;
    }

    public void deleteResume(String id) throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        db.collection(COLLECTION_NAME).document(id).delete().get();
        System.out.println("🗑️ Resume deleted with ID: " + id);
    }
}
