package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Museum controller class.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {
  private MuseumServiceInterface service;

  @Autowired
  public MuseumController(MuseumServiceInterface service) {
    this.service = service;
  }

  /**
   * Create Museum POST method.
   */
  @PostMapping
  public ResponseEntity<MuseumDto> createMuseum(@RequestBody MuseumCreationDto musem) {
    Museum museumModel = ModelDtoConverter.dtoToModel(musem);
    Museum museumCreated = this.service.createMuseum(museumModel);
    MuseumDto museumDto = ModelDtoConverter.modelToDto(museumCreated);
    return ResponseEntity.status(HttpStatus.CREATED).body(museumDto);
  }
}
