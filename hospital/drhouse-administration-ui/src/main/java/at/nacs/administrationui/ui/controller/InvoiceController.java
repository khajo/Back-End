package at.nacs.administrationui.ui.controller;


import at.nacs.administrationui.communication.client.AccountancyClient;
import at.nacs.administrationui.communication.dto.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {
private final AccountancyClient accountancyClient;

    @ModelAttribute("invoices")
    List<Invoice> invoice() {
        return accountancyClient.getAllInvoises();
    }

    @ModelAttribute("invoice")
    Invoice todo() {
        return new Invoice();
    }

    @GetMapping
    String page() {
        return "invoice";
    }


    @PostMapping("/paid")
    String put(@RequestParam Long id) {
        accountancyClient.markAsPaid(id);
        return "redirect:/invoices";
    }
}
