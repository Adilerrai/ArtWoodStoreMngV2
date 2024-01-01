package com.joseph.service;

import com.joseph.entity.Client;
import com.joseph.entity.OrdreEntity;
import java.util.List;

public interface OrderService {

    List<OrdreEntity> getAllOrders();

    OrdreEntity getOrderById(Long orderId);

    OrdreEntity createOrder(OrdreEntity order);

    OrdreEntity updateOrder(Long orderId, OrdreEntity updatedOrder);

    void deleteOrder(Long orderId);

    List<Client> getAllClients();
}
