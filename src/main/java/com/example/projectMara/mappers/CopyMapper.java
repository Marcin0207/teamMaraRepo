package com.example.projectMara.mappers;

import com.example.projectMara.adapter.dto.CopyDto;
import com.example.projectMara.domain.model.Copy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CopyMapper {
    public static CopyDto map(Copy copy){
        return CopyDto.builder()
                .id(copy.getId())
                .movie(copy.getMovie())
                .build();
    }
public static Copy map(CopyDto copyDto){
    return Copy.builder()
            .id(copyDto.getId())
            .movie(copyDto.getMovie())
            .build();
}

public static List<CopyDto> mapList(List<Copy> copyList){
        List<CopyDto> copyDtoList = copyList.stream()
            .map(copy -> map(copy))
            .collect(Collectors.toList());

        return copyDtoList;
}

}
