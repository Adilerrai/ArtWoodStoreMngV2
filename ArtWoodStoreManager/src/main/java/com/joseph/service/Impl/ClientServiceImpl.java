package com.joseph.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseph.entity.Client;
import com.joseph.repository.ClientRepository;
import com.joseph.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClient(int id) {
        Optional<Client> result = clientRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}

