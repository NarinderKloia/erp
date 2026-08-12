package com.navi.erp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navi.erp.Dto.CreateProgramDto;
import com.navi.erp.Dto.ProgramDto;
import com.navi.erp.Service.Impl.ProgramServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/programs")
@AllArgsConstructor
public class ProgramController {
    private final ProgramServiceImpl service;

    @PostMapping
    public ResponseEntity<ProgramDto> createProgram(@RequestBody CreateProgramDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProgram(dto));

    };

    @GetMapping
    public ResponseEntity<List<ProgramDto>> getAllPrograms() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllPrograms());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramDto> updatePrograms(@PathVariable Long id, @RequestBody CreateProgramDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updatePrograms(id, dto));
    }

    // @PatchMapping("/{id}")
    // public ResponseEntity<ProgramDto> patchProgram(@PathVariable Long id, @RequestBody CreateProgramDto dto) {
    //     return ResponseEntity.status(HttpStatus.OK).body(service.patchProgram(id, dto));

    // };

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProgram(@PathVariable Long id) {
        service.deleteProgram(id);
        return ResponseEntity.status(HttpStatus.OK).body("Program Deleted Permanently");

    }

}
