package com.ibrplanner.customers.services;

import com.ibrplanner.customers.dtos.ClientDTO;
import com.ibrplanner.customers.entities.Client;
import com.ibrplanner.customers.repositories.ClientRepository;
import com.ibrplanner.customers.services.exceptions.DatabaseServiceException;
import com.ibrplanner.customers.services.exceptions.ResourceNotFoundServiceException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    /*
     * OBS: O service devolve DTO para o Controller
     * */

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clients = repository.findAll(pageable);
        return clients.map(ClientDTO::new);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundServiceException("Recurso não encontrado"));
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO save(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        client = repository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        try {
            Client client = repository.getReferenceById(id);
            copyDtoToEntity(clientDTO, client);
            client = repository.save(client);
            return new ClientDTO(client);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundServiceException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundServiceException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseServiceException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}
