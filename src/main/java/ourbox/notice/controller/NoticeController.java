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
public class NoticeController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Autowired
	private INoticeService noticeService;

	@RequestMapping(path = "/noticePageList")
	public String noticeMain(Model model, int page) {

		int current_page = page == 0 ? 1 : page;

		int perlist = 10;
		model.addAttribute("pageSize", perlist);

		int totalcount = noticeService.getTotalCount();

		// 전체 페이지수
		int totalpage = (int) (Math.ceil((double) totalcount / perlist)); // 올림공식
		int perblock = 5; // 한화면에 표현되는 페이지수
		int startpage = ((current_page - 1) / perblock * perblock) + 1;
		int endpage = startpage + perblock - 1;
		if (endpage > totalpage)
			endpage = totalpage;

		int start = (current_page - 1) * perlist + 1;
		int end = start + perlist - 1;
		if (end > totalcount)
			end = totalcount;

		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);

		// 페이지별 리스트 메소드 호출하기
		List<NoticeVO> list = noticeService.selectPage(map);

		model.addAttribute("listvalue", list);
		model.addAttribute("spage", startpage);
		model.addAttribute("epage", endpage);
		model.addAttribute("tpage", totalpage);
		model.addAttribute("cpage", current_page);

//		logger.debug("listvalue : {}", list);  
//		logger.debug("spage : {}", startpage); 
//		logger.debug("epage : {}", endpage);   
//		logger.debug("tpage : {}", totalpage); 
//		logger.debug("cpage : {}", current_page);      

		return "notice/noticeMain";
	}

	@RequestMapping(path = "/detailNotice")
	public String detailNotice(int notice_seq, Model model) {
		NoticeVO notice = noticeService.detailNotice(notice_seq);

		logger.debug("detail notice : {}", notice);

		model.addAttribute("notice", notice);

		return "notice/detailNotice";
	}

	@RequestMapping(path = "/updateNoticeForm")
	public String updateNoticeForm(int notice_seq, Model model) {
		NoticeVO notice = noticeService.detailNotice(notice_seq);
		model.addAttribute("notice", notice);
		return "notice/updateNotice";
	}

	@RequestMapping(path = "/updateNotice")
	public String updateNotice(int updateSeq, String updateTitle, String updateContent, Model model) {
		NoticeVO notice = noticeService.detailNotice(updateSeq);
		notice.setNotice_title(updateTitle);
		notice.setNotice_content(updateContent);

		int updateCnt = noticeService.updateNotice(notice);

		if (updateCnt >= 1) {
			model.addAttribute("notice", notice);
		}
		return "notice/detailNotice";
	}

	@RequestMapping(path = "/insertNoticeForm")
	public String insertNotice() {
		return "notice/insertNotice";
	}

	@RequestMapping(path = "/insertNotice")
	public String insertNotice(String insertTitle, String insertContent, Model model) {
		NoticeVO insertnotice = new NoticeVO(insertTitle, insertContent);
		int insertCnt = noticeService.insertNotice(insertnotice);
		logger.debug("notice : {}", insertnotice);

		int notice_seq = insertnotice.getNotice_seq();
		NoticeVO notice = noticeService.detailNotice(notice_seq);

		if (insertCnt >= 1) {
			model.addAttribute("notice", notice);
		}

		return "notice/detailNotice";
	}

	@RequestMapping(path = "/deleteNotice")
	public String insertNotice(int notice_seq) {
		int deleteCnt = noticeService.deleteNotice(notice_seq);
		return "redirect:/ourbox/noticePageList?page=1";
	}
}
