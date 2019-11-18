package com.mydiscord.Controllers;

import com.mydiscord.Exceptions.MemberNotFoundByIdException;
import com.mydiscord.Models.Member;
import com.mydiscord.Services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/members/{id}")
    public ResponseEntity<Member> findMemberById(@PathVariable("id") Long id) throws MemberNotFoundByIdException {
        if (memberService.existsById(id)) {
            return ResponseEntity.ok(memberService.findById(id));
        }
        throw new MemberNotFoundByIdException("Member was not found by id.");
    }
}
