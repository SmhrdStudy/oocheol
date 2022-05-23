package com.smart.project.web.home.act;

import com.smart.project.common.vo.InternCookie;
import com.smart.project.component.CommonCodeComponent;
import com.smart.project.component.data.CodeObject;
import com.smart.project.proc.Test;
import com.smart.project.web.home.vo.TestVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class HomeAct {

	@Autowired
	CommonCodeComponent commonCodeComponent;

	@Autowired Test test;

	@RequestMapping("/")
	public String home(Model model, InternCookie cookie){

		List<CodeObject.Code> data1 = commonCodeComponent.getCodeList("style_f");
		model.addAttribute("data", data1);

		for(CodeObject.Code c : data1){
			log.error("{}",c);
		}

		Map<String, CodeObject> data = commonCodeComponent.getAll();

		return "index";
	}

	@RequestMapping("/join")
	public String join(){
		log.error("{}",commonCodeComponent.getCodeList("style_f"));
		return "join";
	}

	@RequestMapping("/data")
	@ResponseBody
	public String homeData(){
		return "index";
	}
}
