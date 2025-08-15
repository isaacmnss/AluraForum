package com.alura.forum.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizaTopicoDTO(

        @NotNull
        Long id,

        String titulo,
        String mensagem

) {
}
