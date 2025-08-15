package com.alura.forum.model;

import jakarta.validation.constraints.NotBlank;

public record TopicoRecord(

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotBlank
        String autor,

        @NotBlank
        String curso

) {
}
