package com.example.springhub.reactivecrud.util;

import com.example.springhub.reactivecrud.dto.TutorialDTO;
import com.example.springhub.reactivecrud.entity.Tutorial;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

public class ModelMapperUtil {

    public static Tutorial tutorialDtoToTutorial(TutorialDTO tutorialDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tutorialDTO,Tutorial.class);

    }

    public static TutorialDTO tutorialToTutorialDto(Tutorial tutorial){
        TutorialDTO tutorialDTO = new TutorialDTO();
        BeanUtils.copyProperties(tutorial,tutorialDTO);
        return tutorialDTO;
    }
}
