package com.alura.forum.dto;

import com.alura.forum.model.Status;
import com.alura.forum.model.Topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, Status status, String autor, String curso, LocalDateTime dataCriacao) {
    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getStatus(), topico.getAutor(), topico.getCurso(), topico.getDataCriacao());
    }
}
