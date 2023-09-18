package com.next2023.cloud_service.util;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;

//Incluindo as credenciais de um cliente para acesso ao bucket
@Configuration
public class AwsConfig {

   @Inject
    public ArmazenamentoProperties properties;

    public AWSCredentials credentials() {
        
        AWSCredentials credentials = new BasicAWSCredentials(properties.getAwsS3_accessKey(),properties.getAwsS3_secretKey());
               
        return credentials;
    }

   
}


    

        
                

        

