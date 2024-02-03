package com.yuriytkach.demo.demo2enstatuspagespring;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonProperty;

@FeignClient(name = "weather-api", url = "https://api.open-meteo.com")
public interface WeatherApiClient {

  @GetMapping("/v1/forecast")
  WeatherData getWeather(
    @RequestParam("latitude") float latitude,
    @RequestParam("longitude") float longitude,
    @RequestParam("current") String current
  );

  record WeatherData(
    CurrentData current,
    @JsonProperty("current_units") CurrentUnits currentUnits,
    String timezone
  ) {

    public Instant getUpdatedAt() {
      return LocalDateTime.parse(current.time())
        .atZone(ZoneId.of(timezone))
        .toInstant();
    }
  }

  record CurrentData(
    @JsonProperty("apparent_temperature")
    float apparentTemperature,
    @JsonProperty("temperature_2m")
    float temperature2m,
    String time
  ) {}

  record CurrentUnits(
    @JsonProperty("apparent_temperature")
    String apparentTemperature,
    @JsonProperty("temperature_2m")
    String temperature2m
  ) {}
}
