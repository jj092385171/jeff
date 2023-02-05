package com.campingmapping.team4.spring.utils.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.common.collect.Lists;

public class GoogleFileUtil {

    public static void main(String[] args) throws IOException {
        String filepath = uploadFile("測試1", "morari");
        System.out.println("網址：：：：" + filepath);
    }

    public static String uploadFile(String fileName,String bucketName) throws IOException{
    // 要上傳的文件
    String filePath = "F:/圖片/1.jpg";
    //Google 服務的金鑰
    InputStream inputStream = GoogleFileUtil.class.getResourceAsStream("/keystore/googlekey.json");
    GoogleCredentials credentials = GoogleCredentials.fromStream(inputStream)
    // GoogleCredentials credentials= GoogleCredentials.fromStream(new FileInputStream("../src/main/resourcrs/keystore/googlekey.json"))
    .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
    // 製作帳號物件
    Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
    // 檔案轉為byte
    byte[] bytes = Files.readAllBytes(Paths.get(filePath));
    //上傳到指定的雲端儲存中
    BlobId blobId=BlobId.of(bucketName,fileName);
    BlobInfo blobInfo=BlobInfo.newBuilder(blobId).build();
    Blob blob = storage.create(blobInfo, bytes);
    //將上傳的文件類型改為 image/jpg
    blob.toBuilder().setContentType("image/jpg").build().update();
    
    //返回公開網址
    return "https://storage.googleapis.com/" + bucketName + "/" + fileName;
    }
}