package com.joseph.service;

import java.util.List;

import com.joseph.entity.Client;

public interface ClientService {
    List<Client> getClients();
    Client getClient(int id);
    void saveClient(Client client);
    void deleteClient(int id);

    List<Client> getAllClients();
}


