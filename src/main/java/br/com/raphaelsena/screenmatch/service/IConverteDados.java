package br.com.raphaelsena.screenmatch.service;

public interface IConverteDados {

    // Generics
    <T> T obterDados(String json, Class<T> classe);
}
