package com.ideaboard.IdeaBoard.message;

public class UploadProjectResponse {
    public UploadProjectResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
