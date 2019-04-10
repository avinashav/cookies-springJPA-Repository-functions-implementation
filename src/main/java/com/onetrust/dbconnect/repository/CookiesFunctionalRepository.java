package com.onetrust.dbconnect.repository;

import com.onetrust.dbconnect.entity.Cookie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookiesFunctionalRepository extends PagingAndSortingRepository<Cookie, Long> {

    Page<Cookie> findByStatus(String status, Pageable pageable);

    Page<Cookie> findByDomainContaining(String substring, Pageable pageable);       //finding a substring

    Page<Cookie> findAllDomainBy(Pageable pageable);

    /* For Displaying Latest addition record first */
    @Query(value = "SELECT u FROM Cookie u ORDER BY datetime")
    Page<Cookie> findAllDomainWithPagination(Pageable pageable);
}
