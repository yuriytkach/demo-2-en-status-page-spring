package com.yuriytkach.demo.demo2enstatuspagespring;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "reverse-geocode-api", url = "https://api.bigdatacloud.net")
public interface ReverseGeoCodeClient {

  @GetMapping("/data/reverse-geocode-client")
  ReverseGeoCodeData getReverseGeoCodeData(
    @RequestParam("latitude") String lat,
    @RequestParam("longitude") String lon
  );

  record ReverseGeoCodeData(String city, String countryName, LocalityInfo localityInfo) {
    public String getCityDescription() {
      return localityInfo.administrative().stream()
        .filter(a -> a.name().equals(city))
        .map(LocalityInfoData::description)
        .findFirst()
        .orElse("");
    }

    public String getCountryDescription() {
      return localityInfo.administrative().stream()
        .filter(a -> a.name().equals(countryName))
        .map(LocalityInfoData::description)
        .findFirst()
        .orElse("");
    }
  }

  record LocalityInfo(List<LocalityInfoData> administrative) {}

  record LocalityInfoData(String name, String description) {}

}
