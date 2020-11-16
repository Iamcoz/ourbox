package ourbox.room.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import ourbox.common.vo.RoomVO;

@Repository("roomDao")
public class RoomDaoImpl implements IRoomDao {

	@Resource(name = "sqlSessionTemplate")
	public SqlSessionTemplate sqlSession;

	/**
	 * 접속중인 사용자 mem_id를 이요하여 참여중인 roomList들을 select하는 메서드
	 * 
	 * @param 접속중인 사용자 mem_id
	 * @return List<RoomVO>
	 */
	@Override
	public List<RoomVO> listRoom(String mem_id){
		return sqlSession.selectList("room.listRoom", mem_id);
	}
}