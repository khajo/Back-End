//package at.nacs.fengshuiapi;
//
//
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.time.LocalDate;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/compatibility")
//@RequiredArgsConstructor
//public class LoveCompatibilityEndpoint {
//
//    private final RestTemplate restTemplate;
//    private final Signs signs;
//
//
//
//    @GetMapping("/compatibility/sign/{birthday1}/{birthday2}")
//    String get(@PathVariable LocalDate birthday1,@PathVariable LocalDate birthday2) {
//        String url1 = "https://fengshui-api.com/api/v1/findChineseSignOfYear?token=N0997G7613A0Mbed4fM8d9Ud93A0z4eb02e79F19&year="+birthday1.getYear()+"&month="+birthday1.getMonthValue()+"&day="+birthday1.getDayOfMonth()+"&gender=0";
//        String url2 = "https://fengshui-api.com/api/v1/findChineseSignOfYear?token=N0997G7613A0Mbed4fM8d9Ud93A0z4eb02e79F19&year="+birthday2.getYear()+"&month="+birthday2.getMonthValue()+"&day="+birthday2.getDayOfMonth()+"&gender=0";
//        Sign sign = restTemplate.getForObject(url1, Sign.class);
//        Sign sign2 = restTemplate.getForObject(url2, Sign.class);
//        Map<String, String> signMap = signs.getSignMap();
//        String url3 = "https://fengshui-api.com/api/v1/findSignCompatibility?token=N0997G7613A0Mbed4fM8d9Ud93A0z4eb02e79F19&sign="+signMap.get(sign.getResult())+"&sign2="+signMap.get(sign2.getResult());
//        String comparibility = restTemplate.getForObject(url3, String.class);
//        return comparibility;
//    }
//
//
//
//}
