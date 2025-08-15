package com.alura.forum.controller;

import com.alura.forum.dto.AtualizaTopicoDTO;
import com.alura.forum.dto.TopicoDTO;
import com.alura.forum.model.TopicoRecord;
import com.alura.forum.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid TopicoRecord topicoRecord, UriComponentsBuilder uriComponentsBuilder){
        return topicoService.cadastrarTopico(topicoRecord, uriComponentsBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<TopicoDTO>> listarTopicos(@PageableDefault(size = 5, sort = {"titulo"}) Pageable paginacao){
        return topicoService.listarTopicos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable Long id){
        return topicoService.detalharTopico(id);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarTopico(@RequestBody @Valid AtualizaTopicoDTO dto){
        return topicoService.atualizarTopico(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarTopico(@PathVariable Long id){
        return topicoService.deletarTopico(id);
    }


}
