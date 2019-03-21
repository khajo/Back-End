//package at.nacs.fengshuiapi;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.time.LocalDate;
//
//@RestController
//@RequestMapping("/test")
//@RequiredArgsConstructor
//public class TestClient {
//
//    private final RestTemplate restTemplate;
//
//    @GetMapping
//    String get() {
//        String url = "https://fengshui-api.com/api/v1/findChineseSignOfYear?token=N0997G7613A0Mbed4fM8d9Ud93A0z4eb02e79F19&year=2013&month=8&day=2&gender=0";
//        return restTemplate.getForObject(url, String.class);
//    }
//
//    @GetMapping("/{birthday}")
//    String get(@PathVariable LocalDate birthday) {
//        return "Year: " + birthday.getYear();
//    }
//
//}