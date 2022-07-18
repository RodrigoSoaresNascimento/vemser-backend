package br.com.vermser.pessoaapi.entity;

import br.com.vermser.pessoaapi.enums.TiposDeEndereco;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="CONTATO")
public class ContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "id_contato")
    private Integer idContato;

    @Column(name = "numero")
    private String numero;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "tipo")
    private String tipoEndereco;
    @Column(name = "id_pessoa")
    private Integer idPessoa;

}
