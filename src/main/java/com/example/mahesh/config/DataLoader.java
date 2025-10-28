package com.example.mahesh.config;

import com.example.mahesh.model.Mahesh;
import com.example.mahesh.repository.MaheshRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private MaheshRepository maheshRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Check if data already exists
        if (maheshRepository.count() == 0) {
            System.out.println("Loading sample data...");
            
            // Insert sample records
            maheshRepository.save(new Mahesh(
                "Mahesh Kumar", 
                "mahesh.kumar@example.com", 
                "+91-9876543210", 
                "Mumbai, Maharashtra"
            ));
            
            maheshRepository.save(new Mahesh(
                "Mahesh Sharma", 
                "mahesh.sharma@example.com", 
                "+91-9876543211", 
                "Delhi, India"
            ));
            
            maheshRepository.save(new Mahesh(
                "Mahesh Patel", 
                "mahesh.patel@example.com", 
                "+91-9876543212", 
                "Ahmedabad, Gujarat"
            ));
            
            maheshRepository.save(new Mahesh(
                "Mahesh Reddy", 
                "mahesh.reddy@example.com", 
                "+91-9876543213", 
                "Hyderabad, Telangana"
            ));
            
            maheshRepository.save(new Mahesh(
                "Mahesh Singh", 
                "mahesh.singh@example.com", 
                "+91-9876543214", 
                "Jaipur, Rajasthan"
            ));
            
            maheshRepository.save(new Mahesh(
                "Mahesh Verma", 
                "mahesh.verma@example.com", 
                "+91-9876543215", 
                "Lucknow, Uttar Pradesh"
            ));
            
            maheshRepository.save(new Mahesh(
                "Mahesh Gupta", 
                "mahesh.gupta@example.com", 
                "+91-9876543216", 
                "Kolkata, West Bengal"
            ));
            
            maheshRepository.save(new Mahesh(
                "Mahesh Rao", 
                "mahesh.rao@example.com", 
                "+91-9876543217", 
                "Bangalore, Karnataka"
            ));
            
            maheshRepository.save(new Mahesh(
                "Mahesh Iyer", 
                "mahesh.iyer@example.com", 
                "+91-9876543218", 
                "Chennai, Tamil Nadu"
            ));
            
            maheshRepository.save(new Mahesh(
                "Mahesh Nair", 
                "mahesh.nair@example.com", 
                "+91-9876543219", 
                "Kochi, Kerala"
            ));
            
            System.out.println("Sample data loaded successfully!");
            System.out.println("Total records: " + maheshRepository.count());
        } else {
            System.out.println("Data already exists. Skipping sample data load.");
        }
    }
}