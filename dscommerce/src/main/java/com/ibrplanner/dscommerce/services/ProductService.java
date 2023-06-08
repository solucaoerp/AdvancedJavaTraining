package com.ibrplanner.dscommerce.services;

import com.ibrplanner.dscommerce.dtos.ProductDTO;
import com.ibrplanner.dscommerce.entities.Product;
import com.ibrplanner.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    /*
     * OBS: O service devolve DTO para o Controller
     * */

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> result = productRepository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product); // Converte o Objeto para DTO (feito no Constructor do DTO)
        return dto;
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);

        // conversao com LAMBDA Expression
        return products.map(x -> new ProductDTO(x));
    }
}
