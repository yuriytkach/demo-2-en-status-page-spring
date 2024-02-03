package com.yuriytkach.demo.demo2enstatuspagespring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "geoip", url = "http://ip-api.com")
public interface GeoIPClient {

  @GetMapping("/json/{ip}")
  GeoLocationData getGeoLocationData(
    @PathVariable("ip") String ip
  );

  record GeoLocationData(float lat, float lon, String city, String country) {}
}
