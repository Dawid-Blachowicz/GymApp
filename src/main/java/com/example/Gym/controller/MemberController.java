package com.example.Gym.controller;

import com.example.Gym.model.entity.Member;
import com.example.Gym.model.manager.MemberManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private MemberManager memberManager;

    @Autowired
    public MemberController(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @GetMapping("/all")
    public Iterable<Member> getAll() {
        return memberManager.findAll();
    }

    @GetMapping
    public Optional<Member> getById(@RequestParam Long index) {
        return memberManager.findById(index);
    }

    @GetMapping("/")
    public String index() {
        return "Hello world";
    }

    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberManager.save(member);
    }

    @PutMapping
    public Member updateMember(@RequestBody Member member) {
        return memberManager.save(member);
    }

    @DeleteMapping
    public void deleteMember(@RequestParam Long index) {
        memberManager.deleteById(index);
    }
}
