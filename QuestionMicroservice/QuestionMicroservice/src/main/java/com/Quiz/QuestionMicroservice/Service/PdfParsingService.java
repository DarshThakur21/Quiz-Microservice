package com.Quiz.QuestionMicroservice.Service;//standby

//package com.quizmicroservice.quizapp.Service;
//
//import com.quizmicroservice.quizapp.Model.Question;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class PdfParsingService {
//
////    creating a new service to implment the quiz for the pdf data
//    public List<Question> parsePdf(PDDocument pdfFile){
//        List<Question> questions=new ArrayList<>();
//
//        try (PDDocument document=PDDocument.load(pdfFile)){
//            PDFTextStripper pdfTextStripper=new PDFTextStripper();
//            String text=pdfTextStripper.getText(document);
//
//            String[] questionBlock=text.split("Questions:");
//            for(String block:questionBlock){
//                if(block.trim().isEmpty()) continue;
//
//                String questionText=extractQuestion(block);
//                String[] options=extractOptions(block);
//                String answer=extractAnswer(block);
//                String difficultyLevel = "Easy";
//                String category = "Java";
//
//
//                Question question=new Question(questionText,options,answer,difficultyLevel,category);
//                questions.add(question);
//
//
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return  questions;
//
//    }
//
//    private String[] extractOptions(String block) {
//        int optionsStart = block.indexOf("Options:") + "Options:".length();
//        int answerStart = block.indexOf("Answer:");
//
//        // Extract the options text and split by commas
//        if (optionsStart >= 0 && answerStart > optionsStart) {
//            String optionsText = block.substring(optionsStart, answerStart).trim();
//            return optionsText.split(",\\s*"); // Split by comma and optional whitespace
//        }
//        return new String[0];
//    }
//
//    private String extractAnswer(String block) {
//
//        int answerStart = block.indexOf("Answer:") + "Answer:".length();
//
//        // Extract the answer text
//        if (answerStart > 0) {
//            return block.substring(answerStart).trim();
//        }
//        return "";
//
//    }
//
//    private String extractQuestion(String block) {
//        int questionStart=block.indexOf("Question:")+"Question:".length();
//        int optionStart=block.indexOf("Options:");
//        if (questionStart >= 0 && optionStart > questionStart) {
//            return block.substring(questionStart, optionStart).trim();
//        }
//        return "";
//    }
//
//
//}
