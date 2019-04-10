package com.onetrust.dbconnect.repository;

import com.onetrust.dbconnect.entity.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookieRepository extends JpaRepository<Cookie, Long> {

    void deleteByDomain(String domain);

}
