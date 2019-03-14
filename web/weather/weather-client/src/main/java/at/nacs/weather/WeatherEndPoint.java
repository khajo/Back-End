package at.nacs.weather;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherEndPoint {

    private final WeatherClient weatherRepository;


    @GetMapping
    String get() {
        return weatherRepository.getWeatherForecastFOrToday();
    }
    @GetMapping("{city}")
    String get( @PathVariable String city) {
        return weatherRepository.getWeatherForecastFOrToday(city);
    }
}
