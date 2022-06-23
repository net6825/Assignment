//package com.example.assignment.initDB;
//
//import com.example.assignment.domain.Member;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.EntityManager;
//
//@Component
//@RequiredArgsConstructor
//public class InitUserService {
//
//    private final EntityManager em;
//
//    public void Init() {
//
//        Member member1 = createUser("test1", "MEMBER", "test1");
//        Member member2 = createUser("test2", "MEMBER", "test2");
//        Member member3 = createUser("test3", "MEMBER", "test3");
//        Member member4 = createUser("test4", "MEMBER", "test4");
//        Member member5 = createUser("test5", "MEMBER", "test5");
//    }
//
//    public Member createUser(String id, String role, String pw) {
//        Member member = Member.builder()
//                .userId(id)
//                .pw(pw)
//                .role(role)
//                .build();
//
//        em.persist(member);
//
//        return member;
//    }
//}
