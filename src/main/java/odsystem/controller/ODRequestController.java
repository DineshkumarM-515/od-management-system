package odsystem.controller;

import odsystem.entity.ODRequest;
import odsystem.service.ODRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/od")
@CrossOrigin("*")
public class ODRequestController {

    @Autowired
    private ODRequestService service;

    // Apply OD
    @PostMapping("/apply")
    public ODRequest applyOD(@RequestBody ODRequest request) {

        return service.saveRequest(request);
    }

    // Get All Requests
    @GetMapping("/all")
    public List<ODRequest> getAllRequests() {

        return service.getAllRequests();
    }

    //Proctor Approval -> AC
    @PutMapping("/proctor/approve/{id}")
    public ODRequest approveByProctor(@PathVariable Long id) {
        return service.approveByProctor(id);
    }

    //Proctor Rejects
    @PutMapping("/proctor/reject/{id}")
    public ODRequest rejectByProctor(
            @PathVariable Long id,
            @RequestParam String reason) {

            return service.rejectByProctor(id, reason);
    }

    //AC approval -> HoD
    @PutMapping("/ac/approve/{id}")
    public ODRequest approveByAC(@PathVariable Long id) {
        return service.approveByAC(id);
    }

    //AC Rejects
    @PutMapping("/ac/reject/{id}")
    public ODRequest rejectByAC(
            @PathVariable Long id,
            @RequestParam String reason) {

        return service.rejectByAC(id, reason);
    }

    //HoD Approved
    @PutMapping("/hod/approve/{id}")
    public ODRequest approveByHOD(@PathVariable Long id) {
        return service.approveByHOD(id);
    }

    //HoD Rejected
    @PutMapping("/hod/reject/{id}")
    public ODRequest rejectByHOD(
            @PathVariable Long id,
            @RequestParam String reason) {

        return service.rejectByHOD(id, reason);
    }
    
}