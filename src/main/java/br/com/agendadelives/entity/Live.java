package br.com.agendadelives.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
public class Live {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDateTime data;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    public LocalTime horario;

    @NotNull
    public String titulo;

    @NotNull
    public String descricao;

    @NotNull
    public String linkLive;

    @NotNull
    public String genero;

    @NotNull
    public String linkCanal;

    @NotNull
    public String linkInstagram;

}
