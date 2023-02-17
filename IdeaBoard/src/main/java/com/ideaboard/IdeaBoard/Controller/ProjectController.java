package com.ideaboard.IdeaBoard.Controller;

import com.ideaboard.IdeaBoard.DTO.ProjectDTO;
import com.ideaboard.IdeaBoard.Service.ProjectStorageService;
import com.ideaboard.IdeaBoard.message.UploadProjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ProjectController {
    @Autowired
    private ProjectStorageService projectStorageService;

    @PostMapping("/upload")
    public ResponseEntity<UploadProjectResponse> uploadProject(@ModelAttribute ProjectDTO projectDto) throws IOException {
        projectStorageService.store(projectDto.getName(), projectDto.getEmail_id(), projectDto.getProject_url(), projectDto.getData());
        return ResponseEntity.status(HttpStatus.OK).body(new UploadProjectResponse("Uploaded the file successfully:"));
    }

}
