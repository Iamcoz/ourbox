package ourbox.room.service;

import java.util.List;

import ourbox.common.vo.RoomVO;

public interface IRoomService {

	/**
	 * 접속중인 사용자 mem_id를 이요하여 참여중인 roomList들을 select하는 메서드 
	 * @param 접속중인 사용자 mem_id
	 * @return List<RoomVO>
	 */
	public List<RoomVO> listRoom(String mem_id);
	}
