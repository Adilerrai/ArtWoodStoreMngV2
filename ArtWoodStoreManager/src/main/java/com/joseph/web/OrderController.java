package com.joseph.web;

import com.joseph.entity.Client;
import com.joseph.entity.OrdreEntity;
import com.joseph.entity.OrderStatus;
import com.joseph.entity.Product;
import com.joseph.service.ClientService;
import com.joseph.service.OrderService;
import com.joseph.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ClientService clientService;
    private final ProductService productService;

    @Autowired
    public OrderController(OrderService orderService, ClientService clientService, ProductService productService) {
        this.orderService = orderService;
        this.clientService = clientService;
        this.productService = productService;
    }

    @GetMapping("/list")
    public String listOrders(Model model) {
        List<OrdreEntity> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "listordres";
    }

    @GetMapping("/add")
    public String showAddOrderForm(Model model) {
        List<Client> clients = clientService.getClients();
        List<Product> products = productService.getAllProducts();

        model.addAttribute("order", new OrdreEntity());
        model.addAttribute("clients", clients);
        model.addAttribute("products", products);
        model.addAttribute("orderStatusValues", OrderStatus.values()); // Changed the attribute name to avoid conflicts

        return "addorder";
    }

    @PostMapping("/add")
    public String addOrder(@ModelAttribute OrdreEntity order,
                           @RequestParam("clientId") int clientId,
                           @RequestParam("productIds") List<Long> productIds,
                           @RequestParam("orderStatus") OrderStatus orderStatus) {
        // Convert simple types to corresponding objects
        Client client = clientService.getClient(clientId);
        Set<Product> products = (Set<Product>) productService.getProductsByIds(productIds);

        // Set converted objects in the order
        order.setClient(client);
        order.setProducts(products);
        order.setStatus(orderStatus);

        // Now you can proceed with saving the order
        orderService.createOrder(order);

        return "redirect:/orders/save";
    }

    @GetMapping("/edit/{orderId}")
    public String showEditOrderForm(@PathVariable Long orderId, Model model) {
        OrdreEntity order = orderService.getOrderById(orderId);
        List<Client> clients = clientService.getClients();
        List<Product> products = productService.getAllProducts();

        model.addAttribute("order", order);
        model.addAttribute("clients", clients);
        model.addAttribute("products", products);
        model.addAttribute("orderStatus", OrderStatus.values());

        return "edit-order";
    }

    @PostMapping("/edit/{orderId}")
    public String editOrder(@PathVariable Long orderId, @ModelAttribute OrdreEntity updatedOrder) {
        orderService.updateOrder(orderId, updatedOrder);
        return "redirect:/orders/list";
    }

    @GetMapping("/delete/{orderId}")
    public String showDeleteOrderConfirmation(@PathVariable Long orderId, Model model) {
        OrdreEntity order = orderService.getOrderById(orderId);
        model.addAttribute("order", order);
        return "delete-order";
    }

    @PostMapping("/delete/{orderId}")
    public String deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return "redirect:/orders/list";
    }
    @PostMapping("/save")
    public String saveOrder(@ModelAttribute OrdreEntity order,
                            @RequestParam("clientId") Long clientId,
                            @RequestParam("productIds") List<Long> productIds,
                            @RequestParam("orderStatus") OrderStatus orderStatus) {
        // Convert simple types to corresponding objects
        Client client = clientService.getClient(Math.toIntExact(clientId));
        Set<Product> products = (Set<Product>) productService.getProductsByIds(productIds);

        // Set converted objects in the order
        order.setClient(client);
        order.setProducts(products);
        order.setStatus(orderStatus);

        // Now you can proceed with saving the order
        orderService.createOrder(order);

        return "redirect:/orders/list";
    }


}
