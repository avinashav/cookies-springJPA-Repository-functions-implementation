package com.onetrust.dbconnect.cookiescontroller;

import com.onetrust.dbconnect.cookiesservice.CookiesServices;
import com.onetrust.dbconnect.dto.CookieDTO;
import com.onetrust.dbconnect.entity.Cookie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping(value = "/cookies")
public class CookiesController {

    @Autowired
    private CookiesServices cookieservice;


    @GetMapping
    public List<CookieDTO> getAllCookies() {
        return cookieservice.getAllCookieList();
    }

    @PostMapping
    public void addCookie(@RequestBody CookieDTO cookieDTO){
       cookieservice.addCookie(cookieDTO);
    }

/*
 *  @PutMapping
 *   public void updateCookie(@RequestBody CookieDTO ck){
 *       cookieservice.updateCookie(ck);
 *  }
*/
    @DeleteMapping
    public void deleteCookie(@RequestBody CookieDTO ck){
        cookieservice.deleteCookie(ck);
    }


    @GetMapping(value = "/findstatus")
    public Page<Cookie> findByStatus(){
        Pageable pageable =  new PageRequest(0, 3, Sort.Direction.ASC , "domain");
        return cookieservice.findByStatus("Completed", pageable);
    }


    @GetMapping(value = "/findsubstringindomain")
    public Page<Cookie> findByDomainContaining(){
        Pageable pageable =  new PageRequest(0, 3);
        String substring = "oogl";
        return cookieservice.findByDomainContaining(substring , pageable);
    }

    @GetMapping(value = "/sortdomain")
    public Page<Cookie> findAllByDomain() {
        Pageable pageable =  new PageRequest(0, 3, Sort.Direction.ASC , "domain");
        return cookieservice.findAllDomainBy(pageable);
    }

    }