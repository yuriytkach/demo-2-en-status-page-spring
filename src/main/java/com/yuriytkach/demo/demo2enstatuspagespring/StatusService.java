package com.yuriytkach.demo.demo2enstatuspagespring;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatusService {

  private final GeoIPClient geoIPClient;

  private final ReverseGeoCodeClient reverseGeoCodeClient;

  private final WeatherApiClient weatherApiClient;

  public PageData loadData(final String ip) {
    log.info("Loading data for ip: {}", ip);

    final var geoLocationData = geoIPClient.getGeoLocationData(ip);
    log.info("Geo location data: {}", geoLocationData);

    final var reverseGeoCodeData = reverseGeoCodeClient.getReverseGeoCodeData(
      String.valueOf(geoLocationData.lat()),
      String.valueOf(geoLocationData.lon())
    );
    log.info("Reverse geo code data: {}", reverseGeoCodeData);

    final var weatherData = weatherApiClient.getWeather(
      geoLocationData.lat(),
      geoLocationData.lon(),
      "temperature_2m,apparent_temperature"
    );
    log.info("Weather data: {}", weatherData);

    return PageData.builder()
      .ip(ip)
      .city(reverseGeoCodeData.city())
      .cityDesc(reverseGeoCodeData.getCityDescription())
      .country(reverseGeoCodeData.countryName())
      .countryDesc(reverseGeoCodeData.getCountryDescription())
      .lon(String.valueOf(geoLocationData.lon()))
      .lat(String.valueOf(geoLocationData.lat()))
      .temperature(String.format(
        "%.1f %s",
        weatherData.current().temperature2m(),
        weatherData.currentUnits().temperature2m()))
      .apparentTemp(String.format(
        "%.1f %s",
        weatherData.current().apparentTemperature(),
        weatherData.currentUnits().apparentTemperature()))
      .updatedAt(weatherData.getUpdatedAt().toString())
      .build();
  }
}
