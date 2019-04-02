package com.onetrust.dbconnect.cookiescontroller;

import com.onetrust.dbconnect.cookiesservice.CookiesServices;
import com.onetrust.dbconnect.dto.CookieDTO;
import com.onetrust.dbconnect.entity.Cookie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping(value = "/cookies")
public class CookiesController {

    @Autowired
    private CookiesServices cookieservice;

//
//    @GetMapping
//    public List<CookieDTO> getAllCookies() {
//        return cookieservice.getAllCookieList();
//    }

    /* localhost:8080/cookies/?page=0&size=5&sort=domain,ASC */
    @GetMapping
    public Page<Cookie> getAllCookies(@PageableDefault final Pageable pageable){
        return cookieservice.getAllCookies(pageable);
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

    /* localhost:8080/cookies/?page=0&size=5&sort=domain,ASC&checkStatus=Completed */
    @GetMapping(params = {"checkStatus"})
    public Page<Cookie> findByStatus(@PageableDefault final Pageable pageable ,
                                     @RequestParam("checkStatus") String checkStatus){
        return cookieservice.findByStatus(checkStatus, pageable);
    }

    /* localhost:8080/cookies/?page=0&size=5&sort=domain,ASC&searchString=oogl */

    @GetMapping(params = {"searchString"})
    public Page<Cookie> findByDomainContaining(@PageableDefault final Pageable pageable,
                                               @RequestParam("searchString") String searchString) {
        return cookieservice.findByDomainContaining(searchString, pageable);
    }


    }