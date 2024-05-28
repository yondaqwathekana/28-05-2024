package za.ac.cput.service;

import za.ac.cput.domain.Bank;

import java.util.Set;

public interface IService <Entity, Identifier>{
    Entity create(Entity entity);
    Entity read(Identifier identifier);
    Entity update(Entity entity);

    Bank delete(Long bankRegistrationNumber);

    Set<Bank> getAll();
}