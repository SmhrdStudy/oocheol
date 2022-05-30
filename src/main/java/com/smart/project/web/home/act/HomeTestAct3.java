package com.smart.project.web.home.act;

import com.smart.project.component.CommonCodeComponent;
import com.smart.project.component.data.CodeObject;
import com.smart.project.proc.Test;
import com.smart.project.web.home.vo.StudyTestVO;
import com.smart.project.web.home.vo.TestVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeTestAct3 {

        private final CommonCodeComponent commonCodeComponent;

        public final Test test;

//        @RequestMapping("/test3")
//        public String test(Model model, HttpServletResponse response) {
//
//            List<CodeObject.Code> data = commonCodeComponent.getCodeList("style_f");
//            model.addAttribute("data", data);
//
//            List<StudyTestVO> data2 =  test.sqlFind();
//            model.addAttribute("data2", data2);
//
//            for(CodeObject.Code c : data){
//                log.error("{}",c);
//            }
//
//            return "test3";
//        }

    @RequestMapping("/test3")
    public String test(Model model, HttpServletResponse response) {

        List<CodeObject.Code> data = commonCodeComponent.getCodeList("style_f");
        model.addAttribute("data", data);

        return "test3";
    }

    @PostMapping("/test4")
    @ResponseBody
    public List<CodeObject.Code> test1(Model model, HttpServletResponse response) {

//        List<CodeObject.Code> data = commonCodeComponent.getCodeList("style_f");
        List<CodeObject.Code> data = commonCodeComponent.getCodeList("wishLoc");
//        model.addAttribute("data", data);

        return data;
    }

    @RequestMapping("/joindata")
    @ResponseBody
    public List<CodeObject.Code> joinData(){
        List<CodeObject.Code> data = commonCodeComponent.getCodeList("wishLoc");

        return data;
    }

    @RequestMapping("/join2")
    public String join(){
        return "join2";
    }

}
