package com.javanauta.usuario.busiess.Converter;

import com.javanauta.usuario.busiess.dto.EnderecoDTO;
import com.javanauta.usuario.busiess.dto.TelefoneDTO;
import com.javanauta.usuario.busiess.dto.UsuarioDTO;
import com.javanauta.usuario.infrastructure.entity.Endereco;
import com.javanauta.usuario.infrastructure.entity.Telefone;
import com.javanauta.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefoneses(usuarioDTO.getTelefones()))
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS) {
        if (enderecoDTOS == null) {
            return List.of();
        }

        return enderecoDTOS.stream()
                .map(this::paraEndereco)
                .toList();
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .build();
    }

    public List<Telefone> paraListaTelefoneses(List<TelefoneDTO> telefoneDTOS) {
        if (telefoneDTOS == null) {
            return List.of();
        }

        return telefoneDTOS.stream()
                .map(this::paraTelefone)
                .toList();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO) {
        return Telefone.builder()
                .numero(telefoneDTO.getNumero() == null
                        ? null
                        : Long.valueOf(telefoneDTO.getNumero()))
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    public UsuarioDTO paraUsuarioDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .enderecos(paraListaEnderecoDTO(usuario.getEnderecos()))
                .telefones(paraListaTelefoneseDTO(usuario.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecos) {
        if (enderecos == null) {
            return List.of();
        }

        return enderecos.stream()
                .map(this::paraEndereco)
                .toList();
    }

    public EnderecoDTO paraEndereco(Endereco endereco) {
        return EnderecoDTO.builder()
                .id(endereco.getId())
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefoneseDTO(List<Telefone> telefones) {
        if (telefones == null) {
            return List.of();
        }

        return telefones.stream()
                .map(this::paraTelefone)
                .toList();
    }

    public TelefoneDTO paraTelefone(Telefone telefone) {
        return TelefoneDTO.builder()
                .id(telefone.getId())
                .numero(telefone.getNumero()
                        == null
                        ? null
                        : telefone.getNumero().toString())
                .ddd(telefone.getDdd())
                .build();
    }
    public Usuario updateUsuario(UsuarioDTO usuarioDTO, Usuario entity) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome() != null
                        ? usuarioDTO.getNome()
                        : entity.getNome())
                .id(entity.getId())
                .senha(usuarioDTO.getSenha() != null
                        ? usuarioDTO.getSenha()
                        : entity.getSenha())
                .email(usuarioDTO.getEmail() != null
                        ? usuarioDTO.getEmail()
                        : entity.getEmail())
                .enderecos(entity.getEnderecos())
                .telefones(entity.getTelefones())
                .build();
    }
    public Endereco updateEndereco(
            EnderecoDTO dto,
            Endereco entity
    ) {
        return Endereco.builder()
                .id(entity.getId())
                .rua(dto.getRua() != null
                        ? dto.getRua()
                        : entity.getRua())
                .bairro(entity.getBairro())
                .numero(dto.getNumero() != null
                        ? dto.getNumero()
                        : entity.getNumero())
                .complemento(dto.getComplemento() != null
                        ? dto.getComplemento()
                        : entity.getComplemento())
                .cidade(dto.getCidade() != null
                        ? dto.getCidade()
                        : entity.getCidade())
                .estado(dto.getEstado() != null
                        ? dto.getEstado()
                        : entity.getEstado())
                .cep(dto.getCep() != null
                        ? dto.getCep()
                        : entity.getCep())
                .build();
    }

    public Telefone updateTelefone(
            TelefoneDTO dto,
            Telefone entity
    ) {
        return Telefone.builder()
                .id(entity.getId())
                .numero(dto.getNumero() != null
                        ? Long.valueOf(dto.getNumero())
                        : entity.getNumero())
                .ddd(dto.getDdd() != null
                        ? dto.getDdd()
                        : entity.getDdd())
                .build();
    }
}
