package ourbox.room.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import ourbox.common.vo.EnterVO;
import ourbox.common.vo.RoomVO;

public interface IRoomDao {

	/**
	 * 접속중인 사용자 mem_id를 이요하여 참여중인 roomList들을 select하는 메서드 
	 * @param 접속중인 사용자 mem_id
	 * @return List<RoomVO>
	 */
	public List<RoomVO> listRoom(String mem_id);
}
