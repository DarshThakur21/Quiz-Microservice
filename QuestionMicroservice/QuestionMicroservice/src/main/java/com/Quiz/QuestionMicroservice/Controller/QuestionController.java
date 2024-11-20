package com.Quiz.QuestionMicroservice.Controller;


import com.Quiz.QuestionMicroservice.Model.Question;
import com.Quiz.QuestionMicroservice.Model.QuestionDTO;
import com.Quiz.QuestionMicroservice.Service.QuestionService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {


    @Autowired
//    PdfParsingService pdfParsingService;

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/allquestions")
    public List<Question> getAllques(){
//        return "all questions";
        return questionService.getAllQuestion();
    }

    @GetMapping("/byid/{_id}")
    public Question getById(@PathVariable ObjectId _id){
        return questionService.findBYId(_id);
    }

    @GetMapping("/category/{category}")
    public List<Question> getByCategory(@PathVariable String category){
        List<Question> catQ=questionService.findByCategory(category);
        return  catQ;

    }

    @PostMapping
   public  Question saveQuestion(@RequestBody Question req){
        return questionService.saveQuestion(req);
    }


//    generate
    @GetMapping("/generate")
    public ResponseEntity<List<ObjectId>> getQuestionForQuiz(@RequestParam String category, @RequestParam Integer numQuestion){
        return questionService.getQuestionForQuiz(category,numQuestion);
    }
//it will return the quiz in the format of question wrt their ids so that user can play

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionDTO>> getQuestionFromId(@RequestBody List<ObjectId> qIds){
        return  questionService.getQuestionFromId(qIds);
    }





//    implementation standby
//    @PostMapping("/uploadpdf")
//    public ResponseEntity<String> uploadPdf(@RequestParam("file")MultipartFile file) throws IOException {
//        File tempFile = new File("D:\Project2\QuizMs\quizapp\temp" + file.getOriginalFilename());
//        file.transferTo(tempFile);
//        File pdfFile=convertMultipartFileToFile(file);
//        List<Question> questions=pdfParsingService.parsePdf(pdfFile);
//
//        questionService.saveAllQuestion(questions);
//
//        return new ResponseEntity<>("question saved success", HttpStatus.OK);
//    }

//@PostMapping("/uploadpdf")
//public ResponseEntity<String> uploadPdf(@RequestParam("file") MultipartFile file) throws IOException {
//    // Check if the file is a PDF
//    if (!file.getContentType().equals("application/pdf")) {
//        return new ResponseEntity<>("Invalid file type. Please upload a PDF.", HttpStatus.BAD_REQUEST);
//    }
//
//    // Define the path for the temporary directory
//    String tempDirPath = "D:/Project2/QuizMs/quizapp/temp/";
//    File tempDir = new File(tempDirPath);
//    if (!tempDir.exists()) {
//        tempDir.mkdirs();
//    }
//
//    File tempFile = new File(tempDirPath + file.getOriginalFilename());
//    file.transferTo(tempFile);
//
//    // Try to load and parse the PDF
//    try (PDDocument document = PDDocument.load(tempFile)) {
//        List<Question> questions = pdfParsingService.parsePdf(document);
//        questionService.saveAllQuestion(questions);
//        return new ResponseEntity<>("Questions saved successfully", HttpStatus.OK);
//    } catch (IOException e) {
//        e.printStackTrace();  // Log the exception
//        return new ResponseEntity<>("Failed to parse the PDF. Ensure it is a valid PDF file.", HttpStatus.BAD_REQUEST);
//    } finally {
//        // Optionally, delete the temp file if not needed after parsing
//        tempFile.delete();
//    }
//}
//
//
//
//
//
//
//    private File convertMultipartFileToFile(MultipartFile file) throws IOException {
//        File convFile = new File(file.getOriginalFilename());
//        file.transferTo(convFile);
//        return convFile;
//    }


}
