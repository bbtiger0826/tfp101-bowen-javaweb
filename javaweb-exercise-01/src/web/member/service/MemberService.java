package web.member.service;

import java.util.List;

import web.member.bean.Member;
import web.member.dao.MemberDao;
import web.member.dao.impl.MemberDaoImpl;

public class MemberService {
    private MemberDao dao;
    
    public MemberService() {
        dao = new MemberDaoImpl();
    }
    
    public List<Member> test() {
        return dao.selectAll();
    }

}
