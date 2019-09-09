package com.qa.controllers;

import com.qa.models.Record;
import com.qa.repository.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()

public class RecordController {

    @Autowired
    private RecordsRepository repository;

    @RequestMapping(value = "records", method = RequestMethod.GET)

    public List<Record> listAllNotes(){
        return repository.findAll();
    }

    @RequestMapping(value = "records", method = RequestMethod.POST)

    public Record addNotes(@RequestBody Record note){
        return repository.saveAndFlush(note);
    }

    @RequestMapping(value = "records/{id}", method = RequestMethod.GET)
    public Record getNote(@PathVariable Long id){
        return repository.findOne(id);
    }

    @RequestMapping(value="records/{id}",method = RequestMethod.DELETE)
    public Record deleteNote(@PathVariable Long id){
        Record existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }
}
