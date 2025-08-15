package com.alura.forum.service;

import com.alura.forum.dto.AtualizaTopicoDTO;
import com.alura.forum.dto.DadosDetalhamentoTopico;
import com.alura.forum.dto.TopicoDTO;
import com.alura.forum.model.Topico;
import com.alura.forum.model.TopicoRecord;
import com.alura.forum.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public ResponseEntity cadastrarTopico(@Valid TopicoRecord topicoRecord, UriComponentsBuilder uriBuilder) {
        Topico topico = new Topico(topicoRecord);
        topicoRepository.save(topico);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    public ResponseEntity<Page<TopicoDTO>> listarTopicos(Pageable paginacao){
        var page = topicoRepository.findAll(paginacao).map(TopicoDTO::new);
        return ResponseEntity.ok(page);
    }

    public ResponseEntity detalharTopico(Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    public ResponseEntity atualizarTopico(@Valid AtualizaTopicoDTO dto) {
        Topico topico = topicoRepository.getReferenceById(dto.id());
        topico.atualizarDados(dto);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    public ResponseEntity deletarTopico(Long id) {
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
