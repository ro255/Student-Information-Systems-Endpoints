package com.example.spring_demo.conntroller;

import com.example.spring_demo.models.IptApplication;
import com.example.spring_demo.responses.ApiResponse;
import com.example.spring_demo.respositories.IptApplicationRepository;
import com.example.spring_demo.services.IptApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class IptApplicationController {

  private final IptApplicationService iptservice;
  private final IptApplicationRepository iptrepository;

  @PostMapping("/ipt")
  public ResponseEntity<?> iptApplication(@RequestBody IptApplicationRequest request) {
    return ResponseEntity.ok().build();

  }
  @GetMapping("/ipt_applications")
  public ResponseEntity<?> iptApplications() {
    List<IptApplication> iptapplications = iptrepository.findAll();
    if (iptapplications.isEmpty()) {
      throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"No ipt application found");
    }
    try {


      ApiResponse<List<IptApplication>> apiResponse = new ApiResponse<>(
        HttpStatus.OK.value(),
        "The ipt applications was retrieved successfully",
        iptapplications
      );
      return ResponseEntity.ok(apiResponse);

    }
    catch(Exception e) {
      ApiResponse<List<IptApplication>> apiResponse = new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "The ipt application was not found",
        null
      );
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
    }

  }


  @PutMapping("/ipt/{applicationId}")
  public ResponseEntity<?> updateIptApplication(@PathVariable Long applicationId, @RequestBody IptApplicationRequest request) {
    try{
      IptApplication iptapplication = iptrepository.findById(applicationId).orElse(null);
      iptapplication.setInstitution(request.getInstitution());
      iptapplication.setSection(request.getSection());
      iptapplication.setRegion(request.getRegion());
      iptapplication.setAppliedDate(request.getAppliedDate());
       iptrepository.save(iptapplication);

       ApiResponse<IptApplication> apiResponse = new ApiResponse<>(
         HttpStatus.OK.value(),
         "The application sent successfully",
         iptapplication
       );
       return ResponseEntity.ok(apiResponse);

    } catch(Exception e) {
      ApiResponse<List<IptApplication>> apiResponse = new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "No ipt applications found:",
        null
      );
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
    }
  }

  @DeleteMapping("/ipt/{applicationId}")
  public ResponseEntity<?> deleteIptApplication(@PathVariable Long applicationId) {
    try{
      IptApplication iptapplication = iptrepository.findById(applicationId).orElse(null);
          iptrepository.delete(iptapplication);
          ApiResponse<IptApplication> apiResponse = new ApiResponse<>(
            HttpStatus.OK.value(),
            "The Ipt Application Deleted successfully",
            iptapplication
          );
          return ResponseEntity.ok(apiResponse);
    }  catch(Exception e) {
      ApiResponse<List<IptApplication>> apiResponse = new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "The Ipt Application was not deleted",
        null
      );
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
    }
  }

}
