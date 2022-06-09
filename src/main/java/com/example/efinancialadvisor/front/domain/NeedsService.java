package com.example.efinancialadvisor.front.domain;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class NeedsService {

    private Set needs;
    private static NeedsService needsService;

    public NeedsService() {
        this.needs = definedNeeds();
    }

    public static NeedsService getInstance(){
        if (needsService == null){
            needsService = new NeedsService();
        }
        return needsService;
    }

    public Set getNeeds() {
        return needs;
    }

    public void addNeeds(Need need){
        this.needs.add(need);
    }

    private Set definedNeeds() {
        Set needs = new HashSet<>();
        needs.add(new Need("Kids future", 0));
        needs.add(new Need("House", 0));
        needs.add(new Need("Pension", 0));
        needs.add(new Need("Life insurance", 0));
        needs.add(new Need("Loans", 0));
        needs.add(new Need("Investments", 0));
        needs.add(new Need("Material insurance", 0));
        return needs;
    }
}
