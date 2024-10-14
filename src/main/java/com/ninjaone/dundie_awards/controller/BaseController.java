package com.ninjaone.dundie_awards.controller;

import com.ninjaone.dundie_awards.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController<K> {

    private BaseService<K> baseService;

    public BaseController(BaseService<K> baseService) {
        this.baseService = baseService;
    }

    // create employee rest api
    @PostMapping("/")
    @ResponseBody
    public K create(@RequestBody K k) {
        return baseService.create(k);
    }

    // get employee by id rest api
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<K> getById(@PathVariable Long id) {
        return ResponseEntity.of(baseService.get(id));
    }

    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<K>> getAll() {
        return ResponseEntity.ok(baseService.getAll());
    }

    // update employee rest api
    @PutMapping("/{id}")
    @ResponseBody
    public K update(@PathVariable Long id, @RequestBody K details) {
        return baseService.update(id, details);

    }

    // delete employee rest api
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Boolean>> deleteById(@PathVariable Long id) {
        baseService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
