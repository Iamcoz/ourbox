package ourbox.room.service;

import java.io.DataOutput;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ourbox.common.vo.EnterVO;
import ourbox.common.vo.RoomVO;
import ourbox.notice.dao.INoticeDao;
import ourbox.room.dao.IRoomDao;
import ourbox.room.dao.RoomDaoImpl;

@Service("roomService")
public class RoomServiceImpl implements IRoomService {

	@Resource(name = "roomDao")
	private IRoomDao roomDao;

	public RoomServiceImpl() {

	}
	
	/**
	 * 접속중인 사용자 mem_id를 이요하여 참여중인 roomList들을 select하는 메서드 
	 * @param 접속중인 사용자 mem_id
	 * @return List<RoomVO>
	 */
	@Override
	public List<RoomVO> listRoom(String mem_id) {
		return roomDao.listRoom(mem_id);
	}
}
