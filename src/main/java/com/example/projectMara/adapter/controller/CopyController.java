package com.example.projectMara.adapter.controller;

import com.example.projectMara.adapter.dto.CopyDto;
import com.example.projectMara.adapter.dto.MovieDto;
import com.example.projectMara.adapter.dto.MovieMainPageDto;
import com.example.projectMara.domain.model.MovieGenre;
import com.example.projectMara.usecase.adminpanel.AddCopyToCentralStore;
import com.example.projectMara.usecase.adminpanel.exception.MovieAlreadyPresentException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("catalogue/copy")
@RequiredArgsConstructor

public class CopyController {

    @Autowired
    private AddCopyToCentralStore addCopyToCentralStore;

    @GetMapping("addCopy{id}")
    public CopyDto getById(@PathVariable int id, @RequestParam int quantity){
        return this.addCopyToCentralStore.add (id, quantity);
    }

}
