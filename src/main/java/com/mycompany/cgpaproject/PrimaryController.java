package com.mycompany.cgpaproject;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {
    @FXML
    private TextField nameField;
    
    @FXML
    private TextField creditField;
    
    @FXML
    private TextField marksField;
    
    @FXML
    private TextArea outputArea;
    
    String[] names = new String[100];
    int[] credits = new int[100];
    String[] grades = new String[100];
    double[] gradePoints = new double[100];
    int count = 0;
    
    @FXML
    private void addCourse() {
        String name = nameField.getText();
        int credit = Integer.parseInt(creditField.getText());
        double marks = Double.parseDouble(marksField.getText());
        String grade;
        double point;
        
        if (marks >= 80){
            grade = "A+";
            point = 4.00;
        } else if (marks >= 75) {
            grade = "A";
            point = 3.75;
        } else if (marks >= 70) {
            grade = "A-";
            point = 3.50;
        } else if (marks >= 65) {
            grade = "B+";
            point = 3.25;
        } else if (marks >= 60) {
            grade = "B";
            point = 3.00;
        } else if (marks >= 55) {
            grade = "B-";
            point = 2.75;
        } else if (marks >= 50) {
            grade = "C+";
            point = 2.50;
        } else if (marks >= 45) {
            grade = "C";
            point = 2.25;
        } else if (marks >= 40) {
            grade = "D";
            point = 2.00;
        } else{
            grade = "F";
            point = 0.00;
        }
        
        names[count] = name;
        credits[count] = credit;
        grades[count] = grade;
        gradePoints[count] = point;
        
        count++;
        
        nameField.clear();
        creditField.clear();
        marksField.clear();
        showCourses();
    }
    
    @FXML
    private void showCourses() {
        outputArea.clear();
        
        int totalCredits = 0;
        double totalPoints = 0;
        
        for (int i = 0; i < count; i++) {
            outputArea.appendText(names[i] + " | Credit: " + credits[i] + " | Grade: " + grades[i] + " | Point: " + gradePoints[i] + "\n");
            totalCredits += credits[i];
            totalPoints += credits[i] * gradePoints[i];
        }
        double cgpa = totalPoints / totalCredits;
        
        outputArea.appendText("\nTotal Credits: " + totalCredits);
        outputArea.appendText(String.format("\nCGPA: %.2f", cgpa));
    }
}