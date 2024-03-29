package com.leixiang.gmall.manage.controller;


import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName FileUploadController
 * @create 2019-12-06 23:31
 * @Description TODO
 */
@RestController
@CrossOrigin
public class FileUploadController {

    @Value("${tracker.server}")
    private String fileUrl;

    @PostMapping("/fileUpload")
    public String uploadFile(@RequestBody MultipartFile file) throws IOException, MyException {
        String fileUploadUrl="";

        String trackerPath = this.getClass().getResource("/tracker.conf").getFile();
        ClientGlobal.init(trackerPath);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer connection = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(connection, null);

        String orginalFilename=file.getOriginalFilename();
        String extName = StringUtils.substringAfterLast(orginalFilename, ".");

        String[] jpgs = storageClient.upload_file(file.getBytes(), extName, null);
        fileUploadUrl=fileUrl;
        for (int i = 0; i < jpgs.length; i++) {
            String s = jpgs[i];
            fileUploadUrl += "/"+s;

        }

        return fileUploadUrl;
    }
}
