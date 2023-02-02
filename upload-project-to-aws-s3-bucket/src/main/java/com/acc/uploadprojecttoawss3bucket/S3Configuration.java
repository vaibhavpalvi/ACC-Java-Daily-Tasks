package com.acc.uploadprojecttoawss3bucket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Configuration {

	@Value("${accesskey}")
	private String accesskey;

	@Value("${secretKey}")
	private String secretKey;

	@Value("${region}")
	private String region;

	@Bean
	public AmazonS3 s3() {
		AWSCredentials credentials = new BasicAWSCredentials(accesskey, secretKey);

		return AmazonS3ClientBuilder.standard().withRegion(region)
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
	}
}
