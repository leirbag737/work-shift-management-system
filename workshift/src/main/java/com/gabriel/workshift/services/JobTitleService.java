package com.gabriel.workshift.services;

import com.gabriel.workshift.domain.jobTitle.JobTitle;
import com.gabriel.workshift.domain.jobTitle.dto.JobTitlePageDTO;
import com.gabriel.workshift.domain.jobTitle.dto.JobTitleRequestDTO;
import com.gabriel.workshift.domain.jobTitle.dto.JobTitleResponseDTO;
import com.gabriel.workshift.exceptions.RecordNotFoundException;
import com.gabriel.workshift.repositories.JobTitleRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;


    public JobTitleResponseDTO create(@Valid JobTitleRequestDTO data) {
        JobTitle newJobTitle = new JobTitle(data.name());
        return new JobTitleResponseDTO(jobTitleRepository.save(newJobTitle));
    }

    public JobTitleResponseDTO getById(@NotNull @Positive Long id) {
        JobTitle foundJobTitle = jobTitleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
        return new JobTitleResponseDTO(foundJobTitle);
    }

    public List<JobTitleResponseDTO> list() {
        return jobTitleRepository.findAll()
                .stream()
                .map(JobTitleResponseDTO::new)
                .toList();
    }

    public JobTitlePageDTO list(@PositiveOrZero int page, @Positive @Max(1000) int pageSize) {

        Page<JobTitle> jobTitlesPage = jobTitleRepository.findAll(PageRequest.of(page, pageSize));
        List<JobTitleResponseDTO> list = jobTitlesPage.getContent().stream()
                .map(JobTitleResponseDTO::new)
                .toList();

        return new JobTitlePageDTO(list, jobTitlesPage.getTotalElements(), jobTitlesPage.getTotalPages());
    }

    public JobTitleResponseDTO update(@NotNull @Positive Long id, @Valid JobTitleRequestDTO data) {
        return jobTitleRepository.findById(id).map(
                jobTitleToUpdate -> {
                    jobTitleToUpdate.setName(data.name());
                    return new JobTitleResponseDTO(jobTitleRepository.save(jobTitleToUpdate));
                }
        ).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@Positive @NotNull Long id) {
        jobTitleRepository.delete(
                jobTitleRepository.findById(id)
                        .orElseThrow(() -> new RecordNotFoundException(id))
        );
    }

    public Long getRecordCount() {
        return jobTitleRepository.count();
    }
}
