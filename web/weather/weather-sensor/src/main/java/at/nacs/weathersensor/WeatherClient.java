package at.nacs.weathersensor;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/provide/weather")
@RequiredArgsConstructor
public class WeatherClient {


    private final RestTemplate restTemplate;


    @Value("${weather.server.url}")
    String url;


    @GetMapping
    String provideWeatherToServer() {
        Forecast forecast = new Forecast("Madrid", "sunny");
        Forecast response = restTemplate.postForObject(url, forecast, Forecast.class);
        return "Done. Post: " + response;

    }

}
