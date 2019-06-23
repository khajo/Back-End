package at.nacs.administrationui.communication.client;



import at.nacs.administrationui.communication.dto.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountancyClient {

    private final RestTemplate restTemplate;


    @Value("${accountancy.url}")
    private String accountancyUrl;

    public List<Invoice> getAllInvoises() {

        Invoice[] invoicesArray = restTemplate.getForObject(accountancyUrl, Invoice[].class);
        return Arrays.asList(invoicesArray);
    }

    public void markAsPaid(Long id) {
        restTemplate.put(accountancyUrl + "/" + id + "/paid", void.class);
    }
}

