package br.com.raphaelsena.sreenmatch.service;

public interface IConverteDados {

    // Generics
    <T> T obterDados(String json, Class<T> classe);
}
