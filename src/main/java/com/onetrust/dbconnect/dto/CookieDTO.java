package com.onetrust.dbconnect.dto;

import java.text.DateFormat;
import java.util.Random;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.onetrust.dbconnect.entity.Cookie;

import java.util.Date;


public class CookieDTO {

    private Long id;
    private String domain;
    private int pages;
    private int unique_cookies;
    private String cookies_changed;
    private String banner;
    private String cookie_list;
    private String pref_center;
    private Date datetime;
    private String status;

    public CookieDTO() {
    }

    public CookieDTO(
            @JsonProperty("domain") String domain
            , @JsonProperty("pages") int pages
            , @JsonProperty("unique_cookies") int unique_cookies
            , @JsonProperty("banner") String banner
            , @JsonProperty("cookie_list") String cookie_list
            , @JsonProperty("pref_center") String pref_center
            , @JsonProperty("cookies_changed") String cookies_changed
            , @JsonProperty("status") String status
    ) {
        this.id = id;
        this.domain = domain;
        this.pages = pages;
        this.unique_cookies = unique_cookies;
        this.cookies_changed = cookies_changed;
        this.banner = banner;
        this.cookie_list = cookie_list;
        this.pref_center = pref_center;
        this.status = status;
    }

    public static Cookie convertFromDto(CookieDTO cookieDTO){
        Cookie cookie = new Cookie();

//        Date date = new Date();
//        java.text.SimpleDateFormat sdf =
//                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        String currentTime = sdf.format(date);
//
        Random rand = new Random();
        int random_unique_cookie = rand.nextInt(40);
        int random_cookies_change = rand.nextInt(30);
        String manage = "Manage";
        String completed_status = "Completed";

        cookie.setBanner(manage);
        cookie.setCookie_list(manage);
        cookie.setCookies_changed("+" + Integer.toString(random_cookies_change));

        cookie.setDatetime(new Date());
        cookie.setDomain(cookieDTO.getDomain());
        cookie.setPages(cookieDTO.getPages());
        cookie.setPref_center(manage);
        cookie.setStatus(completed_status);
        cookie.setUnique_cookies(random_unique_cookie);
        return cookie;
    }

    public static CookieDTO convertToDto(Cookie cookie){
        CookieDTO cookieDTO = new CookieDTO();

        cookieDTO.setBanner(cookie.getBanner());
        cookieDTO.setCookie_list(cookie.getCookie_list());
        cookieDTO.setCookies_changed(cookie.getCookies_changed());
        cookieDTO.setDatetime(cookie.getDatetime());
        cookieDTO.setDomain(cookie.getDomain());
        cookieDTO.setPages(cookie.getPages());
        cookieDTO.setPref_center(cookie.getPref_center());
        cookieDTO.setStatus(cookie.getStatus());
        cookieDTO.setUnique_cookies(cookie.getUnique_cookies());

        return cookieDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) { this.pages = pages; }

    public int getUnique_cookies() {
        return unique_cookies;
    }

    public void setUnique_cookies(int unique_cookies) {
        this.unique_cookies = unique_cookies;
    }

    public String getCookies_changed() {
        return cookies_changed;
    }

    public void setCookies_changed(String cookies_changed) {
        this.cookies_changed = cookies_changed;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getCookie_list() {
        return cookie_list;
    }

    public void setCookie_list(String cookie_list) {
        this.cookie_list = cookie_list;
    }

    public String getPref_center() {
        return pref_center;
    }

    public void setPref_center(String pref_center) {
        this.pref_center = pref_center;
    }

    public Date getDatetime() { return datetime; }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}