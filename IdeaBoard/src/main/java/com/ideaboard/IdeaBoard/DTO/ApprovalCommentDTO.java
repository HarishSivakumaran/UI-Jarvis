package com.ideaboard.IdeaBoard.DTO;

import com.ideaboard.IdeaBoard.Util.FieldReviewStatus;
import com.ideaboard.IdeaBoard.Util.ListingSectionType;

public class ApprovalCommentDTO {

    private Integer id;
    private String fieldName;
    private ListingSectionType sectionName;

    public ApprovalCommentDTO(Integer id, String fieldName, ListingSectionType sectionName, String comment, Integer ordinal, FieldReviewStatus reviewStatus) {
        this.id = id;
        this.fieldName = fieldName;
        this.sectionName = sectionName;
        this.comment = comment;
        this.ordinal = ordinal;
        this.reviewStatus = reviewStatus;
    }

    private String comment;

    public Integer getId() {
        return id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public ListingSectionType getSectionName() {
        return sectionName;
    }

    public String getComment() {
        return comment;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public FieldReviewStatus getReviewStatus() {
        return reviewStatus;
    }

    private Integer ordinal;
    private FieldReviewStatus reviewStatus;

    }
