package org.example;

import org.example.model.Mao;
import org.example.model.Resultado;
import org.example.service.JokenpoService;

public class Main {
    public static void main(String[] args) {
        Mao primeiraMao = new Mao(JokenpoService.getRandomGesto());
        Mao segundaMao = new Mao(JokenpoService.getRandomGesto());

        Resultado resultado = JokenpoService.avaliarPartida(primeiraMao, segundaMao);

        String retorno = JokenpoService.retorno(resultado);

        System.out.println("Resultado: " + primeiraMao.gesto().nome() + retorno + segundaMao.gesto().nome());
    }
}
