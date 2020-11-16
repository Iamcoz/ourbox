package ourbox.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ourbox.common.vo.NoticeVO;
import ourbox.notice.service.INoticeService;

@Controller
@RequestMapping("/ourbox")
public class NoticeListController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeListController.class);

	@Autowired
	private INoticeService noticeService;

	@RequestMapping("noticeList")
	public String noticeList(Model model) {
		List<NoticeVO> noticeList = noticeService.noticeList();

		for (NoticeVO notice : noticeList) {
			logger.debug("notice : {}", notice);
		}
		model.addAttribute("noticeList", noticeList);
		return "ourbox/start";
	}

//	@RequestMapping("noticeMain")
//	public String noticeMain(Model model, int page) {
//		List<NoticeVO> noticeList = noticeService.noticeList();
//
//		for (NoticeVO notice : noticeList) {
//			logger.debug("notice : {}", notice);
//		}
//		model.addAttribute("noticeList", noticeList);
//		return "notice/noticeList";
//	}

	@RequestMapping("noticePageList")
	public String noticePageList(int page, Model model) {
		
		int perlist = 10;

		int totalcount = noticeService.getTotalCount();

		// 전체 페이지수
		int totalpage = (int) (Math.ceil((double) totalcount / perlist)); // 올림공식

		int perblock = 5; // 한화면에 표현되는 페이지수
		int startpage = ((page - 1) / perblock * perblock) + 1;
		int endpage = startpage + perblock - 1;
		if (endpage > totalpage)
			endpage = totalpage;
		
		int start = (page - 1) * perlist + 1;
		int end = start + perlist - 1;
		if(end > totalcount) end = totalcount;

		Map<String, Integer> map = new HashMap<>();		
		map.put("start", start);
		map.put("end", end);
		
		// 페이지별 리스트 메소드 호출하기
		List<NoticeVO> list = noticeService.selectPage(map);
		
		model.addAttribute("listvalue", list);  
		model.addAttribute("spage", startpage); 
		model.addAttribute("epage", endpage);   
		model.addAttribute("tpage", totalpage); 
		model.addAttribute("cpage", page);     
		
		return "notice/noticeList";
	}
}
