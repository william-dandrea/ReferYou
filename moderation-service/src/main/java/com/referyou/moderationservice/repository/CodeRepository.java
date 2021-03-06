package com.referyou.moderationservice.repository;

import com.referyou.moderationservice.entity.Code;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {
}
