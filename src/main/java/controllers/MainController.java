package controllers;

import java.io.InputStream;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.next2023.cloud_service.services.AwsConfigService;
 
@Controller
public class MainController {
 
    @Inject
    AwsConfigService awsConfigService;

    @GetMapping("")
    public String viewHomePage() {
        return "upload";
    }
    
    @PostMapping("/upload")
    public String handleUploadForm(Model model, String description,
        
        @RequestParam("file") MultipartFile multipart) {
        String fileName = multipart.getOriginalFilename();
         
        System.out.println("Description: " + description);
        System.out.println("filename: " + fileName);
         
        String message = "";
         
        try {
            awsConfigService.realizarConexaoComS3();
            awsConfigService.putObject(fileName, multipart.getInputStream(), null);
            message = "Your file has been uploaded successfully!";
        } catch (Exception ex) {
            message = "Error uploading file: " + ex.getMessage();
        }
         
        model.addAttribute("message", message);
         
        return "message";              
    }

}
