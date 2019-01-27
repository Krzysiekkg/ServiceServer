package com.krzysiek.controller;

import com.krzysiek.entities.Details;
import com.krzysiek.repo.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/details")
public class DetailController {

    @Autowired
    private DetailRepository detailRepository;


    @RequestMapping(value = "/", method = RequestMethod.POST, headers = {"content-type=application/x-www-form-urlencoded"})
    public Map<String, List<Details>> getPylonsMap(WebRequest request) {
        Long pylonid = Long.parseLong(request.getParameter("pylonid"));

        List<Details> details = detailRepository.findDetailsByPylonId(pylonid);
        Map<String, List<Details>> detailsMap = new TreeMap<>();
        detailsMap.put("getdetails", details);
        return detailsMap;
    }

    //dodac jakis feedback o przebiegu operacji
    @RequestMapping(value = "/senddetail", method = RequestMethod.PUT, headers = {"content-type=application/x-www-form-urlencoded"})
    public HttpStatus registerUser(WebRequest request) {

        Details d = new Details();
        d.setDetailId(Long.parseLong(request.getParameter("detailid")));
        d.setStatus(Integer.parseInt(request.getParameter("status")));

        if (detailRepository.existsByDetailsId(d.getDetailId())) {
            detailRepository.setDetailsStatus(d.getStatus(), d.getDetailId());
            //respondy do sie doda kiedys
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    //dodac jakis feedback o przebiegu operacji, narazie to object ale docelowo bedzie list
    @RequestMapping(value = "/senddetaillist", method = RequestMethod.PUT)
    public HttpStatus getDetailObject(@RequestBody List<Details> detailsList) {

       for(Details detail: detailsList){
           detailRepository.setDetailsStatus(detail.getStatus(),detail.getDetailId());
       }

        return HttpStatus.OK;
        }
    }


