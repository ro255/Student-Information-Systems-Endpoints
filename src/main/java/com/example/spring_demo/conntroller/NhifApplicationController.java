package com.example.spring_demo.conntroller;
import com.example.spring_demo.models.NhifApplication;
import com.example.spring_demo.responses.ApiResponse;
import com.example.spring_demo.respositories.NhifApplicationRepository;
import com.example.spring_demo.services.NhifApplicationServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/auth/v1/nhifCard")
@RequiredArgsConstructor

public class NhifApplicationController {

  private final NhifApplicationServices nhifApplicationServices;
  private final NhifApplicationRepository nhifApplicationRepository;


  @PostMapping
  public ResponseEntity<?> nhifApplication(@RequestBody NhifApplicationRequest request){
    return ResponseEntity.ok().build();
  }



  @GetMapping("/applicants")
  public ResponseEntity<List<NhifApplication>> getApplicants(){
    List<NhifApplication> nhifApplication=nhifApplicationRepository.findAll();
    if(nhifApplication.isEmpty()){
     throw new NullPointerException("No applicants found");
    } try {
      ApiResponse<List<NhifApplication>> apiResponse =new ApiResponse<>(
        HttpStatus.OK.value(),
        "Applicant found",
        nhifApplication
      );
   return  ResponseEntity.ok(apiResponse.getData());
    } catch (Exception e) {
      ApiResponse<List<NhifApplication>> apiResponse =new ApiResponse<> (
        HttpStatus.BAD_REQUEST.value(),
        "Applicant not found",
        null
      );
      return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
    }

  }


  @PatchMapping("/nhifCard")
  public ResponseEntity<?> UpdateNhifCard(@PathVariable Long cardId, @RequestBody NhifApplicationRequest request){

   try {
     NhifApplication nhifApplication= nhifApplicationRepository.findById(cardId).orElseThrow(() ->
       new NullPointerException("NhifApplication not found"));
       nhifApplication.setAmount(request.getAmount());
       nhifApplication.setCardNumber(Long.toString(cardId));
       nhifApplication.setControl_Number(Long.toString(cardId));
       nhifApplication.setNHIF_SubmissionResponse(request.getNHIF_SubmissionResponse());
       nhifApplication.setNHIF_SubmissionTime(String.valueOf(new Date()));
       nhifApplication.setAYear(request.getAYear());
       nhifApplication.setCardNumber(request.getCardNumber());
       nhifApplication.setFormIV_index(request.getFormIV_index());
       nhifApplication.setGender(request.getGender());
       nhifApplication.setIdentification_Number(request.getIdentification_Number());
       nhifApplication.setPhone(request.getPhone());
       nhifApplication.setRegistrationNo(request.getRegistrationNo());
       nhifApplication.setStatus(request.getStatus());
       nhifApplication.setYear(request.getYear());
       nhifApplicationRepository.save(nhifApplication);


   } catch (Exception e) {
     ApiResponse<List<NhifApplication>> apiResponse =new ApiResponse<> (
       HttpStatus.BAD_REQUEST.value(),
       "Update the NHIF Card Failed",
       null
     );
     return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
   }
   return ResponseEntity.ok().build();

  }


  @DeleteMapping("/nhifCard/{cardId}")
  public ResponseEntity<?> DeleteNhifCard(@PathVariable Long cardId){
    try{
      NhifApplication nhifApplication = nhifApplicationRepository.findById(cardId).orElseThrow(
        () -> new NoSuchElementException("NhifApplication not found with cardId:"+cardId)
      );
      nhifApplicationRepository.delete(nhifApplication);
      ApiResponse<Void> apiResponse =new ApiResponse<> (
        HttpStatus.OK.value(),
        "Application deleted successfully",
        null

      );
      return ResponseEntity.ok().body(apiResponse.getData());
    } catch (Exception e) {
      ApiResponse<Void> apiResponse =new ApiResponse<> (
        HttpStatus.BAD_REQUEST.value(),
        "Applications update failed",
        null
      );
      return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
    }
  }
}
