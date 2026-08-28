package com.javanauta.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name= "endereco")
    @Builder

    public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


        private String rua;
        private String bairro;
        private String numero;
        private String complemento;
        private String estado;
        private String cidade;
        private String cep;




}
