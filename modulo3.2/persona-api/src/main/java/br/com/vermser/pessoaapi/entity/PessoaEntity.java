package br.com.vermser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="PESSOA")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "CPF", nullable = false, length = 11)
    private String cpf;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @JsonIgnore
    @OneToOne(mappedBy = "pessoa")
    private PetEntity pet;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoaEntity",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<ContatoEntity> contatos;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PESSOA_X_PESSOA_ENDERECO",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco")
    )
    private Set<EnderecoEntity> enderecos;

}
