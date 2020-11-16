package ourbox.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ourbox.common.vo.MemberVO;
import ourbox.member.service.IMemberService;

@RequestMapping("/ourbox")
@Controller
public class MemberLoginController {
   private static final long serialVersionUID = 1L;
   private static final Logger logger = LoggerFactory.getLogger(MemberLoginController.class);

   @Autowired
   private IMemberService memberService;
   
   @RequestMapping(path="/login")
   public String login() {
	   return "main/login";
   }

   @RequestMapping(path="/loginVali")
	public String login(String id, String pass, HttpSession session, Model model) {
	   
	   if(id.equals("ourbox")&&pass.equals("ourbox")||id.equals("ㅐㅕ규ㅐㅌ")&&pass.equals("ㅐㅕ규ㅐㅌ")) {
		   logger.debug("id : {}", id);
		   logger.debug("pass : {}", pass);
		   
		   return "ourbox/ourboxmanager";   
	   }else {
		   MemberVO mv = new MemberVO(id, pass);
		   MemberVO vo = memberService.loginMember(mv);	//로그인 성공한 멤버 객체

		   if (vo != null && vo.getMem_pass().equals(pass)) { // 올바르게 로그인
			   session.setAttribute("vo", vo); 	// session에 로그인값을 담는다.
			   return "ourbox/ourboxmember";
			   
			} else if (vo == null) { // 아이디 또는 비밀번호 틀림
				model.addAttribute("msg", "아이디와 패스워드를 확인해주세요.");
				return "main/login"; //-> main/login.jsp
				
			} else {
				model.addAttribute("msg", "탈퇴한 회원입니다.");
				return "main/login"; //-> main/login.jsp
			}
	   }
	}
   
   @RequestMapping(path = "/memProfile")
	public String memProfile(String memId, Model model) {
	   logger.debug("memId : {}", memId);
	   MemberVO member = memberService.detailMember(memId);
	   model.addAttribute("member", member);
		
	   return "ourbox/ourboxmember";
	}
   
   
}