package com.smart.project.web.home.act;

import com.smart.project.component.CommonCodeComponent;
import com.smart.project.component.data.CodeObject;
import com.smart.project.proc.Test;
import com.smart.project.util.CookieUtil;
import com.smart.project.web.home.vo.JoinVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

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
    public Map<String, Object> test1(@RequestBody Map param) {
        Map<String, Object> result = new HashMap<>();
        String keyData = String.valueOf(param.get("key"));
        log.error("key===>{}", keyData);
        String temp = "i,b,k,g,f,h,e,z,j,p,o,n,l,d,c,a,m,q";
        if (keyData.equals("all")) {
            keyData = temp;
            log.error("keyAll==>{}", keyData);
        }

        String[] key = keyData.split(",");

        List<String> keyList = new ArrayList<>();
        if (StringUtils.isNotEmpty(keyData)) {
            keyList = Arrays.asList(keyData.split(","));
        }
//        log.error(key+"");
        log.error(keyList + "");

        List<CodeObject.Code> data = commonCodeComponent.getCodeList("wishLoc");

        if (data != null) {
            for (CodeObject.Code codeData : data) {
                String keyArr = keyList.stream().filter(a -> a.equals(codeData.getCode())).findAny().orElse(null);
                if (StringUtils.isNotEmpty(keyArr)) {
//                    log.error("keyArr===>{}", keyArr);
                    codeData.setChecked(true);
                } else {
                    codeData.setChecked(false);
                }
//                for(int i = 0; i < key.length; i++){
//                    if(codeData.getCode().equals(key[i])){
//                        log.error("key===>{}", key[i]);
//                    }
//                }
            }
//            log.error("{}", data);
        }
        result.put("data", data);


        return result;
    }

    @PostMapping("/loc")
    @ResponseBody
    public Map<String, Object> loc(@RequestBody Map param) {
        Map<String, Object> result = new HashMap<>();
        String keyData = String.valueOf(param.get("key"));
        log.error("key===>{}", keyData);
//        String temp = "i,b,k,g,f,h,e,z,j,p,o,n,l,d,c,a,m,q";
//        if (keyData.equals("all")){
//            keyData = temp;
//            log.error("test==>{}", keyData);
//        }

        String[] key = keyData.split(",");

        List<String> keyList = new ArrayList<>();
        if (StringUtils.isNotEmpty(keyData)) {
            keyList = Arrays.asList(keyData.split(","));
        }
//        log.error(key+"");
        log.error(keyList + "");

        List<CodeObject.Code> data = commonCodeComponent.getCodeList("homeTownLocal");

        if (data != null) {
            for (CodeObject.Code codeData : data) {
                String keyArr = keyList.stream().filter(a -> a.equals(codeData.getCode())).findAny().orElse(null);
                if (StringUtils.isNotEmpty(keyArr)) {
                    log.error("keyArr===>{}", keyArr);
                    codeData.setChecked(true);
                } else {
                    codeData.setChecked(false);
                }
//
            }
//            log.error("{}", data);
        }
        result.put("data", data);


        return result;
    }

    @RequestMapping("/joinComplete")
    public void joinComplete(@ModelAttribute JoinVO vo, Model model, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        int cnt = test.joinComplete(vo);
        PrintWriter out = response.getWriter();
        log.error("pw==>>{}", vo.getPw());
        log.error("birth==>>{}", vo.getBirth());
        log.error("loc==>>{}", vo.getLocWantKey());
        log.error("test");

        if (cnt > 0) {
            List<JoinVO> result = test.memberFind();
            model.addAttribute("member", result);
            out.println("<script>alert('계정이 등록 되었습니다'); location.href='/joinSuccess';</script>");

        } else {
            out.println("<script>alert('실패'); location.href='/join';</script>");

        }
        out.flush();


    }

    @RequestMapping("/joinSuccess")
    public void joinSuccess(JoinVO vo) {
        test.joinComplete(vo);
    }


    @RequestMapping("/joindata")
    @ResponseBody
    public List<CodeObject.Code> joinData() {
        List<CodeObject.Code> data = commonCodeComponent.getCodeList("wishLoc");

        return data;
    }


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/loginComplete")
    public String loginComplete(JoinVO vo, HttpServletRequest request, HttpServletResponse response) {


        log.error("test" + vo.getId());
        HttpSession session = request.getSession();
        List<JoinVO> result = test.login(vo);

        log.error("loginComplete");

        if (result.size() > 0) {
            CookieUtil.createCookie(response, "id", vo.getId());

            session.setAttribute("login", result.get(0));
            log.error("로그인 성공");
            return "redirect:/main";

        } else {
            log.error("로그인 실패");
            return "redirect:/login";
        }
    }


    @RequestMapping("/main")
    public void main() {
    }

    @RequestMapping("/find_id")
    public void find_id() {

    }

    @RequestMapping("/sessionTest")
    public String sessionTest(HttpServletRequest request, Model model, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        log.error("test1");
        HttpSession session = request.getSession();
        log.error("test2");
        JoinVO vo = (JoinVO) session.getAttribute("login");
        try {
            PrintWriter out = response.getWriter();

            if (vo != null) {
                log.error("test3 " + vo);
                model.addAttribute("login", vo);
                return "forward:/sessionTest1";
            } else {
                out.println("<script>alert('로그인이 필요합니다!'); location.href='/login';</script>");
                return "/login";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/sessionTest1")
    public void sessionTest1() {

    }

    @RequestMapping("/sessionDelete")
    public String sessionDelete(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:/main";
    }

    @RequestMapping("/cookieDelete")
    public String cookieDelete(HttpServletRequest request, HttpServletResponse response){

        CookieUtil.deleteCookie(request, response, "id");

        return "redirect:/login";}




}
