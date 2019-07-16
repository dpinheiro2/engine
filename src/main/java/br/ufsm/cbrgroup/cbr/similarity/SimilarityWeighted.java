package br.ufsm.cbrgroup.cbr.similarity;

import br.ufsm.cbrgroup.description.GenericDescription;
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


public class SimilarityWeighted implements SimilarityStrategy {

    @Override
    public NNConfig getSimConfigEnvido(GenericDescription gameStateQuery) {

        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        if (gameStateQuery.getJogadorMao() != null) {
            Attribute jogadorMao = new Attribute("jogadorMao", gameStateQuery.getClass());
            simConfig.addMapping(jogadorMao, new Equal());
            simConfig.setWeight(jogadorMao, 4.0);
        }

        if (gameStateQuery.getPontosEnvidoRobo() != null) {
            Attribute pontosEnvidoRobo = new Attribute("pontosEnvidoRobo", gameStateQuery.getClass());
            simConfig.addMapping(pontosEnvidoRobo, new Interval(33));
            simConfig.setWeight(pontosEnvidoRobo, 7.0);
        }

        if (gameStateQuery.getTentosAnterioresRobo() != null) {
            Attribute tentosAnterioresRobo = new Attribute("tentosAnterioresRobo", gameStateQuery.getClass());
            simConfig.addMapping(tentosAnterioresRobo, new Interval(24));
            simConfig.setWeight(tentosAnterioresRobo, 2.0);
        }

        if (gameStateQuery.getTentosAnterioresHumano() != null) {
            Attribute tentosAnterioresHumano = new Attribute("tentosAnterioresHumano", gameStateQuery.getClass());
            simConfig.addMapping(tentosAnterioresHumano, new Interval(24));
            simConfig.setWeight(tentosAnterioresHumano, 2.0);
        }

        if (gameStateQuery.getQuemPediuEnvido() != null) {
            Attribute quemPediuEnvido = new Attribute("quemPediuEnvido", gameStateQuery.getClass());
            simConfig.addMapping(quemPediuEnvido, new Equal());
            simConfig.setWeight(quemPediuEnvido, 1.0);
        }

        if (gameStateQuery.getQuemEnvidoEnvido() != null) {
            Attribute quemEnvidoEnvido = new Attribute("quemEnvidoEnvido", gameStateQuery.getClass());
            simConfig.addMapping(quemEnvidoEnvido, new Equal());
            simConfig.setWeight(quemEnvidoEnvido, 1.0);
        }

        if (gameStateQuery.getQuemPediuRealEnvido() != null) {
            Attribute quemPediuRealEnvido = new Attribute("quemPediuRealEnvido", gameStateQuery.getClass());
            simConfig.addMapping(quemPediuRealEnvido, new Equal());
            simConfig.setWeight(quemPediuRealEnvido, 1.0);
        }

        if (gameStateQuery.getQuemPediuFaltaEnvido() != null) {
            Attribute quemPediuFaltaEnvido = new Attribute("quemPediuFaltaEnvido", gameStateQuery.getClass());
            simConfig.addMapping(quemPediuFaltaEnvido, new Equal());
            simConfig.setWeight(quemPediuFaltaEnvido, 1.0);
        }

        if (gameStateQuery.getQuemGanhouEnvido() != null) {
            Attribute quemGanhouEnvido = new Attribute("quemGanhouEnvido", gameStateQuery.getClass());
            simConfig.addMapping(quemGanhouEnvido, new Equal());
            simConfig.setWeight(quemGanhouEnvido, 3.0);
        }

        if (gameStateQuery.getPrimeiraCartaHumano() != null) {
            Attribute primeiraCartaHumano = new Attribute("primeiraCartaHumano", gameStateQuery.getClass());
            simConfig.addMapping(primeiraCartaHumano, new Interval(52));
            simConfig.setWeight(primeiraCartaHumano, 2.0);
        }

        if (gameStateQuery.getHumanoCartaVirada() != null) {
            Attribute humanoCartaVirada = new Attribute("humanoCartaVirada", gameStateQuery.getClass());
            simConfig.addMapping(humanoCartaVirada, new Interval(3));
            simConfig.setWeight(humanoCartaVirada, 2.0);
        }

        return simConfig;
    }

    @Override
    public NNConfig getSimConfigFlor(GenericDescription gameStateQuery) {

        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        if (gameStateQuery.getJogadorMao() != null) {
            Attribute jogadorMao = new Attribute("jogadorMao", gameStateQuery.getClass());
            simConfig.addMapping(jogadorMao, new Equal());
            simConfig.setWeight(jogadorMao, 4.0);
        }

        if (gameStateQuery.getPontosFlorRobo() != null) {
            Attribute pontosFlorRobo = new Attribute("pontosFlorRobo", gameStateQuery.getClass());
            simConfig.addMapping(pontosFlorRobo, new Interval(33));
            simConfig.setWeight(pontosFlorRobo, 1.0);
        }

        if (gameStateQuery.getPontosEnvidoRobo() != null) {
            Attribute pontosEnvidoRobo = new Attribute("pontosEnvidoRobo", gameStateQuery.getClass());
            simConfig.addMapping(pontosEnvidoRobo, new Interval(33));
            simConfig.setWeight(pontosEnvidoRobo, 7.0);
        }

        if (gameStateQuery.getTentosAnterioresRobo() != null) {
            Attribute tentosAnterioresRobo = new Attribute("tentosAnterioresRobo", gameStateQuery.getClass());
            simConfig.addMapping(tentosAnterioresRobo, new Interval(24));
            simConfig.setWeight(tentosAnterioresRobo, 2.0);
        }

        if (gameStateQuery.getTentosAnterioresHumano() != null) {
            Attribute tentosAnterioresHumano = new Attribute("tentosAnterioresHumano", gameStateQuery.getClass());
            simConfig.addMapping(tentosAnterioresHumano, new Interval(24));
            simConfig.setWeight(tentosAnterioresHumano, 2.0);
        }

        if (gameStateQuery.getQuemFlor() != null) {
            Attribute quemFlor = new Attribute("quemFlor", gameStateQuery.getClass());
            simConfig.addMapping(quemFlor, new Equal());
            simConfig.setWeight(quemFlor, 1.0);
        }

        if (gameStateQuery.getQuemFlorFlor() != null) {
            Attribute quemFlorFlor = new Attribute("quemFlorFlor", gameStateQuery.getClass());
            simConfig.addMapping(quemFlorFlor, new Equal());
            simConfig.setWeight(quemFlorFlor, 1.0);
        }

        if (gameStateQuery.getQuemContraFlor() != null) {
            Attribute quemContraFlor = new Attribute("quemContraFlor", gameStateQuery.getClass());
            simConfig.addMapping(quemContraFlor, new Equal());
            simConfig.setWeight(quemContraFlor, 1.0);
        }

        if (gameStateQuery.getQuemContraFlorFalta() != null) {
            Attribute quemContraFlorFalta = new Attribute("quemContraFlorFalta", gameStateQuery.getClass());
            simConfig.addMapping(quemContraFlorFalta, new Equal());
            simConfig.setWeight(quemContraFlorFalta, 1.0);
        }

        if (gameStateQuery.getQuemContraFlorResto() != null) {
            Attribute quemContraFlorResto = new Attribute("quemContraFlorResto", gameStateQuery.getClass());
            simConfig.addMapping(quemContraFlorResto, new Equal());
            simConfig.setWeight(quemContraFlorResto, 1.0);
        }

        if (gameStateQuery.getQuemGanhouFlor() != null) {
            Attribute quemGanhouFlor = new Attribute("quemGanhouFlor", gameStateQuery.getClass());
            simConfig.addMapping(quemGanhouFlor, new Equal());
            simConfig.setWeight(quemGanhouFlor, 3.0);
        }

        return simConfig;
    }

    @Override
    public NNConfig getSimConfigTruco(GenericDescription gameStateQuery) {

        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        if (gameStateQuery.getJogadorMao() != null) {
            Attribute jogadorMao = new Attribute("jogadorMao", gameStateQuery.getClass());
            simConfig.addMapping(jogadorMao, new Equal());
            simConfig.setWeight(jogadorMao, 4.0);
        }

        if (gameStateQuery.getCartaAltaRobo() != null) {
            Attribute cartaAltaRobo = new Attribute("cartaAltaRobo", gameStateQuery.getClass());
            simConfig.addMapping(cartaAltaRobo, new Interval(52));
            simConfig.setWeight(cartaAltaRobo, 7.0);
        }

        if (gameStateQuery.getCartaMediaRobo() != null) {
            Attribute cartaMediaRobo = new Attribute("cartaMediaRobo", gameStateQuery.getClass());
            simConfig.addMapping(cartaMediaRobo, new Interval(52));
            simConfig.setWeight(cartaMediaRobo, 7.0);
        }

        if (gameStateQuery.getCartaBaixaRobo() != null) {
            Attribute cartaBaixaRobo = new Attribute("cartaBaixaRobo", gameStateQuery.getClass());
            simConfig.addMapping(cartaBaixaRobo, new Interval(52));
            simConfig.setWeight(cartaBaixaRobo, 7.0);
        }

        if (gameStateQuery.getTentosAnterioresRobo() != null) {
            Attribute tentosAnterioresRobo = new Attribute("tentosAnterioresRobo", gameStateQuery.getClass());
            simConfig.addMapping(tentosAnterioresRobo, new Interval(24));
            simConfig.setWeight(tentosAnterioresRobo, 2.0);
        }

        if (gameStateQuery.getTentosAnterioresHumano() != null) {
            Attribute tentosAnterioresHumano = new Attribute("tentosAnterioresHumano", gameStateQuery.getClass());
            simConfig.addMapping(tentosAnterioresHumano, new Interval(24));
            simConfig.setWeight(tentosAnterioresHumano, 2.0);
        }

        if (gameStateQuery.getQuemGanhouTruco() != null) {
            Attribute quemGanhouTruco = new Attribute("quemGanhouTruco", gameStateQuery.getClass());
            simConfig.addMapping(quemGanhouTruco, new Equal());
            simConfig.setWeight(quemGanhouTruco, 3.0);
        }

        if (gameStateQuery.getQuandoTruco() != null) {
            Attribute quandoTruco = new Attribute("quandoTruco", gameStateQuery.getClass());
            simConfig.addMapping(quandoTruco, new Equal());
            simConfig.setWeight(quandoTruco, 1.0);
        }

        if (gameStateQuery.getQuemTruco() != null) {
            Attribute quemTruco = new Attribute("quemTruco", gameStateQuery.getClass());
            simConfig.addMapping(quemTruco, new Equal());
            simConfig.setWeight(quemTruco, 1.0);
        }

        if (gameStateQuery.getQuemRetruco() != null) {
            Attribute quemRetruco = new Attribute("quemRetruco", gameStateQuery.getClass());
            simConfig.addMapping(quemRetruco, new Equal());
            simConfig.setWeight(quemRetruco, 1.0);
        }

        if (gameStateQuery.getQuemValeQuatro() != null) {
            Attribute quemValeQuatro = new Attribute("quemValeQuatro", gameStateQuery.getClass());
            simConfig.addMapping(quemValeQuatro, new Equal());
            simConfig.setWeight(quemValeQuatro, 1.0);
        }

        if (gameStateQuery.getGanhadorPrimeiraRodada() != null) {
            Attribute ganhadorPrimeiraRodada = new Attribute("ganhadorPrimeiraRodada", gameStateQuery.getClass());
            simConfig.addMapping(ganhadorPrimeiraRodada, new Equal());
            simConfig.setWeight(ganhadorPrimeiraRodada, 1.0);
        }

        if (gameStateQuery.getGanhadorSegundaRodada() != null) {
            Attribute ganhadorSegundaRodada = new Attribute("ganhadorSegundaRodada", gameStateQuery.getClass());
            simConfig.addMapping(ganhadorSegundaRodada, new Equal());
            simConfig.setWeight(ganhadorSegundaRodada, 1.0);
        }

        if (gameStateQuery.getPrimeiraCartaRobo() != null) {
            Attribute primeiraCartaRobo = new Attribute("primeiraCartaRobo", gameStateQuery.getClass());
            simConfig.addMapping(primeiraCartaRobo, new Interval(52));
            simConfig.setWeight(primeiraCartaRobo, 1.0);
        }

        if (gameStateQuery.getSegundaCartaRobo() != null) {
            Attribute segundaCartaRobo = new Attribute("segundaCartaRobo", gameStateQuery.getClass());
            simConfig.addMapping(segundaCartaRobo, new Interval(52));
            simConfig.setWeight(segundaCartaRobo, 1.0);
        }

        if (gameStateQuery.getTerceiraCartaRobo() != null) {
            Attribute terceiraCartaRobo = new Attribute("terceiraCartaRobo", gameStateQuery.getClass());
            simConfig.addMapping(terceiraCartaRobo, new Interval(52));
            simConfig.setWeight(terceiraCartaRobo, 1.0);
        }

        if (gameStateQuery.getPrimeiraCartaHumano() != null) {
            Attribute primeiraCartaHumano = new Attribute("primeiraCartaHumano", gameStateQuery.getClass());
            simConfig.addMapping(primeiraCartaHumano, new Interval(52));
            simConfig.setWeight(primeiraCartaHumano, 1.0);
        }

        if (gameStateQuery.getSegundaCartaHumano() != null) {
            Attribute segundaCartaHumano = new Attribute("segundaCartaHumano", gameStateQuery.getClass());
            simConfig.addMapping(segundaCartaHumano, new Interval(52));
            simConfig.setWeight(segundaCartaHumano, 1.0);
        }

        if (gameStateQuery.getTerceiraCartaHumano() != null) {
            Attribute terceiraCartaHumano = new Attribute("terceiraCartaHumano", gameStateQuery.getClass());
            simConfig.addMapping(terceiraCartaHumano, new Interval(52));
            simConfig.setWeight(terceiraCartaHumano, 1.0);
        }

        if (gameStateQuery.getRoboCartaVirada() != null) {
            Attribute roboCartaVirada = new Attribute("roboCartaVirada", gameStateQuery.getClass());
            simConfig.addMapping(roboCartaVirada, new Interval(3));
            simConfig.setWeight(roboCartaVirada, 1.0);
        }

        if (gameStateQuery.getHumanoCartaVirada() != null) {
            Attribute humanoCartaVirada = new Attribute("humanoCartaVirada", gameStateQuery.getClass());
            simConfig.addMapping(humanoCartaVirada, new Interval(3));
            simConfig.setWeight(humanoCartaVirada, 1.0);
        }

        return simConfig;
    }

    @Override
    public NNConfig getSimConfigPlayCard(GenericDescription gameStateQuery) {

        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        if (gameStateQuery.getJogadorMao() != null) {
            Attribute jogadorMao = new Attribute("jogadorMao", gameStateQuery.getClass());
            simConfig.addMapping(jogadorMao, new Equal());
            simConfig.setWeight(jogadorMao, 4.0);
        }

        if (gameStateQuery.getCartaAltaRobo() != null) {
            Attribute cartaAltaRobo = new Attribute("cartaAltaRobo", gameStateQuery.getClass());
            simConfig.addMapping(cartaAltaRobo, new Interval(52));
            simConfig.setWeight(cartaAltaRobo, 7.0);
        }

        if (gameStateQuery.getCartaMediaRobo() != null) {
            Attribute cartaMediaRobo = new Attribute("cartaMediaRobo", gameStateQuery.getClass());
            simConfig.addMapping(cartaMediaRobo, new Interval(52));
            simConfig.setWeight(cartaMediaRobo, 7.0);
        }

        if (gameStateQuery.getCartaBaixaRobo() != null) {
            Attribute cartaBaixaRobo = new Attribute("cartaBaixaRobo", gameStateQuery.getClass());
            simConfig.addMapping(cartaBaixaRobo, new Interval(52));
            simConfig.setWeight(cartaBaixaRobo, 7.0);
        }

        if (gameStateQuery.getPrimeiraCartaRobo() != null) {
            Attribute primeiraCartaRobo = new Attribute("primeiraCartaRobo", gameStateQuery.getClass());
            simConfig.addMapping(primeiraCartaRobo, new Interval(52));
            simConfig.setWeight(primeiraCartaRobo, 5.0);
        }

        if (gameStateQuery.getSegundaCartaRobo() != null) {
            Attribute segundaCartaRobo = new Attribute("segundaCartaRobo", gameStateQuery.getClass());
            simConfig.addMapping(segundaCartaRobo, new Interval(52));
            simConfig.setWeight(segundaCartaRobo, 5.0);
        }

        if (gameStateQuery.getTerceiraCartaRobo() != null) {
            Attribute terceiraCartaRobo = new Attribute("terceiraCartaRobo", gameStateQuery.getClass());
            simConfig.addMapping(terceiraCartaRobo, new Interval(52));
            simConfig.setWeight(terceiraCartaRobo, 5.0);
        }

        if (gameStateQuery.getTentosAnterioresRobo() != null) {
            Attribute tentosAnterioresRobo = new Attribute("tentosAnterioresRobo", gameStateQuery.getClass());
            simConfig.addMapping(tentosAnterioresRobo, new Interval(24));
            simConfig.setWeight(tentosAnterioresRobo, 2.0);
        }

        if (gameStateQuery.getRoboCartaVirada() != null) {
            Attribute roboCartaVirada = new Attribute("roboCartaVirada", gameStateQuery.getClass());
            simConfig.addMapping(roboCartaVirada, new Interval(3));
            simConfig.setWeight(roboCartaVirada, 1.0);
        }

        if (gameStateQuery.getPrimeiraCartaHumano() != null) {
            Attribute primeiraCartaHumano = new Attribute("primeiraCartaHumano", gameStateQuery.getClass());
            simConfig.addMapping(primeiraCartaHumano, new Interval(52));
            simConfig.setWeight(primeiraCartaHumano, 5.0);
        }

        if (gameStateQuery.getSegundaCartaHumano() != null) {
            Attribute segundaCartaHumano = new Attribute("segundaCartaHumano", gameStateQuery.getClass());
            simConfig.addMapping(segundaCartaHumano, new Interval(52));
            simConfig.setWeight(segundaCartaHumano, 5.0);
        }

        if (gameStateQuery.getTerceiraCartaHumano() != null) {
            Attribute terceiraCartaHumano = new Attribute("terceiraCartaHumano", gameStateQuery.getClass());
            simConfig.addMapping(terceiraCartaHumano, new Interval(52));
            simConfig.setWeight(terceiraCartaHumano, 5.0);
        }

        if (gameStateQuery.getTentosAnterioresHumano() != null) {
            Attribute tentosAnterioresHumano = new Attribute("tentosAnterioresHumano", gameStateQuery.getClass());
            simConfig.addMapping(tentosAnterioresHumano, new Interval(24));
            simConfig.setWeight(tentosAnterioresHumano, 2.0);
        }

        if (gameStateQuery.getHumanoCartaVirada() != null) {
            Attribute humanoCartaVirada = new Attribute("humanoCartaVirada", gameStateQuery.getClass());
            simConfig.addMapping(humanoCartaVirada, new Interval(3));
            simConfig.setWeight(humanoCartaVirada, 1.0);
        }

        if (gameStateQuery.getQuemGanhouTruco() != null) {
            Attribute quemGanhouTruco = new Attribute("quemGanhouTruco", gameStateQuery.getClass());
            simConfig.addMapping(quemGanhouTruco, new Equal());
            simConfig.setWeight(quemGanhouTruco, 3.0);
        }

        return simConfig;
    }

    @Override
    public NNConfig getSimConfigShowPoints(GenericDescription gameStateQuery) {
        return null;
    }
}
