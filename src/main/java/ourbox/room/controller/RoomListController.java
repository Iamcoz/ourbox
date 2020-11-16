package ourbox.room.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ourbox.common.vo.RoomVO;
import ourbox.room.service.IRoomService;

@RequestMapping("/ourbox")
@Controller
public class RoomListController {
	private static final long serialVersionUID = 1L;

	@Autowired
	private IRoomService roomService;

	@RequestMapping("/roomList")
	public String roomList(String memId, Model model) {// ourboxmember.jsp에서 넘겨준 로그인회원의 아이디 받아오기

		List<RoomVO> roomList = roomService.listRoom(memId); // mem_id로 참여중인 room의 정보list받아오기

		model.addAttribute("roomList", roomList);
		String msg = "";

		if (roomList == null) {
			msg = "실패";
			return "room/listRoom";
		} else {
			msg = "성공";
			return "room/listRoom";
		}
	}
}
