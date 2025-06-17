package com.jereme;

import org.springframework.web.bind.annotation.*;

import java.util.List;



// think of the controller as the endpoint, where the user touches the api.
// the controller calls the service. the service is like the server between the database and
// the controller. it facilitates communication.
// the repository is the database connection, where we use JPA.
@RestController
@RequestMapping("api/v1/software-engineers") // set a base url for all endpoints in the class
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    // WARN: client to server needs to be transferred with DTO
    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    // WARN: server to client needs to be transferred with DTO
    @PostMapping
    public void addNewSoftwareEngineer(
            @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    // WARN: client to server needs to be transferred with DTO
    // get mapping now im specifying further beyond the default request mapping
    @GetMapping("{id}")
    public List<SoftwareEngineer> getSoftwareEngineerById(
            // im grabbing the path variable here
            @PathVariable Integer id
    ) {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }
}
