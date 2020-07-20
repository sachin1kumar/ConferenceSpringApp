package com.prural.conferencedemo.controllers;

import com.prural.conferencedemo.models.Speaker;
import com.prural.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {
    /*
     * It provides us the instance of repository interface so that we
     * can perform CRUD operation on sessions table in our database.
     * */
    @Autowired
    private SpeakerRepository speakerRepository;

    /*GET request and it will provide all the speakers from the table.
     * */
    @GetMapping
    public List<Speaker> list(){
        return speakerRepository.findAll();
    }

    /*GET request and it will provide the specific speaker from the table by passing id/primaty key to it.
     * */
    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }

    /*POST request for adding a new speaker in speaker table.
     * */
    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    /*DELETE request for deleting the specific speaker from speaker table.
     * */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }

    /*PUT request for updating the specific speaker in speaker table.
     * */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody final Speaker speaker){
        Speaker existingSpeaker = speakerRepository.getOne(id);
        //igonring the primary key from updating.
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
