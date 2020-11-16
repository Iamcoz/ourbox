package ourbox.notice.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ourbox.common.vo.NoticeVO;
import ourbox.notice.dao.INoticeDao;

@Service("noticeService")
public class NoticeServiceImpl implements INoticeService {

	@Resource(name = "noticeDao")
	private INoticeDao noticeDao;

	public NoticeServiceImpl() {

	}

	@Override
	public List<NoticeVO> noticeList() {
		return noticeDao.noticeList();
	}

	@Override
	public int insertNotice(NoticeVO notice) {
		return noticeDao.insertNotice(notice);
	}

	@Override
	public int updateNotice(NoticeVO notice) {
		return noticeDao.updateNotice(notice);
	}

	@Override
	public int deleteNotice(int notice_seq) {
		return noticeDao.deleteNotice(notice_seq);
	}

	@Override
	public NoticeVO detailNotice(int notice_seq) {
		return noticeDao.detailNotice(notice_seq);
	}

	@Override
	public List<NoticeVO> searchNotice(NoticeVO notice) {
		return noticeDao.searchNotice(notice);
	}

	@Override
	public List<NoticeVO> selectPage(Map<String, Integer> map) {
		return noticeDao.selectPage(map);
	}

	@Override
	public int getTotalCount() {
		return noticeDao.getTotalCount();
	}
}
