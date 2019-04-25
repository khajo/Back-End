package at.nacs.administrationui.view.controller;


import at.nacs.administrationui.client.InvoiceClient;
import at.nacs.administrationui.domain.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {
    private final InvoiceClient invoiceClient;

    @ModelAttribute("invoices")
    List<Invoice> invoice() {
        return invoiceClient.getAllInvoises();
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
        invoiceClient.markAsPaid(id);
        return "redirect:/invoices";
    }
}
