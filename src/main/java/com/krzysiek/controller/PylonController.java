package com.krzysiek.controller;

import com.krzysiek.entities.Pylon;
import com.krzysiek.repo.PylonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@RestController
@RequestMapping("/pylon")
public class PylonController {
    @Autowired
    private PylonRepository pylonRepository;

    @RequestMapping(value = "/tt/{pylonId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Optional<Pylon>> getPylon(@PathVariable("pylonId") Long pylonid) {

        Optional<Pylon> pylons= pylonRepository.findById(pylonid);
        Map<String, Optional<Pylon>> pylonsMap = new TreeMap<>();
        pylonsMap.put("getpylons", pylons);

        return pylonsMap;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, headers = {"content-type=application/x-www-form-urlencoded"})
    public Map<String, List<Pylon>> getPylonsMap(WebRequest request) {
        Long taskid= Long.parseLong(request.getParameter("taskid"));

        List<Pylon> pylons= pylonRepository.findPylonsByTaskId(taskid);
        Map<String, List<Pylon>> pylonsMap = new TreeMap<>();
        pylonsMap.put("getpylons", pylons);
        return pylonsMap;
    }
}
