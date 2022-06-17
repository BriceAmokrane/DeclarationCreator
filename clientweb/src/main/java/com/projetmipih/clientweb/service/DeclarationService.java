package com.projetmipih.clientweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetmipih.clientweb.model.Declaration;
import com.projetmipih.clientweb.repository.DeclarationProxy;

import lombok.Data;

@Data
@Service
public class DeclarationService {

    @Autowired
    private DeclarationProxy employeeProxy;

    public Declaration getEmployee(final int id) {
        return employeeProxy.getDeclaration(id);
    }

    public Iterable<Declaration> getEmployees() {
        return employeeProxy.getDeclarations();
    }

    public void deleteEmployee(final int id) {
        employeeProxy.deleteDeclaration(id);;
    }

     public Declaration saveEmployee(Declaration declaration) {
        Declaration savedDeclaration;

        declaration.setNomEmploye(declaration.getNomEmploye().toUpperCase());

        savedDeclaration = employeeProxy.createEmployee(declaration);
    
        return savedDeclaration;
    }
     

}