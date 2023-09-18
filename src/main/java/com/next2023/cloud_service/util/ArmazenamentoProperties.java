package com.next2023.cloud_service.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//Incluindo as credenciais de um cliente para acesso ao bucket
@Configuration
@PropertySource("application.properties")
public class ArmazenamentoProperties {
    @Value("${awsS3.accessKey}")
    private String awsS3_accessKey;

    @Value("${awsS3.secretKey}")
    private String awsS3_secretKey;

    public String getAwsS3_accessKey() {
        return awsS3_accessKey;
    }

    public String getAwsS3_secretKey() {
        return awsS3_secretKey;
    }

}
