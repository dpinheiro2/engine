package br.ufsm.cbrgroup.cbr.learning;

import br.ufsm.cbrgroup.description.GenericDescription;
import es.ucm.fdi.gaia.jcolibri.cbrcore.*;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.RetrievalResult;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.selection.SelectCases;

import java.util.Collection;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 21/05/2019.
 */


public interface LearningStrategy {

    default Collection<RetrievalResult> getMostSimilarCases(CBRCaseBase caseBase, GenericDescription gameStateQuery, NNConfig simConfig, int k) {

        Collection<RetrievalResult> results = null;
        CBRQuery query = new CBRQuery();
        query.setDescription((CaseComponent) gameStateQuery);
        results = NNScoringMethod.evaluateSimilarity(caseBase.getCases(), query, simConfig);
        results = SelectCases.selectTopKRR(results, k);
        SelectCases.selectTopK(results, k);

        return results;
    }

    default NNConfig getSimConfig(GenericDescription newCase) {

        NNConfig simConfig = new NNConfig();
        simConfig.setDescriptionSimFunction(new Average());

        if (newCase.getJogadorMao() != null) {
            Attribute jogadorMao = new Attribute("jogadorMao", newCase.getClass());
            simConfig.addMapping(jogadorMao, new Equal());
            simConfig.setWeight(jogadorMao, 1.0);
        }

        if (newCase.getCartaAltaRobo() != null) {
            Attribute cartaAltaRobo = new Attribute("cartaAltaRobo", newCase.getClass());
            simConfig.addMapping(cartaAltaRobo, new Equal());
            simConfig.setWeight(cartaAltaRobo, 1.0);
        }

        if (newCase.getCartaMediaRobo() != null) {
            Attribute cartaMediaRobo = new Attribute("cartaMediaRobo", newCase.getClass());
            simConfig.addMapping(cartaMediaRobo, new Equal());
            simConfig.setWeight(cartaMediaRobo, 1.0);
        }

        if (newCase.getCartaBaixaRobo() != null) {
            Attribute cartaBaixaRobo = new Attribute("cartaBaixaRobo", newCase.getClass());
            simConfig.addMapping(cartaBaixaRobo, new Equal());
            simConfig.setWeight(cartaBaixaRobo, 1.0);
        }

        if (newCase.getNaipeCartaAltaRobo() != null) {
            Attribute naipeCartaAltaRobo = new Attribute("naipeCartaAltaRobo", newCase.getClass());
            simConfig.addMapping(naipeCartaAltaRobo, new Equal());
            simConfig.setWeight(naipeCartaAltaRobo, 1.0);
        }

        if (newCase.getNaipeCartaMediaRobo() != null) {
            Attribute naipeCartaMediaRobo = new Attribute("naipeCartaMediaRobo", newCase.getClass());
            simConfig.addMapping(naipeCartaMediaRobo, new Equal());
            simConfig.setWeight(naipeCartaMediaRobo, 1.0);
        }

        if (newCase.getNaipeCartaBaixaRobo() != null) {
            Attribute naipeCartaBaixaRobo = new Attribute("naipeCartaBaixaRobo", newCase.getClass());
            simConfig.addMapping(naipeCartaBaixaRobo, new Equal());
            simConfig.setWeight(naipeCartaBaixaRobo, 1.0);
        }

        if (newCase.getCartaAltaHumano() != null) {
            Attribute cartaAltaHumano = new Attribute("cartaAltaHumano", newCase.getClass());
            simConfig.addMapping(cartaAltaHumano, new Equal());
            simConfig.setWeight(cartaAltaHumano, 1.0);
        }

        if (newCase.getCartaMediaHumano() != null) {
            Attribute cartaMediaHumano = new Attribute("cartaMediaHumano", newCase.getClass());
            simConfig.addMapping(cartaMediaHumano, new Equal());
            simConfig.setWeight(cartaMediaHumano, 1.0);
        }

        if (newCase.getCartaBaixaHumano() != null) {
            Attribute cartaBaixaHumano = new Attribute("cartaBaixaHumano", newCase.getClass());
            simConfig.addMapping(cartaBaixaHumano, new Equal());
            simConfig.setWeight(cartaBaixaHumano, 1.0);
        }

        if (newCase.getNaipeCartaAltaHumano() != null) {
            Attribute naipeCartaAltaHumano = new Attribute("naipeCartaAltaHumano", newCase.getClass());
            simConfig.addMapping(naipeCartaAltaHumano, new Equal());
            simConfig.setWeight(naipeCartaAltaHumano, 1.0);
        }

        if (newCase.getNaipeCartaMediaHumano() != null) {
            Attribute naipeCartaMediaHumano = new Attribute("naipeCartaMediaHumano", newCase.getClass());
            simConfig.addMapping(naipeCartaMediaHumano, new Equal());
            simConfig.setWeight(naipeCartaMediaHumano, 1.0);
        }

        if (newCase.getNaipeCartaBaixaHumano() != null) {
            Attribute naipeCartaBaixaHumano = new Attribute("naipeCartaBaixaHumano", newCase.getClass());
            simConfig.addMapping(naipeCartaBaixaHumano, new Equal());
            simConfig.setWeight(naipeCartaBaixaHumano, 1.0);
        }

        if (newCase.getPrimeiraCartaRobo() != null) {
            Attribute primeiraCartaRobo = new Attribute("primeiraCartaRobo", newCase.getClass());
            simConfig.addMapping(primeiraCartaRobo, new Equal());
            simConfig.setWeight(primeiraCartaRobo, 1.0);
        }

        if (newCase.getSegundaCartaRobo() != null) {
            Attribute segundaCartaRobo = new Attribute("segundaCartaRobo", newCase.getClass());
            simConfig.addMapping(segundaCartaRobo, new Equal());
            simConfig.setWeight(segundaCartaRobo, 1.0);
        }

        if (newCase.getTerceiraCartaRobo() != null) {
            Attribute terceiraCartaRobo = new Attribute("terceiraCartaRobo", newCase.getClass());
            simConfig.addMapping(terceiraCartaRobo, new Equal());
            simConfig.setWeight(terceiraCartaRobo, 1.0);
        }

        if (newCase.getNaipePrimeiraCartaRobo() != null) {
            Attribute naipePrimeiraCartaRobo = new Attribute("naipePrimeiraCartaRobo", newCase.getClass());
            simConfig.addMapping(naipePrimeiraCartaRobo, new Equal());
            simConfig.setWeight(naipePrimeiraCartaRobo, 1.0);
        }

        if (newCase.getNaipeSegundaCartaRobo() != null) {
            Attribute naipeSegundaCartaRobo = new Attribute("naipeSegundaCartaRobo", newCase.getClass());
            simConfig.addMapping(naipeSegundaCartaRobo, new Equal());
            simConfig.setWeight(naipeSegundaCartaRobo, 1.0);
        }

        if (newCase.getNaipeTerceiraCartaRobo() != null) {
            Attribute naipeTerceiraCartaRobo = new Attribute("naipeTerceiraCartaRobo", newCase.getClass());
            simConfig.addMapping(naipeTerceiraCartaRobo, new Equal());
            simConfig.setWeight(naipeTerceiraCartaRobo, 1.0);
        }

        if (newCase.getPrimeiraCartaHumano() != null) {
            Attribute primeiraCartaHumano = new Attribute("primeiraCartaHumano", newCase.getClass());
            simConfig.addMapping(primeiraCartaHumano, new Equal());
            simConfig.setWeight(primeiraCartaHumano, 1.0);
        }

        if (newCase.getSegundaCartaHumano() != null) {
            Attribute segundaCartaHumano = new Attribute("segundaCartaHumano", newCase.getClass());
            simConfig.addMapping(segundaCartaHumano, new Equal());
            simConfig.setWeight(segundaCartaHumano, 1.0);
        }

        if (newCase.getTerceiraCartaHumano() != null) {
            Attribute terceiraCartaHumano = new Attribute("terceiraCartaHumano", newCase.getClass());
            simConfig.addMapping(terceiraCartaHumano, new Equal());
            simConfig.setWeight(terceiraCartaHumano, 1.0);
        }

        if (newCase.getNaipePrimeiraCartaHumano() != null) {
            Attribute naipePrimeiraCartaHumano = new Attribute("naipePrimeiraCartaHumano", newCase.getClass());
            simConfig.addMapping(naipePrimeiraCartaHumano, new Equal());
            simConfig.setWeight(naipePrimeiraCartaHumano, 1.0);
        }

        if (newCase.getNaipeSegundaCartaHumano() != null) {
            Attribute naipeSegundaCartaHumano = new Attribute("naipeSegundaCartaHumano", newCase.getClass());
            simConfig.addMapping(naipeSegundaCartaHumano, new Equal());
            simConfig.setWeight(naipeSegundaCartaHumano, 1.0);
        }

        if (newCase.getNaipeTerceiraCartaHumano() != null) {
            Attribute naipeTerceiraCartaHumano = new Attribute("naipeTerceiraCartaHumano", newCase.getClass());
            simConfig.addMapping(naipeTerceiraCartaHumano, new Equal());
            simConfig.setWeight(naipeTerceiraCartaHumano, 1.0);
        }

        if (newCase.getGanhadorPrimeiraRodada() != null) {
            Attribute ganhadorPrimeiraRodada = new Attribute("ganhadorPrimeiraRodada", newCase.getClass());
            simConfig.addMapping(ganhadorPrimeiraRodada, new Equal());
            simConfig.setWeight(ganhadorPrimeiraRodada, 1.0);
        }

        if (newCase.getGanhadorSegundaRodada() != null) {
            Attribute ganhadorSegundaRodada = new Attribute("ganhadorSegundaRodada", newCase.getClass());
            simConfig.addMapping(ganhadorSegundaRodada, new Equal());
            simConfig.setWeight(ganhadorSegundaRodada, 1.0);
        }

        if (newCase.getGanhadorTerceiraRodada() != null) {
            Attribute ganhadorTerceiraRodada = new Attribute("ganhadorTerceiraRodada", newCase.getClass());
            simConfig.addMapping(ganhadorTerceiraRodada, new Equal());
            simConfig.setWeight(ganhadorTerceiraRodada, 1.0);
        }

        if (newCase.getRoboCartaVirada() != null) {
            Attribute roboCartaVirada = new Attribute("roboCartaVirada", newCase.getClass());
            simConfig.addMapping(roboCartaVirada, new Equal());
            simConfig.setWeight(roboCartaVirada, 1.0);
        }

        if (newCase.getHumanoCartaVirada() != null) {
            Attribute humanoCartaVirada = new Attribute("humanoCartaVirada", newCase.getClass());
            simConfig.addMapping(humanoCartaVirada, new Equal());
            simConfig.setWeight(humanoCartaVirada, 1.0);
        }

        if (newCase.getQuandoCartaVirada() != null) {
            Attribute quandoCartaVirada = new Attribute("quandoCartaVirada", newCase.getClass());
            simConfig.addMapping(quandoCartaVirada, new Equal());
            simConfig.setWeight(quandoCartaVirada, 1.0);
        }

        if (newCase.getPontosEnvidoRobo() != null) {
            Attribute pontosEnvidoRobo = new Attribute("pontosEnvidoRobo", newCase.getClass());
            simConfig.addMapping(pontosEnvidoRobo, new Equal());
            simConfig.setWeight(pontosEnvidoRobo, 1.0);
        }

        if (newCase.getPontosEnvidoHumano() != null) {
            Attribute pontosEnvidoHumano = new Attribute("pontosEnvidoHumano", newCase.getClass());
            simConfig.addMapping(pontosEnvidoHumano, new Equal());
            simConfig.setWeight(pontosEnvidoHumano, 1.0);
        }

        if (newCase.getPontosFlorRobo() != null) {
            Attribute pontosFlorRobo = new Attribute("pontosFlorRobo", newCase.getClass());
            simConfig.addMapping(pontosFlorRobo, new Equal());
            simConfig.setWeight(pontosFlorRobo, 1.0);
        }

        if (newCase.getPontosFlorHumano() != null) {
            Attribute pontosFlorHumano = new Attribute("pontosFlorHumano", newCase.getClass());
            simConfig.addMapping(pontosFlorHumano, new Equal());
            simConfig.setWeight(pontosFlorHumano, 1.0);
        }

        if (newCase.getTentosAnterioresRobo() != null) {
            Attribute tentosAnterioresRobo = new Attribute("tentosAnterioresRobo", newCase.getClass());
            simConfig.addMapping(tentosAnterioresRobo, new Equal());
            simConfig.setWeight(tentosAnterioresRobo, 1.0);
        }

        if (newCase.getTentosAnterioresHumano() != null) {
            Attribute tentosAnterioresHumano = new Attribute("tentosAnterioresHumano", newCase.getClass());
            simConfig.addMapping(tentosAnterioresHumano, new Equal());
            simConfig.setWeight(tentosAnterioresHumano, 1.0);
        }

        if (newCase.getTentosPosterioresRobo() != null) {
            Attribute tentosPosterioresRobo = new Attribute("tentosPosterioresRobo", newCase.getClass());
            simConfig.addMapping(tentosPosterioresRobo, new Equal());
            simConfig.setWeight(tentosPosterioresRobo, 1.0);
        }

        if (newCase.getTentosPosterioresHumano() != null) {
            Attribute tentosPosterioresHumano = new Attribute("tentosPosterioresHumano", newCase.getClass());
            simConfig.addMapping(tentosPosterioresHumano, new Equal());
            simConfig.setWeight(tentosPosterioresHumano, 1.0);
        }

        if (newCase.getQuemPediuEnvido() != null) {
            Attribute quemPediuEnvido = new Attribute("quemPediuEnvido", newCase.getClass());
            simConfig.addMapping(quemPediuEnvido, new Equal());
            simConfig.setWeight(quemPediuEnvido, 1.0);
        }

        if (newCase.getQuemEnvidoEnvido() != null) {
            Attribute quemEnvidoEnvido = new Attribute("quemEnvidoEnvido", newCase.getClass());
            simConfig.addMapping(quemEnvidoEnvido, new Equal());
            simConfig.setWeight(quemEnvidoEnvido, 1.0);
        }

        if (newCase.getQuemPediuRealEnvido() != null) {
            Attribute quemPediuRealEnvido = new Attribute("quemPediuRealEnvido", newCase.getClass());
            simConfig.addMapping(quemPediuRealEnvido, new Equal());
            simConfig.setWeight(quemPediuRealEnvido, 1.0);
        }

        if (newCase.getQuemPediuFaltaEnvido() != null) {
            Attribute quemPediuFaltaEnvido = new Attribute("quemPediuFaltaEnvido", newCase.getClass());
            simConfig.addMapping(quemPediuFaltaEnvido, new Equal());
            simConfig.setWeight(quemPediuFaltaEnvido, 1.0);
        }

        if (newCase.getQuemGanhouEnvido() != null) {
            Attribute quemGanhouEnvido = new Attribute("quemGanhouEnvido", newCase.getClass());
            simConfig.addMapping(quemGanhouEnvido, new Equal());
            simConfig.setWeight(quemGanhouEnvido, 1.0);
        }

        if (newCase.getQuemNegouEnvido() != null) {
            Attribute quemNegouEnvido = new Attribute("quemNegouEnvido", newCase.getClass());
            simConfig.addMapping(quemNegouEnvido, new Equal());
            simConfig.setWeight(quemNegouEnvido, 1.0);
        }

        if (newCase.getQuemGanhouTruco() != null) {
            Attribute quemGanhouTruco = new Attribute("quemGanhouTruco", newCase.getClass());
            simConfig.addMapping(quemGanhouTruco, new Equal());
            simConfig.setWeight(quemGanhouTruco, 1.0);
        }

        if (newCase.getQuemNegouTruco() != null) {
            Attribute quemNegouTruco = new Attribute("quemNegouTruco", newCase.getClass());
            simConfig.addMapping(quemNegouTruco, new Equal());
            simConfig.setWeight(quemNegouTruco, 1.0);
        }

        if (newCase.getQuandoTruco() != null) {
            Attribute quandoTruco = new Attribute("quandoTruco", newCase.getClass());
            simConfig.addMapping(quandoTruco, new Equal());
            simConfig.setWeight(quandoTruco, 1.0);
        }

        if (newCase.getQuemTruco() != null) {
            Attribute quemTruco = new Attribute("quemTruco", newCase.getClass());
            simConfig.addMapping(quemTruco, new Equal());
            simConfig.setWeight(quemTruco, 1.0);
        }

        if (newCase.getQuandoRetruco() != null) {
            Attribute quandoRetruco = new Attribute("quandoRetruco", newCase.getClass());
            simConfig.addMapping(quandoRetruco, new Equal());
            simConfig.setWeight(quandoRetruco, 1.0);
        }

        if (newCase.getQuemRetruco() != null) {
            Attribute quemRetruco = new Attribute("quemRetruco", newCase.getClass());
            simConfig.addMapping(quemRetruco, new Equal());
            simConfig.setWeight(quemRetruco, 1.0);
        }

        if (newCase.getQuandoValeQuatro() != null) {
            Attribute quandoValeQuatro = new Attribute("quandoValeQuatro", newCase.getClass());
            simConfig.addMapping(quandoValeQuatro, new Equal());
            simConfig.setWeight(quandoValeQuatro, 1.0);
        }

        if (newCase.getQuemValeQuatro() != null) {
            Attribute quemValeQuatro = new Attribute("quemValeQuatro", newCase.getClass());
            simConfig.addMapping(quemValeQuatro, new Equal());
            simConfig.setWeight(quemValeQuatro, 1.0);
        }

        if (newCase.getQuandoBaralho() != null) {
            Attribute quandoBaralho = new Attribute("quandoBaralho", newCase.getClass());
            simConfig.addMapping(quandoBaralho, new Equal());
            simConfig.setWeight(quandoBaralho, 1.0);
        }

        if (newCase.getQuemBaralho() != null) {
            Attribute quemBaralho = new Attribute("quemBaralho", newCase.getClass());
            simConfig.addMapping(quemBaralho, new Equal());
            simConfig.setWeight(quemBaralho, 1.0);
        }

        if (newCase.getQuemFlor() != null) {
            Attribute quemFlor = new Attribute("quemFlor", newCase.getClass());
            simConfig.addMapping(quemFlor, new Equal());
            simConfig.setWeight(quemFlor, 1.0);
        }

        if (newCase.getQuemFlorFlor() != null) {
            Attribute quemFlorFlor = new Attribute("quemFlorFlor", newCase.getClass());
            simConfig.addMapping(quemFlorFlor, new Equal());
            simConfig.setWeight(quemFlorFlor, 1.0);
        }

        if (newCase.getQuemContraFlor() != null) {
            Attribute quemContraFlor = new Attribute("quemContraFlor", newCase.getClass());
            simConfig.addMapping(quemContraFlor, new Equal());
            simConfig.setWeight(quemContraFlor, 1.0);
        }

        if (newCase.getQuemContraFlorFalta() != null) {
            Attribute quemContraFlorFalta = new Attribute("quemContraFlorFalta", newCase.getClass());
            simConfig.addMapping(quemContraFlorFalta, new Equal());
            simConfig.setWeight(quemContraFlorFalta, 1.0);
        }

        if (newCase.getQuemContraFlorResto() != null) {
            Attribute quemContraFlorResto = new Attribute("quemContraFlorResto", newCase.getClass());
            simConfig.addMapping(quemContraFlorResto, new Equal());
            simConfig.setWeight(quemContraFlorResto, 1.0);
        }

        if (newCase.getQuemGanhouFlor() != null) {
            Attribute quemGanhouFlor = new Attribute("quemGanhouFlor", newCase.getClass());
            simConfig.addMapping(quemGanhouFlor, new Equal());
            simConfig.setWeight(quemGanhouFlor, 1.0);
        }

        if (newCase.getQuemNegouFlor() != null) {
            Attribute quemNegouFlor = new Attribute("quemNegouFlor", newCase.getClass());
            simConfig.addMapping(quemNegouFlor, new Equal());
            simConfig.setWeight(quemNegouFlor, 1.0);
        }

        if (newCase.getTentosEnvido() != null) {
            Attribute tentosEnvido = new Attribute("tentosEnvido", newCase.getClass());
            simConfig.addMapping(tentosEnvido, new Equal());
            simConfig.setWeight(tentosEnvido, 1.0);
        }

        if (newCase.getTentosFlor() != null) {
            Attribute tentosFlor = new Attribute("tentosFlor", newCase.getClass());
            simConfig.addMapping(tentosFlor, new Equal());
            simConfig.setWeight(tentosFlor, 1.0);
        }

        if (newCase.getTentosTruco() != null) {
            Attribute tentosTruco = new Attribute("tentosTruco", newCase.getClass());
            simConfig.addMapping(tentosTruco, new Equal());
            simConfig.setWeight(tentosTruco, 1.0);
        }

        if (newCase.getQuemEscondeuPontosEnvido() != null) {
            Attribute quemEscondeuPontosEnvido = new Attribute("quemEscondeuPontosEnvido", newCase.getClass());
            simConfig.addMapping(quemEscondeuPontosEnvido, new Equal());
            simConfig.setWeight(quemEscondeuPontosEnvido, 1.0);
        }

        if (newCase.getQuemEscondeuPontosFlor() != null) {
            Attribute quemEscondeuPontosFlor = new Attribute("quemEscondeuPontosFlor", newCase.getClass());
            simConfig.addMapping(quemEscondeuPontosFlor, new Equal());
            simConfig.setWeight(quemEscondeuPontosFlor, 1.0);
        }

        if (newCase.getQuemEscondeuPontosFlor() != null) {
            Attribute quemEscondeuPontosFlor = new Attribute("quemEscondeuPontosFlor", newCase.getClass());
            simConfig.addMapping(quemEscondeuPontosFlor, new Equal());
            simConfig.setWeight(quemEscondeuPontosFlor, 1.0);
        }

        if (newCase.getQuemEscondeuPontosFlor() != null) {
            Attribute quemEscondeuPontosFlor = new Attribute("quemEscondeuPontosFlor", newCase.getClass());
            simConfig.addMapping(quemEscondeuPontosFlor, new Equal());
            simConfig.setWeight(quemEscondeuPontosFlor, 1.0);
        }

        if (newCase.getHumanoMentiuFlor() != null) {
            Attribute humanoMentiuFlor = new Attribute("humanoMentiuFlor", newCase.getClass());
            simConfig.addMapping(humanoMentiuFlor, new Equal());
            simConfig.setWeight(humanoMentiuFlor, 1.0);
        }

        if (newCase.getRoboMentiuFlor() != null) {
            Attribute roboMentiuFlor = new Attribute("roboMentiuFlor", newCase.getClass());
            simConfig.addMapping(roboMentiuFlor, new Equal());
            simConfig.setWeight(roboMentiuFlor, 1.0);
        }

        if (newCase.getHumanoMentiuTruco() != null) {
            Attribute humanoMentiuTruco = new Attribute("humanoMentiuTruco", newCase.getClass());
            simConfig.addMapping(humanoMentiuTruco, new Equal());
            simConfig.setWeight(humanoMentiuTruco, 1.0);
        }

        if (newCase.getRoboMentiuTruco() != null) {
            Attribute roboMentiuTruco = new Attribute("roboMentiuTruco", newCase.getClass());
            simConfig.addMapping(roboMentiuTruco, new Equal());
            simConfig.setWeight(roboMentiuTruco, 1.0);
        }

        if (newCase.getHumanoMentiuEnvido() != null) {
            Attribute humanoMentiuEnvido = new Attribute("humanoMentiuEnvido", newCase.getClass());
            simConfig.addMapping(humanoMentiuEnvido, new Equal());
            simConfig.setWeight(humanoMentiuEnvido, 1.0);
        }

        if (newCase.getRoboMentiuEnvido() != null) {
            Attribute roboMentiuEnvido = new Attribute("roboMentiuEnvido", newCase.getClass());
            simConfig.addMapping(roboMentiuEnvido, new Equal());
            simConfig.setWeight(roboMentiuEnvido, 1.0);
        }

        if (newCase.getHumanoMentiuRound1() != null) {
            Attribute humanoMentiuRound1 = new Attribute("humanoMentiuRound1", newCase.getClass());
            simConfig.addMapping(humanoMentiuRound1, new Equal());
            simConfig.setWeight(humanoMentiuRound1, 1.0);
        }

        if (newCase.getRoboMentiuRound1() != null) {
            Attribute roboMentiuRound1 = new Attribute("roboMentiuRound1", newCase.getClass());
            simConfig.addMapping(roboMentiuRound1, new Equal());
            simConfig.setWeight(roboMentiuRound1, 1.0);
        }

        if (newCase.getHumanoMentiuRound2() != null) {
            Attribute humanoMentiuRound2 = new Attribute("humanoMentiuRound3", newCase.getClass());
            simConfig.addMapping(humanoMentiuRound2, new Equal());
            simConfig.setWeight(humanoMentiuRound2, 1.0);
        }

        if (newCase.getRoboMentiuRound3() != null) {
            Attribute roboMentiuRound3 = new Attribute("roboMentiuRound3", newCase.getClass());
            simConfig.addMapping(roboMentiuRound3, new Equal());
            simConfig.setWeight(roboMentiuRound3, 1.0);
        }

        if (newCase.getHumanoMentiuRound3() != null) {
            Attribute humanoMentiuRound3 = new Attribute("humanoMentiuRound3", newCase.getClass());
            simConfig.addMapping(humanoMentiuRound3, new Equal());
            simConfig.setWeight(humanoMentiuRound3, 1.0);
        }

        if (newCase.getHasDeception() != null) {
            Attribute hasDeception = new Attribute("hasDeception", newCase.getClass());
            simConfig.addMapping(hasDeception, new Equal());
            simConfig.setWeight(hasDeception, 1.0);
        }


        return simConfig;
    }


    public void learningCases(Collection<CBRCase> newCases, CBRCaseBase learningCaseBase);

    public void learningCriteria(GenericDescription newCase, CBRCaseBase learningCaseBase);

}
