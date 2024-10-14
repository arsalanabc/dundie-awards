package com.ninjaone.dundie_awards.service;

import com.ninjaone.dundie_awards.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public class BaseService<K> {

    final BaseRepository<K> baseRepository;

    public BaseService(BaseRepository<K> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public Optional<K> get(Long id){ return baseRepository.findById(id);}

    public List<K> getAll(){
        return baseRepository.findAll();
    }

    public void delete(K k){
        baseRepository.delete(k);
    }

    public void deleteById(Long id){
        baseRepository.deleteById(id);
    }

//    TODO - check for ifExists before updating
    public K update(Long id, K k){
        return baseRepository.save(k);
    }

    public K update(K k){
        return baseRepository.save(k);
    }

    public K create(K k){
        return baseRepository.save(k);
    }
}
