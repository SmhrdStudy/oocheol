package com.smart.project.web.home.act;

import com.smart.project.common.vo.InternCookie;
import com.smart.project.filter.CookieAutoLoginFilter;
import com.smart.project.proc.Test;
import com.smart.project.web.home.vo.StudyTestVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeTestAct {

        public final Test test;

        @RequestMapping("/test")
        public String test(Model model, InternCookie internCookie, HttpServletRequest request) {
            log.error("test===>{}", internCookie);


//            model.addAttribute("test", "testsstes");

            /*log.error("***************************************");
            List<StudyTestVO> list = test.sqlFind();
            for (StudyTestVO dt : list) {
                log.error("{}//{}", dt.getNum(), dt.getId());
            }
            log.error("{}", list);
            log.error("***************************************");

            model.addAttribute("test2",list);*/

            return "test";
        }
}
