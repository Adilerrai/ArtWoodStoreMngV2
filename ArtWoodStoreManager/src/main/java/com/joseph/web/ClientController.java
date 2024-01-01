package com.joseph.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joseph.entity.Client;
import com.joseph.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public String listClients(Model model) {
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);
        return "client/listclients";
    }

    @GetMapping("/add")
    public String addClient(Model model) {
        model.addAttribute("client", new Client());
        return "client/addclient";
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.saveClient(client);
        return "redirect:/client/list";
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("id") int id, Model model) {
        Client client = clientService.getClient(id);
        model.addAttribute("client", client);
        return "client/updateClient";
    }

    @PostMapping("/update")
    public String updateClient(@ModelAttribute("client") Client client) {
        clientService.saveClient(client);
        return "redirect:/client/list";
    }

    @GetMapping("/delete")
    public String deleteClient(@RequestParam("id") int id) {
        clientService.deleteClient(id);
        return "redirect:/client/list";
    }
}
