package com.krzysiek.controller;

import com.krzysiek.entities.User;
import com.krzysiek.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/{userid}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    //musi to dzialac z tym optionalem pozniej to wyjasnim
    public Optional<User> getUser(@PathVariable("userid") Long userid) {

        return userRepository.findById(userid);
    }

    /*tego jeszcze nie skreślamy moze sie przydac
    @RequestMapping(value="/user",method = RequestMethod.POST)
     public Optional<User> requestOTP(@RequestBody Map<String, Object> body) {
         Long i = Long.parseLong(body.get("userid").toString());//Integer.parseInt(body.get("userid").toString());
         return userRepository.findById(i);
         //return customerService.requestOTP(body.get("idNumber").toString(), body.get("applicationId").toString());
     }
 */
    @RequestMapping(value = "/", method = RequestMethod.POST, headers = {"content-type=application/x-www-form-urlencoded"})
    public Optional<User> waboxapp(WebRequest request) {
        long i = Long.parseLong(request.getParameter("userid"));
        return userRepository.findById(i);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, headers = {"content-type=application/x-www-form-urlencoded"})
    public Map<String, User> loginUser(WebRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userRepository.findUserByLoginAndPassword(login, password);
        user.setPassword("");
        HttpStatus status = user != null ?
                HttpStatus.OK : HttpStatus.NOT_FOUND;

        Map<String, User> users = new TreeMap<>();
        users.put("user", user);
        return users;
    }
    //ttuaj tez dodac jakis feedback o przebiegu opertacjo
    @RequestMapping(value = "/register", method = RequestMethod.POST, headers = {"content-type=application/x-www-form-urlencoded"})
    public void registerUser(WebRequest request) {

        User u = new User();
        u.setLogin(request.getParameter("login"));
        u.setPassword(request.getParameter("password"));
        if(!userRepository.existsByLogin(u.getLogin()))
        userRepository.save(u);
        //respondy do sie doda kiedys
    }

    /*NOWE METODY*/
    //to jest ciekawa metoda pozwala na obsługe błędów
    @RequestMapping(value = "/logi", method = RequestMethod.POST, headers = {"content-type=application/x-www-form-urlencoded"})
    public ResponseEntity<User> spittleById(WebRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userRepository.findUserByLoginAndPassword(login, password);

        HttpStatus status = user != null ?
                HttpStatus.OK : HttpStatus.NOT_FOUND;


        return new ResponseEntity<User>(user, status);
    }
    /*@RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody Spittle spittleById(@PathVariable long id) {
        return spittleRepository.findOne(id);
    }
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Spittle> spittleById(@PathVariable long id) {
        Spittle spittle = spittleRepository.findOne(id);
        HttpStatus status = spittle != null ?
                HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Spittle>(spittle, status);
    }*/
}