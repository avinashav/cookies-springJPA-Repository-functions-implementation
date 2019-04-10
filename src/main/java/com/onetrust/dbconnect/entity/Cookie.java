package com.onetrust.dbconnect.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Cookiemain")
public class Cookie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "domain",unique = true, nullable = false)
    private String domain;

    @Column(name = "pages")
    private int pages;

    @Column(name = "unique_cookies")
    private int unique_cookies;

    @Column(name = "cookies_changed")
    private String cookies_changed;

    @Column(name = "banner")
    private String banner;

    @Column(name = "datetime")
    private Date datetime;

    @Column(name = "status")
    private String status;

    public Cookie(){

    }
    public Cookie(Long id, String domain, int pages,
                  int unique_cookies, String cookies_changed, String banner ,
                  Date datetime, String status) {
        super();
        this.id = id;
        this.domain = domain;
        this.pages = pages;
        this.unique_cookies = unique_cookies;
        this.cookies_changed = cookies_changed;
        this.banner = banner;
        this.datetime = datetime;
        this.status = status;
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

    public void setPages(int pages) {
        this.pages = pages;
    }

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

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "id=" + id +
                ", domain='" + domain + '\'' +
                ", pages=" + pages +
                ", unique_cookies=" + unique_cookies +
                ", cookies_changed='" + cookies_changed + '\'' +
                ", banner='" + banner + '\'' +
                ", datetime=" + datetime +
                ", status='" + status + '\'' +
                '}';
    }
}