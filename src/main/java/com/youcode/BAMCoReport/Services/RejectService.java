package com.youcode.BAMCoReport.Services;


import com.youcode.BAMCoReport.DTO.Models.RejectDTO;
import com.youcode.BAMCoReport.DTO.Services.IMapClassWithDto;
import com.youcode.BAMCoReport.Entities.Reject;
import com.youcode.BAMCoReport.Repositories.IRejectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;


import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class RejectService {

    @Autowired
    IMapClassWithDto<Reject, RejectDTO> rejectMapping;
    @Autowired
    IRejectRepository rejectRepository;



    public List<RejectDTO> getAllRejects() {
        List<Reject> rejectsList = rejectRepository.findAll();
        log.info("List of Rejects called successfully");
        return rejectMapping.convertListToListDto(rejectsList, RejectDTO.class);
    }



/*
    public String writeFile(MultipartFile file, long registrationNumber) throws Exception{

        String folder = "/docs/";
        byte[] fileBytes = file.getBytes();

        // get timestamps
        Date date = new Date();
        String time = String.valueOf(date.getTime());

        // get file extension
        String fileOriginalName = file.getOriginalFilename();
        String extension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));

        // set file name
        String fileName = registrationNumber + "_" + time + extension;

        //get path
        Path path = Paths.get(folder + fileName);

        // write file
        Files.write(path, fileBytes);

        return path.toString();
    }
*/






    //add method
    public ResponseEntity<String> addNewReject(Reject reject, MultipartFile file) {
        Optional<Reject> rejectOptional = rejectRepository.findRejectById(reject.getId());

        if(rejectOptional.isPresent()) {
            throw new IllegalStateException("This reject " + reject.getId() + " is already taken");
        }


        rejectRepository.save(reject);

        log.info("Reject added successfully");
        return new ResponseEntity<>("Reject added successfully", HttpStatus.OK);
    }


    public void updateReject(@RequestBody Reject reject) {
        rejectRepository.findById(reject.getId()).orElseThrow(
                ()-> new IllegalStateException("Reject with id " + reject.getId() + " does not exists")
        );

        rejectRepository.save(reject);
        log.info("User updated successfully");
    }


    public ResponseEntity<String> deleteReject(Long id) {
        boolean exists = rejectRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Reject with id " + id + " does not exists");
        }
        rejectRepository.deleteById(id);
        log.info("Reject deleted successfully", HttpStatus.OK);
    }


}
