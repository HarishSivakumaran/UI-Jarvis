package com.ideaboard.IdeaBoard.Repository;

import com.ideaboard.IdeaBoard.Model.ProjectDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectDBRepository extends JpaRepository<ProjectDB, UUID> {
}
