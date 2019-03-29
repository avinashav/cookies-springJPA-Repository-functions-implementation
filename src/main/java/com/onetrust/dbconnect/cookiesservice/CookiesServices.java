package com.onetrust.dbconnect.cookiesservice;
import com.onetrust.dbconnect.dto.CookieDTO;
import com.onetrust.dbconnect.entity.Cookie;
import com.onetrust.dbconnect.repository.CookieRepository;
import com.onetrust.dbconnect.repository.CookiesFunctionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CookiesServices {
    @Autowired
    private CookieRepository cookieRepository;
    @Autowired
    private CookiesFunctionalRepository cookiesFunctionalRepository;

    public List<CookieDTO> getAllCookieList(){
        return        cookieRepository.findAll()
                      .stream()
                      .map(CookieDTO::convertToDto)
                      .collect(Collectors.toList());
    }

    public void addCookie(CookieDTO cookiedto){
       cookieRepository.save(CookieDTO.convertFromDto(cookiedto));
    }

/*
 *   @Transactional
 *   public void updateCookie(CookieDTO cookie){
 *       cookieRepository.save(CookieDTO.convertFromDto(cookie));
 *   }
*/

    @Transactional
    public void deleteCookie(CookieDTO cookiedto){
        cookieRepository.deleteByDomain(cookiedto.getDomain());
    }

    @Transactional
    public Page<Cookie> findByStatus(String status, Pageable pageable){
        return cookiesFunctionalRepository.findByStatus(status, pageable);
    }

    //Substring Matching on Domain
    @Transactional
    public Page<Cookie> findByDomainContaining(String substring, Pageable pageable){
        return cookiesFunctionalRepository.findByDomainContaining(substring, pageable);
    }

    @Transactional
    public Page<Cookie> findAllDomainBy(Pageable pageable){
        return cookiesFunctionalRepository.findAllDomainBy(pageable);
    }


}
