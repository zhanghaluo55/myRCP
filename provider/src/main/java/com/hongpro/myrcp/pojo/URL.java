package com.hongpro.myrcp.pojo;

import java.util.Objects;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description
 * @date 2021/5/17 18:12
 */
public class URL {
    private String hostname;

    private Integer port;

    public URL(String hostname, Integer port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    /*@Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof URL)) {
            return false;
        }
        URL url = (URL)o;
        if (hostname.equals((url.getHostname())) && port.equals(url.getPort())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return hostname.hashCode();
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        URL url = (URL) o;
        return Objects.equals(hostname, url.hostname) && Objects.equals(port, url.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostname, port);
    }

    @Override
    public String toString() {
        return "URL{" +
                "hostname='" + hostname + '\'' +
                ", port=" + port +
                '}';
    }
}
