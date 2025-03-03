package com.gabriel.workshift.repositories;

import com.gabriel.workshift.domain.jobTitle.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleRepository extends JpaRepository<JobTitle, Long> {
}
