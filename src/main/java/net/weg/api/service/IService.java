package net.weg.api.service;

import net.weg.api.model.DTO.IDTO;

import java.util.List;

public interface IService<T, ID> {

    void cadastrar(IDTO dto) throws Exception;
    void editar(IDTO dto) throws Exception;
    void deletar(ID id);
    T buscarUm(ID id);
    List<T> buscarTodos();

}
