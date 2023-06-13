package com.ibrplanner.customers.dtos;

import com.ibrplanner.customers.entities.Client;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

public class ClientDTO {

    @NotBlank(message = "O nome não pode ser vazio.")
    private String name;

    @CPF(message = "O CPF informado não é válido.")
    private String cpf;

    @NotNull
    @DecimalMin("0.0")
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

    public ClientDTO(String name, String cpf, @NotNull Double income, @NotNull LocalDate birthDate, @NotNull Integer children) {
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
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
