package com.ideaboard.IdeaBoard.Service;

import com.ideaboard.IdeaBoard.Model.ProjectDB;
import com.ideaboard.IdeaBoard.Repository.ProjectDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProjectStorageService {
    @Autowired
    private ProjectDBRepository projectDBRepository;

    public ProjectDB store(String name, String email, String url, MultipartFile file) throws IOException {
        ProjectDB projectDB = new ProjectDB(name,email,url, file.getBytes());
        return projectDBRepository.save(projectDB);
    }
}
