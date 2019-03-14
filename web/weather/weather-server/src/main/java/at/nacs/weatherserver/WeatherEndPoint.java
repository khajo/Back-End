package at.nacs.weatherserver;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/weather")
public class WeatherEndPoint {


    private Map<String, String> forecasts = new HashMap<>();

    @GetMapping
    String get() {
        return "The Weather is awesome";
    }


    @GetMapping("/{city}")
    String get(@PathVariable String city) {
        return forecasts.get(city);
    }

    @PostMapping
    WeatherForecast post(@RequestBody WeatherForecast forecast) {
        forecasts.put(forecast.getCity(), forecast.getForecast());
        return forecast;
    }


}
