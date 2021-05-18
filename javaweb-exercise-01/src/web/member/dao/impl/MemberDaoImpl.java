package web.member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import web.member.bean.Member;
import web.member.dao.MemberDao;

public class MemberDaoImpl implements MemberDao {
    private DataSource dataSource;

    public MemberDaoImpl() {
        try {
            dataSource = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/example");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insert(Member member) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete from MEMBER where ID = ?";
        try (
                // dataSource -> 由資料源產生的連線物件，在web環境下較常使用
                Connection connection = dataSource.getConnection();
                // sql: 欲對資料庫執行的SQL敘述. 可帶有多個問號，表示佔位符(placeholder)
                PreparedStatement pstm = connection.prepareStatement(sql);
        ) {
            // ?站位符 -> 塞入對應的型態, 值
            pstm.setInt(1, id);
            // 進行DML
            return pstm.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 若有問題最後回傳-1
        return -1;
    }

    @Override
    public int update(Member member) {
        String sql = "update MEMBER set"
                + "ACCOUNT = ?,"
                + "PASSWORD = ?,"
                + "NICKNAME = ?,"
                + "LAST_UPDATE_DATE = now()"
                + "where ID = ?";
        
        try (
                // dataSource -> 由資料源產生的連線物件，在web環境下較常使用
                Connection connection = dataSource.getConnection();
                // sql: 欲對資料庫執行的SQL敘述. 可帶有多個問號，表示佔位符(placeholder)
                PreparedStatement pstm = connection.prepareStatement(sql);
        ) {
            // ?站位符 -> 塞入對應的型態, 值
            pstm.setString(1, member.getAccount());
            pstm.setString(1, member.getAccount());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return -1;
    }

    @Override
    public Member selectById(Integer id) {
        String sql = "select * from MEMBER where ID = ?";
        try (
                // dataSource -> 由資料源產生的連線物件，在web環境下較常使用
                Connection connection = dataSource.getConnection();
                // sql: 欲對資料庫執行的SQL敘述. 可帶有多個問號，表示佔位符(placeholder)
                PreparedStatement pstm = connection.prepareStatement(sql);
                // 進行DQL
                ResultSet rs = pstm.executeQuery();
        ) {
            // rs -> 結果集
            while (rs.next()) {
                Member member = new Member();
                // rs.get型態(“欄名”);
                member.setId(rs.getInt("ID"));
                member.setAccount(rs.getString("ACCOUNT"));
                member.setPassword(rs.getString("PASSWORD"));
                member.setNickname(rs.getString("NICKNAME"));
                member.setPass(rs.getBoolean("PASS"));
                member.setLastUpdateDate(rs.getTimestamp("LAST_UPDATE_DATE"));
                return member;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Member> selectAll() {
        String sql = "select * from MEMBER";
        try (
                // dataSource -> 由資料源產生的連線物件，在web環境下較常使用
                Connection connection = dataSource.getConnection();
                // sql: 欲對資料庫執行的SQL敘述. 可帶有多個問號，表示佔位符(placeholder)
                PreparedStatement pstm = connection.prepareStatement(sql);
                // 進行DQL
                ResultSet rs = pstm.executeQuery();
        ) {
            // new list
            List<Member> list = new ArrayList<>();
            // rs -> 結果集
            while (rs.next()) {
                Member member = new Member();
                // rs.get型態(“欄名”);
                member.setId(rs.getInt("ID"));
                member.setAccount(rs.getString("ACCOUNT"));
                member.setPassword(rs.getString("PASSWORD"));
                member.setNickname(rs.getString("NICKNAME"));
                member.setPass(rs.getBoolean("PASS"));
                member.setLastUpdateDate(rs.getTimestamp("LAST_UPDATE_DATE"));
                list.add(member);
            }
            return list;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
