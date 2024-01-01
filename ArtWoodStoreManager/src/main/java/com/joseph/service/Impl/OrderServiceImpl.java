package com.joseph.service.Impl;

import com.joseph.entity.Client;
import com.joseph.entity.OrdreEntity;
import com.joseph.entity.OrderStatus;
import com.joseph.repository.ClientRepository;
import com.joseph.repository.OrderRepository;
import com.joseph.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<OrdreEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrdreEntity getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public OrdreEntity createOrder(OrdreEntity order) {
        // Perform any additional business logic before saving the order
        // For example, setting default values, validating data, etc.

        // Set initial status (e.g., PENDING) if not provided
        if (order.getStatus() == null) {
            order.setStatus(OrderStatus.PENDING);
        }

        return orderRepository.save(order);
    }

    @Override
    public OrdreEntity updateOrder(Long orderId, OrdreEntity updatedOrder) {
        // Retrieve the existing order from the database
        OrdreEntity existingOrder = orderRepository.findById(orderId).orElse(null);

        if (existingOrder != null) {
            // Update fields based on the new order information
            existingOrder.setClient(updatedOrder.getClient());
            existingOrder.setProducts(updatedOrder.getProducts());
            existingOrder.setStatus(updatedOrder.getStatus());

            // Save the updated order
            return orderRepository.save(existingOrder);
        } else {
            // Handle case where the order with the given ID is not found
            // You may throw an exception, return a specific response, etc.
            return null;
        }
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
