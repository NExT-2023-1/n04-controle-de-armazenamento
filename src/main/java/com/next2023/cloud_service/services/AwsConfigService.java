package com.next2023.cloud_service.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.next2023.cloud_service.util.ArmazenamentoProperties;
import com.next2023.cloud_service.util.AwsConfig;

//Incluindo as credenciais de um cliente para acesso ao bucket
@Service
public class AwsConfigService {

    @Inject
    public AwsConfig awsConfig;

    public AmazonS3 amazonS3Client;
    
    //public AwsConfigService(){
    //    this.amazonS3Client = this.amazonS3();
    //}

   
    @Bean // conectando ao  S3
    private AmazonS3 amazonS3() {
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsConfig.credentials()))
                .withRegion(Regions.US_EAST_1)
                .build();
        this.amazonS3Client = s3client;    
        return s3client;

    }  // com estas classes já acessamos o bucket para executar os crud

    // ----- CRUD Bucket

    // Retorna a lista de Buckets
    public List<Bucket> listBuckets(){
        List<Bucket> bucketList = amazonS3Client.listBuckets();
        return bucketList;
    }

    // ----- CRUD Objetos (Arquivos)

    // CREATE - Criando o upload de arquivos - "PUT"
    public PutObjectResult putObject(String bucketName, String fileName, InputStream input, ObjectMetadata metadata){
        PutObjectRequest request = new PutObjectRequest(bucketName, fileName, input, metadata);
        PutObjectResult fileS3 = amazonS3Client.putObject(request);
        return fileS3;
    }

    // READ - Retorna o arquivo do bucket (download) e salva no raiz do projeto
    public InputStream getObject(String bucketName, String fileName) throws IOException{
        S3Object s3object = amazonS3Client.getObject(bucketName, fileName);
        return s3object.getObjectContent();

        // S3ObjectInputStream inputStream = s3object.getObjectContent();
        // Transforma o arquivo que tá no buck (InputStream) em um arquivo na raiz do projeto.
        //FileUtils.copyInputStreamToFile(inputStream, new File("." + File.separator + fileName));
    }

    // DELETE - apaga um arquivo dentro do bucket
    public void deleteObject(String bucketName, String fileName){
        amazonS3Client.deleteObject(bucketName,fileName);
    }

    // Main criado para testes - Exibe o valor no terminal.
    public static void main(String[] args) throws IOException {
        String bucketName = "n04next";
        String fileName = "testeUploadNEXT.txt";
        String filePath = "C:\\Users\\marco\\Documents\\" + fileName;
    
        AwsConfigService ac = new AwsConfigService();
        ac.amazonS3();
        
        // PUT
        //ac.putObject(bucketName, fileName, filePath);

        // DELETE
        //ac.deleteObject(bucketName,fileName);
        //ac.getObject(bucketName, fileName);
    }


}
