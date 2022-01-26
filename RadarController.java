package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


@RestController
@Slf4j
public class RadarController {

    
   /*
     * @Description // path="/AeroSense" POST
     * @Param * @param: request
     * @return java.lang.String 
     **/
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/AeroSense", method = RequestMethod.POST)
    public String AeroSense(HttpServletRequest request) {
        /*Radar Request*/
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            BufferedInputStream byteOutputStream = new BufferedInputStream(inputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int a;
            while ((a = byteOutputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, a);
            }
            //String to utf-8
            String s = byteArrayOutputStream.toString("utf-8");
            /*split request*/
            String[] Map = s.split(",");
            /*tag*/
            switch (Map[0]) {
                case "KeepAlive"://KeepAlive
                    log.info("Receive AeroSense KeepAlive Request, ID:" + Map[1] + ", Version:" + Map[2]);
                    break;
                case "FallDetect"://FallDetect
                    log.info("Receive AeroSense FallDetect Request, ID:" + Map[1] + ", Version:" + Map[2]);
                    break;
                case "HeatMap": //HeatMap
                    log.info("Receive AeroSense HeatMap Upload, ID:" + Map[1] + ", Status：" + Map[2]);
                    break;
                case "Invade": //Invade
                    log.info("Receive AeroSense Invade, ID:" + Map[1] + ", Status：" + Map[2]);
                    break;
                default:
                    return "OK";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "OK";
        }
    }
}
