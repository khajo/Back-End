package at.nacs.fengshuiapi;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FangShuiClient {

    private final RestTemplate restTemplate;
    private final Signs signs;

    @Value("${url.urlFindChineseSignOfYear}")
    private final String urlFindChineseSignOfYear;
    @Value("${url.urlFindSignCompatibility}")
    private final String urlFindSignCompatibility;
    @Value("${url.urlFindLoveCompatibility}")
    private final String urlFindLoveCompatibility;
//private final      String url = "https://fengshui-api.com/api/v1/findChineseSignOfYear?token=N0997G7613A0Mbed4fM8d9Ud93A0z4eb02e79F19&year="+birthday.getYear()+"&month="+birthday.getMonthValue()+"&day="+birthday.getDayOfMonth()+"&gender=0";

    @GetMapping("{birthday}")
    String getSign(@PathVariable LocalDate birthday) {
        String url = urlFindChineseSignOfYear + "&year=" + birthday.getYear() + "&month=" + birthday.getMonthValue() + "&day=" + birthday.getDayOfMonth() + "&gender=0";
        Sign sign = restTemplate.getForObject(url, Sign.class);
        return sign.getResult();
    }

    @GetMapping("/compatibility/sign/{birthday1}/{birthday2}")
    String getSignCompatibility(@PathVariable LocalDate birthday1, @PathVariable LocalDate birthday2) {
        Map<String, String> signMap = signs.getSignMap();
        String sign1 = getSign(birthday1);
        String sign2 = getSign(birthday2);
        String url3 = urlFindSignCompatibility + signMap.get(sign1) + "&sign2=" + signMap.get(sign2);
        String comparibility = restTemplate.getForObject(url3, String.class);
        return comparibility;
    }

    @GetMapping("/compatibility/love/{birthday1}/{birthday2}")
    String getLoveCompatibility(@PathVariable LocalDate birthday1, @PathVariable LocalDate birthday2) {
        String url3 = urlFindLoveCompatibility + "&year=" + birthday1.getYear() + "&month=" + birthday1.getMonthValue() + "&day=" + birthday1.getDayOfMonth()
                + "&year2=" + birthday1.getYear() + "&month2=" + birthday1.getMonthValue() + "&day2=" + birthday1.getDayOfMonth();
        String comparibility = restTemplate.getForObject(url3, String.class);
        return comparibility;
    }
}
