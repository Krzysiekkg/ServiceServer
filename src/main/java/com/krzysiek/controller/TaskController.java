package com.krzysiek.controller;

import com.krzysiek.entities.Tasks;
import com.krzysiek.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = "/tt/{taskid}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    //musi to dzialac z tym optionalem pozniej to wyjasnim
    public Optional<Tasks> getTask(@PathVariable("taskid") Long userid) {

        return taskRepository.findById(userid);
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, List<Tasks>> requestOTP() {
        //Long i = Long.parseLong(body.get("taskid").toString());

        List<Tasks> tasks= taskRepository.findAll();
        Map<String, List<Tasks>> tasksMap = new TreeMap<>();
        tasksMap.put("gettasks", tasks);
        return tasksMap;

    }

    @RequestMapping(value = "/tt", method = RequestMethod.POST, headers = {"content-type=application/x-www-form-urlencoded"})
    public List<Tasks> getTasksMap(WebRequest request) {
        //long i= Long.parseLong(request.getParameter("userid"));
       /* List<Tasks> tasks= taskRepository.findAll();
        Map<String, List<Tasks>> tasksMap = new TreeMap<>();
        tasksMap.put("gettasks", tasks);*/
        return taskRepository.findAll();
    }
}
