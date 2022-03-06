package com.youcode.BAMCoReport.Controllers;

import com.youcode.BAMCoReport.DTO.Models.RejectDTO;
import com.youcode.BAMCoReport.Entities.Reject;
import com.youcode.BAMCoReport.Responses.Responses;
import com.youcode.BAMCoReport.Services.RejectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping(path = "/api/reject")
public class RejectController {


    private final RejectService rejectService;

    @Autowired
    public RejectController(RejectService rejectService) {
        this.rejectService = rejectService;
    }



    //Get methods
    @ApiOperation(
            value = "Get List of Rejects ",
            notes = "Show list of rejects from BAMCoReport database"
    )
    @GetMapping
    public List<RejectDTO> getAllRejects(){
        return  rejectService.getAllRejects();
    }




    //Post method
    @ApiOperation(
            value = "Add new reject ",
            notes = "Add new reject to BAMCoReport database"
    )
    @PostMapping(path = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    @ResponseBody
    public ResponseEntity<ResponseEntity<String>> addNewReject(@RequestPart("rejectName") Reject reject, @RequestPart("file") MultipartFile file){

        System.out.println("******************************** " + reject.getFlowType() + " ****** " + file.getOriginalFilename());
        ResponseEntity<String> newReject =  rejectService.addNewReject(reject,file);
        if(newReject != null)
            return ResponseEntity.ok().body(newReject);
        return ResponseEntity.status(400).build();
    }

   /* @PostMapping("/add")
    @ResponseBody
    public Responses addNewReject (@RequestPart String rejectName, @RequestPart MultipartFile file) {

        System.out.println(rejectName);
        System.out.println(file.getOriginalFilename());
        return new Responses("Reject file added successfully");
    }*/





    //Delete method
    @ApiOperation(
            value = "Delete user by ID",
            notes = "Provide an ID to delete a specific user from BAMCoReport database"
    )
    @DeleteMapping(path = "/delete/{id}")
    @ResponseBody
    public Responses deleteReject(@PathVariable("id") Long id){
        rejectService.deleteReject(id);
        return new Responses ("Reject deleted successfully");
    }




    //Update method
    @ApiOperation(
            value = "Update Reject",
            notes = "Update a specific reject"
    )
    @PutMapping("/update")
    @ResponseBody
    public Responses updateReject(@RequestBody Reject reject){
        rejectService.updateReject(reject);
        return new Responses ("Reject updated successfully");
    }


}
