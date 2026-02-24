package com.ujmd.VetCare_API.repository;

import com.ujmd.VetCare_API.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OwnerRepository {

    private final Map<Long, Owner> owners = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Owner save(Owner owner) {
        if (owner.getId() == null) {
            owner.setId(idGenerator.getAndIncrement());
        }
        owners.put(owner.getId(), owner);
        return owner;
    }

    public List<Owner> findAll() {
        return new ArrayList<>(owners.values());
    }

    public Optional<Owner> findById(Long id) {
        return Optional.ofNullable(owners.get(id));
    }

    public void delete(Long id) {
        owners.remove(id);
    }
}