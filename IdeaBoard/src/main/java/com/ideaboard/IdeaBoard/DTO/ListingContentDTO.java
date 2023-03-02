package com.ideaboard.IdeaBoard.DTO;

import com.ideaboard.IdeaBoard.CustomAnnotation.ApprovalLevel;
import com.ideaboard.IdeaBoard.Util.ApprovalLevelMode;
import com.ideaboard.IdeaBoard.Util.ListingSectionType;

import java.util.*;

public class ListingContentDTO {
    public static class Document{
        int id;
        String Name;

        public Document(int id, String name) {
            this.id = id;
            Name = name;
        }
    }

    public static class Feature{

        @ApprovalLevel(sectionName = ListingSectionType.BENEFITS_AND_FEATURES, commentFieldName = "featureTitle", approvalMode = ApprovalLevelMode.FIELD_LEVEL)
        String Title;
        @ApprovalLevel(sectionName = ListingSectionType.BENEFITS_AND_FEATURES, commentFieldName = "featureDescription", approvalMode = ApprovalLevelMode.FIELD_LEVEL)
        String Description;

        public Feature(String title, String description, List<Document> images, Document featureImage) {
            Title = title;
            Description = description;
            this.images = images;
            FeatureImage = featureImage;
        }
        @ApprovalLevel(sectionName = ListingSectionType.BENEFITS_AND_FEATURES, commentFieldName = "featureImages", approvalMode = ApprovalLevelMode.EVERY_OBJECT_IN_LIST)
        List<Document> images;

        @ApprovalLevel(sectionName = ListingSectionType.BENEFITS_AND_FEATURES, commentFieldName = "FeatureImageLogo", approvalMode = ApprovalLevelMode.OBJECT_LEVEL)
        Document FeatureImage;
    }

    public ListingContentDTO(Document productLogoDocument, String solutionName, String shortDescription, List<Document> imageGallery, List<Document> benefits, Feature feature) {
        this.productLogoDocument = productLogoDocument;
        this.solutionName = solutionName;
        this.shortDescription = shortDescription;
        this.imageGallery = imageGallery;
        this.benefits = benefits;
        this.feature = feature;
    }

    public ListingContentDTO(Document productLogoDocument, String solutionName, String shortDescription, List<Document> images) {
        this.productLogoDocument = productLogoDocument;
        this.solutionName = solutionName;
        this.shortDescription = shortDescription;
        this.imageGallery = images;
    }
    @ApprovalLevel(sectionName = ListingSectionType.AT_A_GLANCE, commentFieldName = "productLogo", approvalMode = ApprovalLevelMode.OBJECT_LEVEL)
    Document productLogoDocument;
    @ApprovalLevel(sectionName = ListingSectionType.AT_A_GLANCE, commentFieldName = "productName", approvalMode = ApprovalLevelMode.FIELD_LEVEL)
    String solutionName;
    @ApprovalLevel(sectionName = ListingSectionType.AT_A_GLANCE, commentFieldName = "shortDescription", approvalMode = ApprovalLevelMode.FIELD_LEVEL)
    String shortDescription;
    @ApprovalLevel(sectionName = ListingSectionType.AT_A_GLANCE, commentFieldName = "image", approvalMode = ApprovalLevelMode.EVERY_OBJECT_IN_LIST)
    List<Document> imageGallery;

    @ApprovalLevel(sectionName = ListingSectionType.BENEFITS_AND_FEATURES, commentFieldName = "Benefits", approvalMode = ApprovalLevelMode.OBJECT_LEVEL)
    List<Document> benefits;

    @ApprovalLevel(sectionName = ListingSectionType.BENEFITS_AND_FEATURES, commentFieldName = "Benefits", approvalMode = ApprovalLevelMode.OBJECT_PROPERTY_LEVEL)
    Feature feature;
}
