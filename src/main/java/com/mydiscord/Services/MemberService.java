package com.mydiscord.Services;

import com.mydiscord.Exceptions.MemberNotFoundByIdException;
import com.mydiscord.Models.Member;
import com.mydiscord.Repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void save(Member member) {
        memberRepository.save(member);
    }

    public Member findById(Long id) throws MemberNotFoundByIdException {
        return memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundByIdException("Member was not found by id."));
    }
}
