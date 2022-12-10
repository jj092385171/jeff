package T4_01.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import T4_01.beans.Member;
import T4_01.dao.MemberDao;
import utils.DbUtils;

public class MemberImpl implements MemberDao {
	private QueryRunner queryRunner = new QueryRunner();
	@Override
	public Member insert(Member member) {
		try {
			Member insert = queryRunner.insert(DbUtils.getConnection(),
					"INSERT INTO member (account,Nickname,firstname ,lastname,exp,leavel,point,phone,birthday,address ,email,gender ,subscribed ,shot,registerdata)VALUES(?,?,?,?,default ,default ,default ,?,?,?,?,?,default ,?, default )",
					new BeanHandler<Member>(Member.class),member.getAccount(), member.getNickname(),
					member.getFirstname(), member.getLastname(),
//					member.getExp(), member.getLeavel(), member.getPoint(),
					member.getPhone(), member.getBirthday(),
					member.getAddress(), member.getEmail(), member.getGender(),
//					member.getSubscribed(),
					member.getShot());
			return insert;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int delete(String account) {
		try {
			int delete = queryRunner.update(DbUtils.getConnection(),
					"DELETE FROM member WHERE account = ?", account);
			return delete;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Member member) {
		try {
			int update = queryRunner.update(DbUtils.getConnection(),
					"UPDATE member SET account = ?,Nickname = ?,firstname = ?,lastname = ?,exp = ?,leavel = ?,point = ?,phone = ?,birthday = ?,address = ?,email = ?,gender = ?,subscribed = ?,shot = ? WHERE UID = ?",
					member.getAccount(), member.getNickname(),
					member.getFirstname(), member.getLastname(),
					member.getExp(), member.getLeavel(), member.getPoint(),
					member.getPhone(), member.getBirthday(),
					member.getAddress(), member.getEmail(), member.getGender(),
					member.getSubscribed(), member.getShot(), member.getUID());
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Member select(String account) {
		try {
			Member member = queryRunner.query(DbUtils.getConnection(),
					" SELECT * FROM member WHERE account = ? ",
					new BeanHandler<Member>(Member.class), account);
			return member;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Member> selectAll() {

		try {
			List<Member> members = queryRunner.query(DbUtils.getConnection(),
					"SELECT * FROM member ",
					new BeanListHandler<Member>(Member.class));
			return members;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
