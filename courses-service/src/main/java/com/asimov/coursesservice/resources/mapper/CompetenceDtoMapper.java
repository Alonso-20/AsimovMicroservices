package com.asimov.coursesservice.resources.mapper;

import com.asimov.coursesservice.entity.Competence;
import com.asimov.coursesservice.resources.CompetenceDto;
import org.springframework.stereotype.Component;

@Component
public class CompetenceDtoMapper {
    public CompetenceDto mapTo(Competence entity){
        CompetenceDto competenceDto = new CompetenceDto();
        competenceDto.setDescription(entity.getDescription());
        competenceDto.setTitle(entity.getTitle());

        return competenceDto;
    }

    public Competence mapFrom(CompetenceDto dto){
        Competence competence = Competence.builder()
                .description(dto.getDescription())
                .title(dto.getTitle()).build();

        return competence;
    }
}
