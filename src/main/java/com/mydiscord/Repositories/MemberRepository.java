package com.mydiscord.Repositories;

import com.mydiscord.Models.Member;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {
}
