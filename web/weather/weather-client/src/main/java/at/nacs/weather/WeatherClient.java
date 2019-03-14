package at.nacs.weather;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class WeatherClient {

    private final RestTemplate restTemplate;

    @Value("${weather.server.url}")
    private String url;

    public String getWeatherForecastFOrToday() {
        String forcast = restTemplate.getForObject(url, String.class);
        return "Client: "+forcast;
    }

    public String getWeatherForecastFOrToday(String city) {
        String forecast = restTemplate.getForObject(url+"/"+city, String.class);
        return "client: " + forecast;

    }
}
