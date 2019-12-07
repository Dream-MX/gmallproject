package com.leixiang.gmall.manage;


import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.IOException;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void fileLoadtest() throws IOException, MyException {

        String file = this.getClass().getResource("/tracker.conf").getFile();
        ClientGlobal.init(file);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer connection = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(connection, null);
        String orginalFilename="E:\\photo\\18074.jpg";
        String[] jpgs = storageClient.upload_file(orginalFilename, "jpg", null);
        for (int i = 0; i < jpgs.length; i++) {
            String jpg = jpgs[i];
            System.out.println(jpg);
        }


    }


}
