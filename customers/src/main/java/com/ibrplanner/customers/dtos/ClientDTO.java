package com.ibrplanner.customers.dtos;

import com.ibrplanner.customers.entities.Client;
import jakarta.validation.constraints.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;

    @NotBlank(message = "O nome não pode ser vazio.")
    private String name;

    @NotBlank
    private String cpf;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private Double income;

    @NotNull
    @PastOrPresent(message = "A data de nascimento não pode ser uma data futura.")
    private LocalDate birthDate;

    @NotNull
    @Min(0)
    private Integer children;

    // Utilizado para converter o Objeto em DTO no Service (findAll, )
    public ClientDTO(Client client) {
        BeanUtils.copyProperties(client, this);
    }

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}
