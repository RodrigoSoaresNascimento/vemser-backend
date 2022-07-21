package br.com.vermser.pessoaapi.entity;

import br.com.vermser.pessoaapi.enums.TiposDeEndereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="CONTATO")
public class ContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "id_contato",nullable = false)
    private Integer idContato;

    @Column(name = "numero")
    private String numero;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "tipo")
    private TiposDeEndereco tipoContato;
    @Column(name = "id_pessoa",insertable = false, updatable = false)
    private Integer idPessoa;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "id_pessoa")
    private PessoaEntity pessoaEntity;

}
