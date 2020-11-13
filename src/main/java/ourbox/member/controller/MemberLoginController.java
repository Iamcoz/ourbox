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
   private IMemberService memService;
   
   @RequestMapping(path="/login")
	public String login(String id, String pw, HttpSession session, Model model) {
	   
	   if(id.equals("ourbox")&&pw.equals("ourbox")||id.equals("ㅐㅕ규ㅐㅌ")&&pw.equals("ㅐㅕ규ㅐㅌ")) {
		   return "ourbox/ourboxmanager";   
	   }else {
		   MemberVO mv = new MemberVO(id, pw);
		   MemberVO vo = memService.loginMember(mv);	//로그인 성공한 멤버 객체

		   logger.debug("vo : {}", vo);
		   if (vo != null && vo.getMem_pass().equals(pw)) { // 올바르게 로그인
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
}