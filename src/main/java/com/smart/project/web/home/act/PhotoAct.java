package com.smart.project.web.home.act;

import com.smart.project.util.ClientUtil;
import com.smart.project.util.CookieUtil;
import com.smart.project.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.util.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PhotoAct {

    final int[] PHOTO_HEIGHT = {200, 300, 600, 900};
    final int[] PHOTO_WIDTH = {200, 400, 800, 1200};

    @RequestMapping("/upload")
    public String saveFile(@RequestParam("file") MultipartFile file ,HttpServletRequest request) throws Exception {

        log.error("file name : " + file.getOriginalFilename());
        log.error("file size : " + file.getSize());

        Map<String, String> cookieMap = ClientUtil.getCurrentCookie(request);
        String id = cookieMap.get("id");
        String path = "/tmp/" + id + "/";
        File Folder = new File(path);

        if (!Folder.exists()) {
            try{
                Folder.mkdir(); //폴더 생성
                log.error("폴더 생성");
            }
            catch(Exception e){
                e.getStackTrace();
            }

        }else {
            log.error("이미 폴더 존재");
        }

        // 원본 저장
        try(
                FileOutputStream fos = new FileOutputStream(path + "original.jpg");
                InputStream is = file.getInputStream();
        ){

            String originFilename = file.getOriginalFilename();
            String extName = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
            int readCount = 0; // 읽음 성공 여부 저장용
            byte[] buffer = new byte[1024]; // 1024 바이트씩 읽어서 파일 저장

            while((readCount = is.read(buffer))!=-1){
                fos.write(buffer,0,readCount);
            }


        }catch(Exception ex){
            throw new RuntimeException("file Save Error");
        }

        // 변환 이미지 저장(4개)
        for (int i=0; i<4;i++){
        try(
//                FileOutputStream fos = new FileOutputStream(path + file.getOriginalFilename());
                InputStream is = file.getInputStream();
        ){
                BufferedImage outputimage = ImageUtil.resize(is,PHOTO_WIDTH[i],PHOTO_HEIGHT[i]);
                File outputfile = new File(path+"resize("+PHOTO_HEIGHT[i]+"x"+PHOTO_WIDTH[i]+").jpg");
                ImageIO.write(outputimage, "jpg", outputfile);

        }catch(Exception ex){
            throw new RuntimeException("file Save Error");
        }
        }
        return "redirect:/main";
    }

    @RequestMapping("/photo")
    public void photo(){
    }

    @RequestMapping("/show")
    public void show(Model model, HttpServletRequest request) throws Exception {
        Map<String, String> cookieMap = ClientUtil.getCurrentCookie(request);
        String id = cookieMap.get("id");

        model.addAttribute("id", id);

    }

//    @RequestMapping("/seq")
//    public void seq(){
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String securePassword = encoder.encode("testtest");
//
//        log.error("encoding==>{}", securePassword);
//
//        boolean test = encoder.matches("testtest","testtest");
//        log.error("encoding==>{}", test);
//
//    }



}
