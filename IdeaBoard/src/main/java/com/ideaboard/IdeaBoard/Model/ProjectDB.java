package com.ideaboard.IdeaBoard.Model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "project")
public class ProjectDB {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String email_id;

    private String project_url;

    @Lob
    private byte[] data;

    public ProjectDB(String name, String email_id, String project_url, byte[] data) {
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
