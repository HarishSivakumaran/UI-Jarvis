package com.ideaboard.IdeaBoard.CustomAnnotation;

import com.ideaboard.IdeaBoard.Util.ApprovalLevelMode;

public @interface ApprovalLevel {
    String sectionName() default "";

    String commentFieldName() default "";

    ApprovalLevelMode approvalMode();

}
