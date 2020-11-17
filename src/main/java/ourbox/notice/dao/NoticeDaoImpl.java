package ourbox.notice.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import ourbox.common.vo.NoticeVO;

@Repository("noticeDao")
public class NoticeDaoImpl implements INoticeDao {

	
	@Resource(name = "sqlSessionTemplate")
	public SqlSessionTemplate sqlSession;
	
	@Override
	public List<NoticeVO> noticeList() {
		return sqlSession.selectList("notice.noticeList");
	}

	@Override
	public int insertNotice(NoticeVO notice) {
		return sqlSession.insert("notice.insertNotice", notice);
	}

	@Override
	public int updateNotice(NoticeVO notice) {
		return sqlSession.update("notice.updateNotice", notice);
	}

	@Override
	public int deleteNotice(int notice_seq) {
		return sqlSession.delete("notice.deleteNotice", notice_seq);
	}

	@Override
	public NoticeVO detailNotice(int notice_seq) {
		return sqlSession.selectOne("notice.detailNotice", notice_seq);
	}

	@Override
	public List<NoticeVO> selectPage(Map<String, Integer> map) {
		return sqlSession.selectList("notice.selectPage", map);
	}

	@Override
	public int getTotalCount() {
		return sqlSession.selectOne("notice.getTotalCount");
	}

}
