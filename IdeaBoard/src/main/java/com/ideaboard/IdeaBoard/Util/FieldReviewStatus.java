package com.ideaboard.IdeaBoard.Util;

/**
 * Enum class for various field review status. PREVIOUSLY_APPROVED field status is introduced to distinguish if the field is previously approved or not, this
 * helps to identify the previously approved fields which are modified in next iteration
 */
public enum FieldReviewStatus {

    CLARIFICATION_REQUIRED,
    APPROVED,
    PREVIOUSLY_APPROVED,
    REVIEW_NOT_REQUIRED,

}
