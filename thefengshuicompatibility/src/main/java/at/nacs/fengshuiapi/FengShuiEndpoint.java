package at.nacs.fengshuiapi;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
public class FengShuiEndpoint {

    final private FangShuiClient fangShuiClient;
    private final RestTemplate restTemplate;


    @GetMapping("{birthday}")
    String get(@PathVariable LocalDate birthday) {
        String url = "https://fengshui-api.com/api/v1/findChineseSignOfYear?token=N0997G7613A0Mbed4fM8d9Ud93A0z4eb02e79F19&year="+birthday.getYear()+"&month="+birthday.getMonthValue()+"&day="+birthday.getDayOfMonth()+"&gender=0";
        Sign sign = restTemplate.getForObject(url, Sign.class);
        return sign.getResult();
    }
}
