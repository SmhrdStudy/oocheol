package com.smart.project.web.home.act;

import com.smart.project.common.vo.InternCookie;
import com.smart.project.component.CommonCodeComponent;
import com.smart.project.component.data.CodeObject;
import com.smart.project.proc.Test;
import com.smart.project.util.CookieUtil;
import com.smart.project.web.home.vo.StudyTestVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeTestAct2 {

        private final CommonCodeComponent commonCodeComponent;

        public final Test test;

        @RequestMapping("/test2")
        public String test(Model model, InternCookie internCookie, HttpServletResponse response) {

            CookieUtil.createCookie(response, "USER_ID", "1");
            CookieUtil.createCookie(response, "EMP_NO", "emp_no=1234");
            CookieUtil.createCookie(response, "NAME", "3");




//            List<CodeObject.Code> data1 = commonCodeComponent.getCodeList("style_f");
//            model.addAttribute("data", data1);
//
//            for(CodeObject.Code c : data1){
//                log.error("{}",c);
//            }



            /*log.error("agent===");
            log.error("***************************************");
            List<StudyTestVO> list = test.sqlFind();
            for (StudyTestVO dt : list) {
                log.error("{}//{}", dt.getNum(), dt.getId());
            }
            log.error("{}", list);
            log.error("***************************************");*/


            return "test2";
        }
}
