package com.ideaboard.IdeaBoard.DTO;

import jakarta.persistence.Lob;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public class ProjectDTO {
    private UUID id;

    private String name;

    private String email_id;

    private String project_url;

    private MultipartFile data;

    public ProjectDTO(String name, String email_id, String project_url, MultipartFile data) {
        this.name = name;
        this.email_id = email_id;
        this.project_url = project_url;
        this.data = data;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getProject_url() {
        return project_url;
    }

    public void setProject_url(String project_url) {
        this.project_url = project_url;
    }

    public MultipartFile getData() {
        return data;
    }

    public void setData(MultipartFile data) {
        this.data = data;
    }
}
