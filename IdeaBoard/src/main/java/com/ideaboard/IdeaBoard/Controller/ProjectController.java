package com.ideaboard.IdeaBoard.Controller;

import com.ideaboard.IdeaBoard.CustomAnnotation.ApprovalLevel;
import com.ideaboard.IdeaBoard.DTO.ApprovalCommentDTO;
import com.ideaboard.IdeaBoard.DTO.ListingContentDTO;
import com.ideaboard.IdeaBoard.DTO.ProjectDTO;
import com.ideaboard.IdeaBoard.Service.ProjectStorageService;
import com.ideaboard.IdeaBoard.Util.FieldReviewStatus;
import com.ideaboard.IdeaBoard.Util.ListingSectionType;
import com.ideaboard.IdeaBoard.message.UploadProjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    private ProjectStorageService projectStorageService;

    @PostMapping("/upload")
    public ResponseEntity<UploadProjectResponse> uploadProject(@ModelAttribute ProjectDTO projectDto) throws IOException {
        projectStorageService.store(projectDto.getName(), projectDto.getEmail_id(), projectDto.getProject_url(), projectDto.getData());
        return ResponseEntity.status(HttpStatus.OK).body(new UploadProjectResponse("Uploaded the file successfully:"));
    }

    @PostMapping("/approve")
    public void uploadProject() throws IOException, IllegalAccessException {
        List<ApprovalCommentDTO> comments = getComments();

        ListingContentDTO content = getContentData();

        // getting the ListingContent converted to Approval comments keys
        HashSet<String> set = getContentMappedSet(content,  new HashSet<String>());

        for(ApprovalCommentDTO approvalComment : comments){
            String key = generatekey(approvalComment.getSectionName().toString(), approvalComment.getFieldName(), approvalComment.getOrdinal());
            if(set.contains(key)){
                set.remove(key);
            }
        }

        if(set.size() != 0){
            //some required fields are yet to be approved, so don't approve the event
        }




    }

    public <T> HashSet<String> getContentMappedSet(T content, HashSet<String> set) throws IllegalAccessException {
        for(Field field : content.getClass().getDeclaredFields()){
            ApprovalLevel fieldAnnotation = field.getAnnotation(ApprovalLevel.class);
            switch(fieldAnnotation.approvalMode()){
                case FIELD_LEVEL:
                case OBJECT_LEVEL:
                    set.add(generatekey(fieldAnnotation.sectionName().toString(), fieldAnnotation.commentFieldName(), 0));
                    break;
                case EVERY_OBJECT_IN_LIST:
                    field.setAccessible(true);
                    List<Object> lists = (List<Object>) field.get(content);
                    int i = 1;
                    for(Object o : lists){
                       set.add(generatekey(fieldAnnotation.sectionName().toString(), fieldAnnotation.commentFieldName(), i++));
                    }
                    break;
                case OBJECT_PROPERTY_LEVEL:
                    field.setAccessible(true);
                    getContentMappedSet(field.get(content), set);
                    break;
            }
        }

        return set;

    }

    private List<ApprovalCommentDTO> getComments(){
        List<ApprovalCommentDTO> comments = new ArrayList<>();
        comments.add(new ApprovalCommentDTO(1, "productLogo",  ListingSectionType.AT_A_GLANCE, "", 0, FieldReviewStatus.APPROVED));
        comments.add(new ApprovalCommentDTO(2, "productName",  ListingSectionType.AT_A_GLANCE, "", 0, FieldReviewStatus.APPROVED));
        comments.add(new ApprovalCommentDTO(3, "shortDescription",  ListingSectionType.AT_A_GLANCE, "", 0, FieldReviewStatus.APPROVED));
        comments.add(new ApprovalCommentDTO(4, "image",  ListingSectionType.AT_A_GLANCE, "", 1, FieldReviewStatus.APPROVED));
        comments.add(new ApprovalCommentDTO(5, "image",  ListingSectionType.AT_A_GLANCE, "", 2, FieldReviewStatus.APPROVED));
        comments.add(new ApprovalCommentDTO(6, "image",  ListingSectionType.AT_A_GLANCE, "", 3, FieldReviewStatus.APPROVED));
        return comments;
    }

    private ListingContentDTO getContentData(){
        List<ListingContentDTO.Document> images = new ArrayList<>();
        images.add(new ListingContentDTO.Document(123, "image1"));
        images.add(new ListingContentDTO.Document(124, "image2"));
        images.add(new ListingContentDTO.Document(125, "image3"));

        List<ListingContentDTO.Document> benefits = new ArrayList<>();
        benefits.add(new ListingContentDTO.Document(123, "benefits1"));
        benefits.add(new ListingContentDTO.Document(124, "benefits2"));
        benefits.add(new ListingContentDTO.Document(125, "benefits3"));

//        List<ListingContentDTO.Feature> features = new ArrayList<>();
        ListingContentDTO.Feature feature = new ListingContentDTO.Feature("Feature 1", "descr 1", images, new ListingContentDTO.Document(124, "logo"));
        ListingContentDTO content = new ListingContentDTO(new ListingContentDTO.Document(12121, "some logo man"),"Product name", "some description", images, benefits, feature );

        return content;
    }

    private String generatekey(String sectionName, String field, int ordinal){
        return sectionName + "-" + field + "-" + ordinal;
    }

}
