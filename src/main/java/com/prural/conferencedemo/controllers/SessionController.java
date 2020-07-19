package com.prural.conferencedemo.controllers;

import com.prural.conferencedemo.models.Session;
import com.prural.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*Controllers takes the request from the user and communicate with repositories to perform various CRUD operations.
* */
@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    /*
    * It provides us the instance of repository interface so that we
    * can perform CRUD operation on sessions table in our database.
    * */
    @Autowired(required=false)
    private SessionRepository sessionRepository;

    /*GET request and it will provide all the sessions from the table.
    * */
    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    /*GET request and it will provide the specific session from the table by passing id/primaty key to it.
     * */
    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }

    /*POST request for adding a new session in session table.
    * */
    @PostMapping
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

    /*DELETE request for deleting the specific session from session table.
    * */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        sessionRepository.deleteById(id);
    }

    /*PUT request for updating the specific session in session table.
    * */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody final Session session){
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }


}
