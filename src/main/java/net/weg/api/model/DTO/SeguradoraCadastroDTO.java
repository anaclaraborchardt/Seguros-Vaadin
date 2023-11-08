package net.weg.api.model.DTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import net.weg.api.model.Entity.Cliente;
import net.weg.api.model.Entity.Endereco;

import java.util.Set;

public class SeguradoraCadastroDTO implements IDTO{

    private Long cnpj;
    private String nome;
    private Endereco endereco;
    private Set<Cliente> clientes;

}
