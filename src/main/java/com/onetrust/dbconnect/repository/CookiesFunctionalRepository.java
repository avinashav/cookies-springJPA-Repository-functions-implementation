package com.onetrust.dbconnect.repository;

import com.onetrust.dbconnect.entity.Cookie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CookiesFunctionalRepository extends PagingAndSortingRepository<Cookie, Long> {

    Page<Cookie> findByStatus(String status, Pageable pageable);

    Page<Cookie> findByDomainContaining(String substring, Pageable pageable);       //finding a substring

    Page<Cookie> findAllDomainBy(Pageable pageable);
}
