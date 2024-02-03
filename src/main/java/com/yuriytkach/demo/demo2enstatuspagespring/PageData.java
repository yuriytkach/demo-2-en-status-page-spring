package com.yuriytkach.demo.demo2enstatuspagespring;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageData {
  private final String ip;
  private final String country;
  private final String city;
  private final String cityDesc;
  private final String countryDesc;
  private final String lon;
  private final String lat;
  private final String temperature;
  private final String apparentTemp;
  private final String updatedAt;
}
