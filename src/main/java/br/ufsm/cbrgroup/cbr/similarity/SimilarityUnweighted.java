package br.ufsm.cbrgroup.cbr.similarity;

import br.ufsm.cbrgroup.description.TrucoDescription;
import es.ucm.fdi.gaia.jcolibri.cbrcore.Attribute;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 21/05/2019.
 */


public class SimilarityUnweighted implements SimilarityStrategy {

    @Override
    public NNConfig getSimConfigEnvido(TrucoDescription gameStateQuery) {
        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        if (gameStateQuery.getJogadorMao() != null) {
            Attribute jogadorMao = new Attribute("jogadorMao", TrucoDescription.class);
            simConfig.addMapping(jogadorMao, new Equal());
            simConfig.setWeight(jogadorMao, 1.0);
        }

        if (gameStateQuery.getPontosEnvidoRobo() != null) {
            Attribute pontosEnvidoRobo = new Attribute("pontosEnvidoRobo", TrucoDescription.class);
            simConfig.addMapping(pontosEnvidoRobo, new Interval(33));
            simConfig.setWeight(pontosEnvidoRobo, 1.0);
        }

        if (gameStateQuery.getTentosAnterioresRobo() != null) {
            Attribute tentosAnterioresRobo = new Attribute("tentosAnterioresRobo", TrucoDescription.class);
            simConfig.addMapping(tentosAnterioresRobo, new Interval(24));
            simConfig.setWeight(tentosAnterioresRobo, 1.0);
        }

        if (gameStateQuery.getTentosAnterioresHumano() != null) {
            Attribute tentosAnterioresHumano = new Attribute("tentosAnterioresHumano", TrucoDescription.class);
            simConfig.addMapping(tentosAnterioresHumano, new Interval(24));
            simConfig.setWeight(tentosAnterioresHumano, 1.0);
        }

        if (gameStateQuery.getQuemPediuEnvido() != null) {
            Attribute quemPediuEnvido = new Attribute("quemPediuEnvido", TrucoDescription.class);
            simConfig.addMapping(quemPediuEnvido, new Equal());
            simConfig.setWeight(quemPediuEnvido, 1.0);
        }

        if (gameStateQuery.getQuemEnvidoEnvido() != null) {
            Attribute quemEnvidoEnvido = new Attribute("quemEnvidoEnvido", TrucoDescription.class);
            simConfig.addMapping(quemEnvidoEnvido, new Equal());
            simConfig.setWeight(quemEnvidoEnvido, 1.0);
        }

        if (gameStateQuery.getQuemPediuRealEnvido() != null) {
            Attribute quemPediuRealEnvido = new Attribute("quemPediuRealEnvido", TrucoDescription.class);
            simConfig.addMapping(quemPediuRealEnvido, new Equal());
            simConfig.setWeight(quemPediuRealEnvido, 1.0);
        }

        if (gameStateQuery.getQuemPediuFaltaEnvido() != null) {
            Attribute quemPediuFaltaEnvido = new Attribute("quemPediuFaltaEnvido", TrucoDescription.class);
            simConfig.addMapping(quemPediuFaltaEnvido, new Equal());
            simConfig.setWeight(quemPediuFaltaEnvido, 1.0);
        }

        if (gameStateQuery.getQuemGanhouEnvido() != null) {
            Attribute quemGanhouEnvido = new Attribute("quemGanhouEnvido", TrucoDescription.class);
            simConfig.addMapping(quemGanhouEnvido, new Equal());
            simConfig.setWeight(quemGanhouEnvido, 1.0);
        }

        if (gameStateQuery.getPrimeiraCartaHumano() != null) {
            Attribute primeiraCartaHumano = new Attribute("primeiraCartaHumano", TrucoDescription.class);
            simConfig.addMapping(primeiraCartaHumano, new Interval(52));
            simConfig.setWeight(primeiraCartaHumano, 1.0);
        }

        if (gameStateQuery.getHumanoCartaVirada() != null) {
            Attribute humanoCartaVirada = new Attribute("humanoCartaVirada", TrucoDescription.class);
            simConfig.addMapping(humanoCartaVirada, new Interval(3));
            simConfig.setWeight(humanoCartaVirada, 1.0);
        }

        return simConfig;
    }

    @Override
    public NNConfig getSimConfigFlor(TrucoDescription gameStateQuery) {
        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        if (gameStateQuery.getJogadorMao() != null) {
            Attribute jogadorMao = new Attribute("jogadorMao", TrucoDescription.class);
            simConfig.addMapping(jogadorMao, new Equal());
            simConfig.setWeight(jogadorMao, 1.0);
        }

        if (gameStateQuery.getPontosFlorRobo() != null) {
            Attribute pontosFlorRobo = new Attribute("pontosFlorRobo", TrucoDescription.class);
            simConfig.addMapping(pontosFlorRobo, new Interval(33));
            simConfig.setWeight(pontosFlorRobo, 1.0);
        }

        if (gameStateQuery.getTentosAnterioresRobo() != null) {
            Attribute tentosAnterioresRobo = new Attribute("tentosAnterioresRobo", TrucoDescription.class);
            simConfig.addMapping(tentosAnterioresRobo, new Interval(24));
            simConfig.setWeight(tentosAnterioresRobo, 1.0);
        }


        if (gameStateQuery.getTentosAnterioresHumano() != null) {
            Attribute tentosAnterioresHumano = new Attribute("tentosAnterioresHumano", TrucoDescription.class);
            simConfig.addMapping(tentosAnterioresHumano, new Interval(24));
            simConfig.setWeight(tentosAnterioresHumano, 1.0);
        }

        if (gameStateQuery.getQuemFlor() != null) {
            Attribute quemFlor = new Attribute("quemFlor", TrucoDescription.class);
            simConfig.addMapping(quemFlor, new Equal());
            simConfig.setWeight(quemFlor, 1.0);
        }

        if (gameStateQuery.getQuemFlorFlor() != null) {
            Attribute quemFlorFlor = new Attribute("quemFlorFlor", TrucoDescription.class);
            simConfig.addMapping(quemFlorFlor, new Equal());
            simConfig.setWeight(quemFlorFlor, 1.0);
        }

        if (gameStateQuery.getQuemContraFlor() != null) {
            Attribute quemContraFlor = new Attribute("quemContraFlor", TrucoDescription.class);
            simConfig.addMapping(quemContraFlor, new Equal());
            simConfig.setWeight(quemContraFlor, 1.0);
        }

        if (gameStateQuery.getQuemContraFlorFalta() != null) {
            Attribute quemContraFlorFalta = new Attribute("quemContraFlorFalta", TrucoDescription.class);
            simConfig.addMapping(quemContraFlorFalta, new Equal());
            simConfig.setWeight(quemContraFlorFalta, 1.0);
        }

        if (gameStateQuery.getQuemContraFlorResto() != null) {
            Attribute quemContraFlorResto = new Attribute("quemContraFlorResto", TrucoDescription.class);
            simConfig.addMapping(quemContraFlorResto, new Equal());
            simConfig.setWeight(quemContraFlorResto, 1.0);
        }

        if (gameStateQuery.getQuemGanhouFlor() != null) {
            Attribute quemGanhouFlor = new Attribute("quemGanhouFlor", TrucoDescription.class);
            simConfig.addMapping(quemGanhouFlor, new Equal());
            simConfig.setWeight(quemGanhouFlor, 1.0);
        }

        return simConfig;
    }

    @Override
    public NNConfig getSimConfigTruco(TrucoDescription gameStateQuery) {
        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        if (gameStateQuery.getJogadorMao() != null) {
            Attribute jogadorMao = new Attribute("jogadorMao", TrucoDescription.class);
            simConfig.addMapping(jogadorMao, new Equal());
            simConfig.setWeight(jogadorMao, 1.0);
        }

        if (gameStateQuery.getCartaAltaRobo() != null) {
            Attribute cartaAltaRobo = new Attribute("cartaAltaRobo", TrucoDescription.class);
            simConfig.addMapping(cartaAltaRobo, new Interval(52));
            simConfig.setWeight(cartaAltaRobo, 1.0);
        }

        if (gameStateQuery.getCartaMediaRobo() != null) {
            Attribute cartaMediaRobo = new Attribute("cartaMediaRobo", TrucoDescription.class);
            simConfig.addMapping(cartaMediaRobo, new Interval(52));
            simConfig.setWeight(cartaMediaRobo, 1.0);
        }

        if (gameStateQuery.getCartaBaixaRobo() != null) {
            Attribute cartaBaixaRobo = new Attribute("cartaBaixaRobo", TrucoDescription.class);
            simConfig.addMapping(cartaBaixaRobo, new Interval(52));
            simConfig.setWeight(cartaBaixaRobo, 1.0);
        }

        if (gameStateQuery.getTentosAnterioresRobo() != null) {
            Attribute tentosAnterioresRobo = new Attribute("tentosAnterioresRobo", TrucoDescription.class);
            simConfig.addMapping(tentosAnterioresRobo, new Interval(24));
            simConfig.setWeight(tentosAnterioresRobo, 1.0);
        }


        if (gameStateQuery.getTentosAnterioresHumano() != null) {
            Attribute tentosAnterioresHumano = new Attribute("tentosAnterioresHumano", TrucoDescription.class);
            simConfig.addMapping(tentosAnterioresHumano, new Interval(24));
            simConfig.setWeight(tentosAnterioresHumano, 1.0);
        }

        if (gameStateQuery.getQuemGanhouTruco() != null) {
            Attribute quemGanhouTruco = new Attribute("quemGanhouTruco", TrucoDescription.class);
            simConfig.addMapping(quemGanhouTruco, new Equal());
            simConfig.setWeight(quemGanhouTruco, 1.0);
        }

        if (gameStateQuery.getQuandoTruco() != null) {
            Attribute quandoTruco = new Attribute("quandoTruco", TrucoDescription.class);
            simConfig.addMapping(quandoTruco, new Equal());
            simConfig.setWeight(quandoTruco, 1.0);
        }

        if (gameStateQuery.getQuemTruco() != null) {
            Attribute quemTruco = new Attribute("quemTruco", TrucoDescription.class);
            simConfig.addMapping(quemTruco, new Equal());
            simConfig.setWeight(quemTruco, 1.0);
        }

        if (gameStateQuery.getQuemRetruco() != null) {
            Attribute quemRetruco = new Attribute("quemRetruco", TrucoDescription.class);
            simConfig.addMapping(quemRetruco, new Equal());
            simConfig.setWeight(quemRetruco, 1.0);
        }

        if (gameStateQuery.getQuemValeQuatro() != null) {
            Attribute quemValeQuatro = new Attribute("quemValeQuatro", TrucoDescription.class);
            simConfig.addMapping(quemValeQuatro, new Equal());
            simConfig.setWeight(quemValeQuatro, 1.0);
        }

        if (gameStateQuery.getGanhadorPrimeiraRodada() != null) {
            Attribute ganhadorPrimeiraRodada = new Attribute("ganhadorPrimeiraRodada", TrucoDescription.class);
            simConfig.addMapping(ganhadorPrimeiraRodada, new Equal());
            simConfig.setWeight(ganhadorPrimeiraRodada, 1.0);
        }

        if (gameStateQuery.getGanhadorSegundaRodada() != null) {
            Attribute ganhadorSegundaRodada = new Attribute("ganhadorSegundaRodada", TrucoDescription.class);
            simConfig.addMapping(ganhadorSegundaRodada, new Equal());
            simConfig.setWeight(ganhadorSegundaRodada, 1.0);
        }

        if (gameStateQuery.getPrimeiraCartaRobo() != null) {
            Attribute primeiraCartaRobo = new Attribute("primeiraCartaRobo", TrucoDescription.class);
            simConfig.addMapping(primeiraCartaRobo, new Interval(52));
            simConfig.setWeight(primeiraCartaRobo, 1.0);
        }

        if (gameStateQuery.getSegundaCartaRobo() != null) {
            Attribute segundaCartaRobo = new Attribute("segundaCartaRobo", TrucoDescription.class);
            simConfig.addMapping(segundaCartaRobo, new Interval(52));
            simConfig.setWeight(segundaCartaRobo, 1.0);
        }

        if (gameStateQuery.getTerceiraCartaRobo() != null) {
            Attribute terceiraCartaRobo = new Attribute("terceiraCartaRobo", TrucoDescription.class);
            simConfig.addMapping(terceiraCartaRobo, new Interval(52));
            simConfig.setWeight(terceiraCartaRobo, 1.0);
        }

        if (gameStateQuery.getPrimeiraCartaHumano() != null) {
            Attribute primeiraCartaHumano = new Attribute("primeiraCartaHumano", TrucoDescription.class);
            simConfig.addMapping(primeiraCartaHumano, new Interval(52));
            simConfig.setWeight(primeiraCartaHumano, 1.0);
        }

        if (gameStateQuery.getSegundaCartaHumano() != null) {
            Attribute segundaCartaHumano = new Attribute("segundaCartaHumano", TrucoDescription.class);
            simConfig.addMapping(segundaCartaHumano, new Interval(52));
            simConfig.setWeight(segundaCartaHumano, 1.0);
        }

        if (gameStateQuery.getTerceiraCartaHumano() != null) {
            Attribute terceiraCartaHumano = new Attribute("terceiraCartaHumano", TrucoDescription.class);
            simConfig.addMapping(terceiraCartaHumano, new Interval(52));
            simConfig.setWeight(terceiraCartaHumano, 1.0);
        }

        if (gameStateQuery.getRoboCartaVirada() != null) {
            Attribute roboCartaVirada = new Attribute("roboCartaVirada", TrucoDescription.class);
            simConfig.addMapping(roboCartaVirada, new Interval(3));
            simConfig.setWeight(roboCartaVirada, 1.0);
        }

        if (gameStateQuery.getHumanoCartaVirada() != null) {
            Attribute humanoCartaVirada = new Attribute("humanoCartaVirada", TrucoDescription.class);
            simConfig.addMapping(humanoCartaVirada, new Interval(3));
            simConfig.setWeight(humanoCartaVirada, 1.0);
        }

        return simConfig;
    }

    @Override
    public NNConfig getSimConfigPlayCard(TrucoDescription gameStateQuery) {
        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        if (gameStateQuery.getJogadorMao() != null) {
            Attribute jogadorMao = new Attribute("jogadorMao", TrucoDescription.class);
            simConfig.addMapping(jogadorMao, new Equal());
            simConfig.setWeight(jogadorMao, 1.0);
        }

        if (gameStateQuery.getCartaAltaRobo() != null) {
            Attribute cartaAltaRobo = new Attribute("cartaAltaRobo", TrucoDescription.class);
            simConfig.addMapping(cartaAltaRobo, new Interval(52));
            simConfig.setWeight(cartaAltaRobo, 1.0);
        }

        if (gameStateQuery.getCartaMediaRobo() != null) {
            Attribute cartaMediaRobo = new Attribute("cartaMediaRobo", TrucoDescription.class);
            simConfig.addMapping(cartaMediaRobo, new Interval(52));
            simConfig.setWeight(cartaMediaRobo, 1.0);
        }

        if (gameStateQuery.getCartaBaixaRobo() != null) {
            Attribute cartaBaixaRobo = new Attribute("cartaBaixaRobo", TrucoDescription.class);
            simConfig.addMapping(cartaBaixaRobo, new Interval(52));
            simConfig.setWeight(cartaBaixaRobo, 1.0);
        }

        if (gameStateQuery.getPrimeiraCartaRobo() != null) {
            Attribute primeiraCartaRobo = new Attribute("primeiraCartaRobo", TrucoDescription.class);
            simConfig.addMapping(primeiraCartaRobo, new Interval(52));
            simConfig.setWeight(primeiraCartaRobo, 1.0);
        }

        if (gameStateQuery.getSegundaCartaRobo() != null) {
            Attribute segundaCartaRobo = new Attribute("segundaCartaRobo", TrucoDescription.class);
            simConfig.addMapping(segundaCartaRobo, new Interval(52));
            simConfig.setWeight(segundaCartaRobo, 1.0);
        }

        if (gameStateQuery.getTerceiraCartaRobo() != null) {
            Attribute terceiraCartaRobo = new Attribute("terceiraCartaRobo", TrucoDescription.class);
            simConfig.addMapping(terceiraCartaRobo, new Interval(52));
            simConfig.setWeight(terceiraCartaRobo, 1.0);
        }

        if (gameStateQuery.getTentosAnterioresRobo() != null) {
            Attribute tentosAnterioresRobo = new Attribute("tentosAnterioresRobo", TrucoDescription.class);
            simConfig.addMapping(tentosAnterioresRobo, new Interval(24));
            simConfig.setWeight(tentosAnterioresRobo, 1.0);
        }

        if (gameStateQuery.getRoboCartaVirada() != null) {
            Attribute roboCartaVirada = new Attribute("roboCartaVirada", TrucoDescription.class);
            simConfig.addMapping(roboCartaVirada, new Interval(3));
            simConfig.setWeight(roboCartaVirada, 1.0);
        }

        if (gameStateQuery.getPrimeiraCartaHumano() != null) {
            Attribute primeiraCartaHumano = new Attribute("primeiraCartaHumano", TrucoDescription.class);
            simConfig.addMapping(primeiraCartaHumano, new Interval(52));
            simConfig.setWeight(primeiraCartaHumano, 1.0);
        }

        if (gameStateQuery.getSegundaCartaHumano() != null) {
            Attribute segundaCartaHumano = new Attribute("segundaCartaHumano", TrucoDescription.class);
            simConfig.addMapping(segundaCartaHumano, new Interval(52));
            simConfig.setWeight(segundaCartaHumano, 1.0);
        }

        if (gameStateQuery.getTerceiraCartaHumano() != null) {
            Attribute terceiraCartaHumano = new Attribute("terceiraCartaHumano", TrucoDescription.class);
            simConfig.addMapping(terceiraCartaHumano, new Interval(52));
            simConfig.setWeight(terceiraCartaHumano, 1.0);
        }

        if (gameStateQuery.getTentosAnterioresHumano() != null) {
            Attribute tentosAnterioresHumano = new Attribute("tentosAnterioresHumano", TrucoDescription.class);
            simConfig.addMapping(tentosAnterioresHumano, new Interval(24));
            simConfig.setWeight(tentosAnterioresHumano, 1.0);
        }

        if (gameStateQuery.getHumanoCartaVirada() != null) {
            Attribute humanoCartaVirada = new Attribute("humanoCartaVirada", TrucoDescription.class);
            simConfig.addMapping(humanoCartaVirada, new Interval(3));
            simConfig.setWeight(humanoCartaVirada, 1.0);
        }

        if (gameStateQuery.getQuemGanhouTruco() != null) {
            Attribute quemGanhouTruco = new Attribute("quemGanhouTruco", TrucoDescription.class);
            simConfig.addMapping(quemGanhouTruco, new Equal());
            simConfig.setWeight(quemGanhouTruco, 1.0);
        }

        return simConfig;
    }

    @Override
    public NNConfig getSimConfigShowPoints(TrucoDescription gameStateQuery) {
        return null;
    }
}
