package com.leminhosdev.s3amazon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;

import java.net.URI;

@Configuration
public class AwsConfig {

    @Value("${aws.endpoint}")
    private String endpoint;

    @Value("${aws.access-key}")
    private String accessKey;

    @Value("${aws.secret-key}")
    private String secretKey;

    @Bean
    public S3Client s3Client() {

        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(accessKey, secretKey);

        return S3Client.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials))
                .forcePathStyle(true)
                .endpointOverride(URI.create(endpoint))
                .region(Region.US_EAST_2)
                .serviceConfiguration(S3Configuration.builder().build())
                .build();
    }
}
