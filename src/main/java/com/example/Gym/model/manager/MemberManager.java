package com.example.Gym.model.manager;

import com.example.Gym.model.MembershipStatus;
import com.example.Gym.model.dao.MemberRepository;
import com.example.Gym.model.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MemberManager {

    private MemberRepository memberRepository;

    @Autowired
    public MemberManager(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public Iterable<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Member(1L, "Nicolas", "Cage", "nicolas@gmail.com", "123123123"));
        save(new Member(2L, "Nicolas", "Cage", "nicolas@gmail.com", "123123123", MembershipStatus.ACTIVE, LocalDate.now()));
    }

}
