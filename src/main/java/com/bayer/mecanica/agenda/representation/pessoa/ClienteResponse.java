package com.bayer.mecanica.agenda.representation.pessoa;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {
    private Long id;
    private String email;
    private String nome;
    private String username;
    private Integer servicos;
}
