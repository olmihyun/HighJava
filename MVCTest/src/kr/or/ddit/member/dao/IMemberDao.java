package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여 
 * 서비스에 전달하는 DAO Interface
 * @author PC-03
 *
 */
public interface IMemberDao {
	
	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	 * @param mv DB에 insert할 자료가 저장된 MemberVO객체
	 * @return DB작업이 성공하면 1이상의 값이 반환되고 실패하면 0이 반환된다.
	 */
	public int insertMember(MemberVO mv);
	
	/**
	 * 주어진 회원ID가 존재하는지 여부를 알아내는 메서드
	 * @param memId 검색할 회원ID
	 * @return 해당 회원ID가 있으면 true, 없으면 false
	 */
	public boolean getMember(String memId); 
	
	/**
	 * DB의 mymember테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드 
	 * @return MemberVO객체를 담고 있는 List객체
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * 하나의 MemberVO 자료를 이용하여 DB를 update하는 메서드 
	 * @param mv update할 회원 정보가 들어있는 MemberVO객체 
	 * @return 작업성공 : 1, 작업실패: 0
	 */
	public int updateMember(MemberVO mv);
	
	/**
	 * 회원ID를 매개변수로 받아서 그 회원 정보를 삭제하는 메서드 
	 * @param memId 삭제할 회원ID
	 * @return 작업성공: 1, 작업실패: 0
	 */
	public int deleteMember(String memId);
	
	
	
}
