package com.sparta.plusweek.infra.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
@Slf4j
public class S3Util {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    public String uploadImage(MultipartFile multipartFile) {
        String fileName = createFileName(multipartFile.getOriginalFilename());
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(multipartFile.getSize());
        metadata.setContentType(multipartFile.getContentType());
        try {
            amazonS3Client.putObject(bucketName, fileName,
                multipartFile.getInputStream(), metadata);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return amazonS3Client.getUrl(bucketName, fileName).toString();
    }

    public void deleteImage(String imageUrl) {
        String fileName = getFileNameFromImageUrl(imageUrl);
        if (fileName.isBlank() || !amazonS3Client.doesObjectExist(bucketName, fileName)) {
            throw new IllegalArgumentException("해당 파일을 찾을 수 없습니다.");
        }
        amazonS3Client.deleteObject(bucketName, fileName);
    }

    public String getFileNameFromImageUrl(String imageUrl) {
        return imageUrl.substring(imageUrl.lastIndexOf(".com/") + 5);
    }

    private String createFileName(String fileName) {
        return UUID.randomUUID().toString().concat(fileName);
    }

}
