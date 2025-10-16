package org.example.service;

import org.example.model.Gesto;
import org.example.model.Mao;
import org.example.model.Resultado;
import java.util.List;
import java.util.Random;


public class JokenpoService {
    private static final Random RANDOM = new Random();

    private static final String PEDRA = "Pedra";
    private static final String PAPEL = "Papel";
    private static final String TESOURA = "Tesoura";

    private static final Gesto PEDRA_GESTO = new Gesto(PEDRA, PAPEL, TESOURA);
    private static final Gesto PAPEL_GESTO = new Gesto(PAPEL, PEDRA, TESOURA);
    private static final Gesto TESOURA_GESTO = new Gesto(TESOURA, PAPEL, PEDRA);

    private static final List<Gesto> GESTOS = List.of(PEDRA_GESTO, PAPEL_GESTO, TESOURA_GESTO);
    public static Gesto getRandomGesto() {
        int randomIndex = RANDOM.nextInt(GESTOS.size());
        return GESTOS.get(randomIndex);
    }

    public static Resultado avaliarPartida(Mao primeiraMao, Mao segundaMao) {
        boolean vitoria = primeiraMao.gesto().venceContra().equals(
                segundaMao.gesto().nome()
        );
        if (vitoria)
            return Resultado.VITORIA;

        boolean derrota = primeiraMao.gesto().perdeContra().equals(
                segundaMao.gesto().nome()
        );
        if (derrota)
            return Resultado.DERROTA;

        return Resultado.EMPATE;
    }

    public static String retorno(Resultado resultado) {
        return switch (resultado) {
            case VITORIA -> " vence de ";
            case DERROTA -> " perde para ";
            case EMPATE -> " empata com ";
        };
    }
}
