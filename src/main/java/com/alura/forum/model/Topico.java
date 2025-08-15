package com.alura.forum.model;

import com.alura.forum.dto.AtualizaTopicoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String autor;

    private String curso;

    private LocalDateTime dataCriacao;

    public Topico(TopicoRecord topicoRecord) {
        this.titulo = topicoRecord.titulo();
        this.mensagem = topicoRecord.mensagem();
        this.status = Status.NAO_RESPONDIDO;
        this.autor = topicoRecord.autor();
        this.curso = topicoRecord.curso();
        this.dataCriacao = LocalDateTime.now();
    }

    public void atualizarDados(AtualizaTopicoDTO dto) {
        if (dto.titulo() != null){
            this.titulo = dto.titulo();
        }
        if (dto.mensagem() != null){
            this.mensagem = dto.mensagem();
        }

        this.status = Status.SOLUCIONADO;

    }
}
