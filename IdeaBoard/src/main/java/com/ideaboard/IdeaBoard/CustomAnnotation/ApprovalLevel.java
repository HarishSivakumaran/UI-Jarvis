package com.ideaboard.IdeaBoard.CustomAnnotation;

import com.ideaboard.IdeaBoard.Util.ApprovalLevelMode;
import com.ideaboard.IdeaBoard.Util.ListingSectionType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApprovalLevel {
    ListingSectionType sectionName();

    String commentFieldName() default "";

    ApprovalLevelMode approvalMode();

}
