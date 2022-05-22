package com.example.mytoolbk;

import com.example.mytoolbk.entiy.BasicMemory;
import com.example.mytoolbk.service.BasicMemoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
class MyToolBkApplicationTests {


    @Autowired
    BasicMemoryService basicMemoryService;



//    @Test
    void contextLoads() throws IOException {

        System.out.println("你好");
        System.out.println(basicMemoryService);

        String path="D://shuge.txt";
        FileInputStream fs=new FileInputStream(new File(path));


        InputStreamReader is=new InputStreamReader(fs,"gbk");

        BufferedReader br=new BufferedReader(is);
        String line=null;
        while ( (line=br.readLine())!=null){

            int i = line.indexOf(" ");
            String right = line.substring(i+1);
            String left = line.substring(0, i);
//            System.out.println(left+","+right);

            BasicMemory entiy=new BasicMemory();
            entiy.setSymbol(left);
            entiy.setMeaning(right);
            entiy.setLable("num");
            basicMemoryService.save(entiy);

        }
        br.close();


    }

}
