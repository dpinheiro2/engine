package br.ufsm.cbrgroup.description;

import es.ucm.fdi.gaia.jcolibri.cbrcore.Attribute;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CaseComponent;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 09/06/2019.
 */


public abstract class GenericDescription implements CaseComponent{

    private Integer idMao;
    private String idPartida;
    private Integer jogadorMao;
    private Integer cartaAltaRobo;
    private Integer cartaMediaRobo;
    private Integer cartaBaixaRobo;
    private Integer cartaAltaHumano;
    private Integer cartaMediaHumano;
    private Integer cartaBaixaHumano;
    private Integer primeiraCartaRobo;
    private Integer primeiraCartaHumano;
    private Integer segundaCartaRobo;
    private Integer segundaCartaHumano;
    private Integer terceiraCartaRobo;
    private Integer terceiraCartaHumano;
    private Integer ganhadorPrimeiraRodada;
    private Integer ganhadorSegundaRodada;
    private Integer ganhadorTerceiraRodada;
    private Integer roboCartaVirada;
    private Integer humanoCartaVirada;
    private Integer quemPediuEnvido;
    private Integer quemPediuFaltaEnvido;
    private Integer quemPediuRealEnvido;
    private Integer pontosEnvidoRobo;
    private Integer pontosEnvidoHumano;
    private Integer quemNegouEnvido;
    private Integer quemGanhouEnvido;
    private Integer tentosEnvido;
    private Integer quemFlor;
    private Integer quemContraFlor;
    private Integer quemContraFlorResto;
    private Integer quemNegouFlor;
    private Integer pontosFlorRobo;
    private Integer pontosFlorHumano;
    private Integer quemGanhouFlor;
    private Integer tentosFlor;
    private Integer quemEscondeuPontosEnvido;
    private Integer quemEscondeuPontosFlor;
    private Integer quemTruco;
    private Integer quandoTruco;
    private Integer quemRetruco;
    private Integer quandoRetruco;
    private Integer quemValeQuatro;
    private Integer quandoValeQuatro;
    private Integer quemNegouTruco;
    private Integer quemGanhouTruco;
    private Integer tentosTruco;
    private Integer tentosAnterioresRobo;
    private Integer tentosAnterioresHumano;
    private Integer tentosPosterioresRobo;
    private Integer tentosPosterioresHumano;
    private Integer roboMentiuEnvido;
    private Integer humanoMentiuEnvido;
    private Integer roboMentiuFlor;
    private Integer humanoMentiuFlor;
    private Integer roboMentiuTruco;
    private Integer humanoMentiuTruco;
    private Integer quemBaralho;
    private Integer quandoBaralho;
    private Integer quemContraFlorFalta;
    private Integer quemEnvidoEnvido;
    private Integer quemFlorFlor;
    private Integer quandoCartaVirada;
    private String naipeCartaAltaRobo;
    private String naipeCartaMediaRobo;
    private String naipeCartaBaixaRobo;
    private String naipeCartaAltaHumano;
    private String naipeCartaMediaHumano;
    private String naipeCartaBaixaHumano;
    private String naipePrimeiraCartaRobo;
    private String naipePrimeiraCartaHumano;
    private String naipeSegundaCartaRobo;
    private String naipeSegundaCartaHumano;
    private String naipeTerceiraCartaRobo;
    private String naipeTerceiraCartaHumano;
    private Integer hasDeception;
    private Integer roboMentiuRound1;
    private Integer humanoMentiuRound1;
    private Integer roboMentiuRound2;
    private Integer humanoMentiuRound2;
    private Integer roboMentiuRound3;
    private Integer humanoMentiuRound3;

    public Integer getIdMao() {
        return idMao;
    }

    public void setIdMao(Integer idMao) {
        this.idMao = idMao;
    }

    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    public Integer getJogadorMao() {
        return jogadorMao;
    }

    public void setJogadorMao(Integer jogadorMao) {
        this.jogadorMao = jogadorMao;
    }

    public Integer getCartaAltaRobo() {
        return cartaAltaRobo;
    }

    public void setCartaAltaRobo(Integer cartaAltaRobo) {
        this.cartaAltaRobo = cartaAltaRobo;
    }

    public Integer getCartaMediaRobo() {
        return cartaMediaRobo;
    }

    public void setCartaMediaRobo(Integer cartaMediaRobo) {
        this.cartaMediaRobo = cartaMediaRobo;
    }

    public Integer getCartaBaixaRobo() {
        return cartaBaixaRobo;
    }

    public void setCartaBaixaRobo(Integer cartaBaixaRobo) {
        this.cartaBaixaRobo = cartaBaixaRobo;
    }

    public Integer getCartaAltaHumano() {
        return cartaAltaHumano;
    }

    public void setCartaAltaHumano(Integer cartaAltaHumano) {
        this.cartaAltaHumano = cartaAltaHumano;
    }

    public Integer getCartaMediaHumano() {
        return cartaMediaHumano;
    }

    public void setCartaMediaHumano(Integer cartaMediaHumano) {
        this.cartaMediaHumano = cartaMediaHumano;
    }

    public Integer getCartaBaixaHumano() {
        return cartaBaixaHumano;
    }

    public void setCartaBaixaHumano(Integer cartaBaixaHumano) {
        this.cartaBaixaHumano = cartaBaixaHumano;
    }

    public Integer getPrimeiraCartaRobo() {
        return primeiraCartaRobo;
    }

    public void setPrimeiraCartaRobo(Integer primeiraCartaRobo) {
        this.primeiraCartaRobo = primeiraCartaRobo;
    }

    public Integer getPrimeiraCartaHumano() {
        return primeiraCartaHumano;
    }

    public void setPrimeiraCartaHumano(Integer primeiraCartaHumano) {
        this.primeiraCartaHumano = primeiraCartaHumano;
    }

    public Integer getSegundaCartaRobo() {
        return segundaCartaRobo;
    }

    public void setSegundaCartaRobo(Integer segundaCartaRobo) {
        this.segundaCartaRobo = segundaCartaRobo;
    }

    public Integer getSegundaCartaHumano() {
        return segundaCartaHumano;
    }

    public void setSegundaCartaHumano(Integer segundaCartaHumano) {
        this.segundaCartaHumano = segundaCartaHumano;
    }

    public Integer getTerceiraCartaRobo() {
        return terceiraCartaRobo;
    }

    public void setTerceiraCartaRobo(Integer terceiraCartaRobo) {
        this.terceiraCartaRobo = terceiraCartaRobo;
    }

    public Integer getTerceiraCartaHumano() {
        return terceiraCartaHumano;
    }

    public void setTerceiraCartaHumano(Integer terceiraCartaHumano) {
        this.terceiraCartaHumano = terceiraCartaHumano;
    }

    public Integer getGanhadorPrimeiraRodada() {
        return ganhadorPrimeiraRodada;
    }

    public void setGanhadorPrimeiraRodada(Integer ganhadorPrimeiraRodada) {
        this.ganhadorPrimeiraRodada = ganhadorPrimeiraRodada;
    }

    public Integer getGanhadorSegundaRodada() {
        return ganhadorSegundaRodada;
    }

    public void setGanhadorSegundaRodada(Integer ganhadorSegundaRodada) {
        this.ganhadorSegundaRodada = ganhadorSegundaRodada;
    }

    public Integer getGanhadorTerceiraRodada() {
        return ganhadorTerceiraRodada;
    }

    public void setGanhadorTerceiraRodada(Integer ganhadorTerceiraRodada) {
        this.ganhadorTerceiraRodada = ganhadorTerceiraRodada;
    }

    public Integer getRoboCartaVirada() {
        return roboCartaVirada;
    }

    public void setRoboCartaVirada(Integer roboCartaVirada) {
        this.roboCartaVirada = roboCartaVirada;
    }

    public Integer getHumanoCartaVirada() {
        return humanoCartaVirada;
    }

    public void setHumanoCartaVirada(Integer humanoCartaVirada) {
        this.humanoCartaVirada = humanoCartaVirada;
    }

    public Integer getQuemPediuEnvido() {
        return quemPediuEnvido;
    }

    public void setQuemPediuEnvido(Integer quemPediuEnvido) {
        this.quemPediuEnvido = quemPediuEnvido;
    }

    public Integer getQuemPediuFaltaEnvido() {
        return quemPediuFaltaEnvido;
    }

    public void setQuemPediuFaltaEnvido(Integer quemPediuFaltaEnvido) {
        this.quemPediuFaltaEnvido = quemPediuFaltaEnvido;
    }

    public Integer getQuemPediuRealEnvido() {
        return quemPediuRealEnvido;
    }

    public void setQuemPediuRealEnvido(Integer quemPediuRealEnvido) {
        this.quemPediuRealEnvido = quemPediuRealEnvido;
    }

    public Integer getPontosEnvidoRobo() {
        return pontosEnvidoRobo;
    }

    public void setPontosEnvidoRobo(Integer pontosEnvidoRobo) {
        this.pontosEnvidoRobo = pontosEnvidoRobo;
    }

    public Integer getPontosEnvidoHumano() {
        return pontosEnvidoHumano;
    }

    public void setPontosEnvidoHumano(Integer pontosEnvidoHumano) {
        this.pontosEnvidoHumano = pontosEnvidoHumano;
    }

    public Integer getQuemNegouEnvido() {
        return quemNegouEnvido;
    }

    public void setQuemNegouEnvido(Integer quemNegouEnvido) {
        this.quemNegouEnvido = quemNegouEnvido;
    }

    public Integer getQuemGanhouEnvido() {
        return quemGanhouEnvido;
    }

    public void setQuemGanhouEnvido(Integer quemGanhouEnvido) {
        this.quemGanhouEnvido = quemGanhouEnvido;
    }

    public Integer getTentosEnvido() {
        return tentosEnvido;
    }

    public void setTentosEnvido(Integer tentosEnvido) {
        this.tentosEnvido = tentosEnvido;
    }

    public Integer getQuemFlor() {
        return quemFlor;
    }

    public void setQuemFlor(Integer quemFlor) {
        this.quemFlor = quemFlor;
    }

    public Integer getQuemContraFlor() {
        return quemContraFlor;
    }

    public void setQuemContraFlor(Integer quemContraFlor) {
        this.quemContraFlor = quemContraFlor;
    }

    public Integer getQuemContraFlorResto() {
        return quemContraFlorResto;
    }

    public void setQuemContraFlorResto(Integer quemContraFlorResto) {
        this.quemContraFlorResto = quemContraFlorResto;
    }

    public Integer getQuemNegouFlor() {
        return quemNegouFlor;
    }

    public void setQuemNegouFlor(Integer quemNegouFlor) {
        this.quemNegouFlor = quemNegouFlor;
    }

    public Integer getPontosFlorRobo() {
        return pontosFlorRobo;
    }

    public void setPontosFlorRobo(Integer pontosFlorRobo) {
        this.pontosFlorRobo = pontosFlorRobo;
    }

    public Integer getPontosFlorHumano() {
        return pontosFlorHumano;
    }

    public void setPontosFlorHumano(Integer pontosFlorHumano) {
        this.pontosFlorHumano = pontosFlorHumano;
    }

    public Integer getQuemGanhouFlor() {
        return quemGanhouFlor;
    }

    public void setQuemGanhouFlor(Integer quemGanhouFlor) {
        this.quemGanhouFlor = quemGanhouFlor;
    }

    public Integer getTentosFlor() {
        return tentosFlor;
    }

    public void setTentosFlor(Integer tentosFlor) {
        this.tentosFlor = tentosFlor;
    }

    public Integer getQuemEscondeuPontosEnvido() {
        return quemEscondeuPontosEnvido;
    }

    public void setQuemEscondeuPontosEnvido(Integer quemEscondeuPontosEnvido) {
        this.quemEscondeuPontosEnvido = quemEscondeuPontosEnvido;
    }

    public Integer getQuemEscondeuPontosFlor() {
        return quemEscondeuPontosFlor;
    }

    public void setQuemEscondeuPontosFlor(Integer quemEscondeuPontosFlor) {
        this.quemEscondeuPontosFlor = quemEscondeuPontosFlor;
    }

    public Integer getQuemTruco() {
        return quemTruco;
    }

    public void setQuemTruco(Integer quemTruco) {
        this.quemTruco = quemTruco;
    }

    public Integer getQuandoTruco() {
        return quandoTruco;
    }

    public void setQuandoTruco(Integer quandoTruco) {
        this.quandoTruco = quandoTruco;
    }

    public Integer getQuemRetruco() {
        return quemRetruco;
    }

    public void setQuemRetruco(Integer quemRetruco) {
        this.quemRetruco = quemRetruco;
    }

    public Integer getQuandoRetruco() {
        return quandoRetruco;
    }

    public void setQuandoRetruco(Integer quandoRetruco) {
        this.quandoRetruco = quandoRetruco;
    }

    public Integer getQuemValeQuatro() {
        return quemValeQuatro;
    }

    public void setQuemValeQuatro(Integer quemValeQuatro) {
        this.quemValeQuatro = quemValeQuatro;
    }

    public Integer getQuandoValeQuatro() {
        return quandoValeQuatro;
    }

    public void setQuandoValeQuatro(Integer quandoValeQuatro) {
        this.quandoValeQuatro = quandoValeQuatro;
    }

    public Integer getQuemNegouTruco() {
        return quemNegouTruco;
    }

    public void setQuemNegouTruco(Integer quemNegouTruco) {
        this.quemNegouTruco = quemNegouTruco;
    }

    public Integer getQuemGanhouTruco() {
        return quemGanhouTruco;
    }

    public void setQuemGanhouTruco(Integer quemGanhouTruco) {
        this.quemGanhouTruco = quemGanhouTruco;
    }

    public Integer getTentosTruco() {
        return tentosTruco;
    }

    public void setTentosTruco(Integer tentosTruco) {
        this.tentosTruco = tentosTruco;
    }

    public Integer getTentosAnterioresRobo() {
        return tentosAnterioresRobo;
    }

    public void setTentosAnterioresRobo(Integer tentosAnterioresRobo) {
        this.tentosAnterioresRobo = tentosAnterioresRobo;
    }

    public Integer getTentosAnterioresHumano() {
        return tentosAnterioresHumano;
    }

    public void setTentosAnterioresHumano(Integer tentosAnterioresHumano) {
        this.tentosAnterioresHumano = tentosAnterioresHumano;
    }

    public Integer getTentosPosterioresRobo() {
        return tentosPosterioresRobo;
    }

    public void setTentosPosterioresRobo(Integer tentosPosterioresRobo) {
        this.tentosPosterioresRobo = tentosPosterioresRobo;
    }

    public Integer getTentosPosterioresHumano() {
        return tentosPosterioresHumano;
    }

    public void setTentosPosterioresHumano(Integer tentosPosterioresHumano) {
        this.tentosPosterioresHumano = tentosPosterioresHumano;
    }

    public Integer getRoboMentiuEnvido() {
        return roboMentiuEnvido;
    }

    public void setRoboMentiuEnvido(Integer roboMentiuEnvido) {
        this.roboMentiuEnvido = roboMentiuEnvido;
    }

    public Integer getHumanoMentiuEnvido() {
        return humanoMentiuEnvido;
    }

    public void setHumanoMentiuEnvido(Integer humanoMentiuEnvido) {
        this.humanoMentiuEnvido = humanoMentiuEnvido;
    }

    public Integer getRoboMentiuFlor() {
        return roboMentiuFlor;
    }

    public void setRoboMentiuFlor(Integer roboMentiuFlor) {
        this.roboMentiuFlor = roboMentiuFlor;
    }

    public Integer getHumanoMentiuFlor() {
        return humanoMentiuFlor;
    }

    public void setHumanoMentiuFlor(Integer humanoMentiuFlor) {
        this.humanoMentiuFlor = humanoMentiuFlor;
    }

    public Integer getRoboMentiuTruco() {
        return roboMentiuTruco;
    }

    public void setRoboMentiuTruco(Integer roboMentiuTruco) {
        this.roboMentiuTruco = roboMentiuTruco;
    }

    public Integer getHumanoMentiuTruco() {
        return humanoMentiuTruco;
    }

    public void setHumanoMentiuTruco(Integer humanoMentiuTruco) {
        this.humanoMentiuTruco = humanoMentiuTruco;
    }

    public Integer getQuemBaralho() {
        return quemBaralho;
    }

    public void setQuemBaralho(Integer quemBaralho) {
        this.quemBaralho = quemBaralho;
    }

    public Integer getQuandoBaralho() {
        return quandoBaralho;
    }

    public void setQuandoBaralho(Integer quandoBaralho) {
        this.quandoBaralho = quandoBaralho;
    }

    public Integer getQuemContraFlorFalta() {
        return quemContraFlorFalta;
    }

    public void setQuemContraFlorFalta(Integer quemContraFlorFalta) {
        this.quemContraFlorFalta = quemContraFlorFalta;
    }

    public Integer getQuemEnvidoEnvido() {
        return quemEnvidoEnvido;
    }

    public void setQuemEnvidoEnvido(Integer quemEnvidoEnvido) {
        this.quemEnvidoEnvido = quemEnvidoEnvido;
    }

    public Integer getQuemFlorFlor() {
        return quemFlorFlor;
    }

    public void setQuemFlorFlor(Integer quemFlorFlor) {
        this.quemFlorFlor = quemFlorFlor;
    }

    public Integer getQuandoCartaVirada() {
        return quandoCartaVirada;
    }

    public void setQuandoCartaVirada(Integer quandoCartaVirada) {
        this.quandoCartaVirada = quandoCartaVirada;
    }

    public String getNaipeCartaAltaRobo() {
        return naipeCartaAltaRobo;
    }

    public void setNaipeCartaAltaRobo(String naipeCartaAltaRobo) {
        this.naipeCartaAltaRobo = naipeCartaAltaRobo;
    }

    public String getNaipeCartaMediaRobo() {
        return naipeCartaMediaRobo;
    }

    public void setNaipeCartaMediaRobo(String naipeCartaMediaRobo) {
        this.naipeCartaMediaRobo = naipeCartaMediaRobo;
    }

    public String getNaipeCartaBaixaRobo() {
        return naipeCartaBaixaRobo;
    }

    public void setNaipeCartaBaixaRobo(String naipeCartaBaixaRobo) {
        this.naipeCartaBaixaRobo = naipeCartaBaixaRobo;
    }

    public String getNaipeCartaAltaHumano() {
        return naipeCartaAltaHumano;
    }

    public void setNaipeCartaAltaHumano(String naipeCartaAltaHumano) {
        this.naipeCartaAltaHumano = naipeCartaAltaHumano;
    }

    public String getNaipeCartaMediaHumano() {
        return naipeCartaMediaHumano;
    }

    public void setNaipeCartaMediaHumano(String naipeCartaMediaHumano) {
        this.naipeCartaMediaHumano = naipeCartaMediaHumano;
    }

    public String getNaipeCartaBaixaHumano() {
        return naipeCartaBaixaHumano;
    }

    public void setNaipeCartaBaixaHumano(String naipeCartaBaixaHumano) {
        this.naipeCartaBaixaHumano = naipeCartaBaixaHumano;
    }

    public String getNaipePrimeiraCartaRobo() {
        return naipePrimeiraCartaRobo;
    }

    public void setNaipePrimeiraCartaRobo(String naipePrimeiraCartaRobo) {
        this.naipePrimeiraCartaRobo = naipePrimeiraCartaRobo;
    }

    public String getNaipePrimeiraCartaHumano() {
        return naipePrimeiraCartaHumano;
    }

    public void setNaipePrimeiraCartaHumano(String naipePrimeiraCartaHumano) {
        this.naipePrimeiraCartaHumano = naipePrimeiraCartaHumano;
    }

    public String getNaipeSegundaCartaRobo() {
        return naipeSegundaCartaRobo;
    }

    public void setNaipeSegundaCartaRobo(String naipeSegundaCartaRobo) {
        this.naipeSegundaCartaRobo = naipeSegundaCartaRobo;
    }

    public String getNaipeSegundaCartaHumano() {
        return naipeSegundaCartaHumano;
    }

    public void setNaipeSegundaCartaHumano(String naipeSegundaCartaHumano) {
        this.naipeSegundaCartaHumano = naipeSegundaCartaHumano;
    }

    public String getNaipeTerceiraCartaRobo() {
        return naipeTerceiraCartaRobo;
    }

    public void setNaipeTerceiraCartaRobo(String naipeTerceiraCartaRobo) {
        this.naipeTerceiraCartaRobo = naipeTerceiraCartaRobo;
    }

    public String getNaipeTerceiraCartaHumano() {
        return naipeTerceiraCartaHumano;
    }

    public void setNaipeTerceiraCartaHumano(String naipeTerceiraCartaHumano) {
        this.naipeTerceiraCartaHumano = naipeTerceiraCartaHumano;
    }

    public Integer getHasDeception() {
        return hasDeception;
    }

    public void setHasDeception(Integer hasDeception) {
        this.hasDeception = hasDeception;
    }

    public Integer getRoboMentiuRound1() {
        return roboMentiuRound1;
    }

    public void setRoboMentiuRound1(Integer roboMentiuRound1) {
        this.roboMentiuRound1 = roboMentiuRound1;
    }

    public Integer getHumanoMentiuRound1() {
        return humanoMentiuRound1;
    }

    public void setHumanoMentiuRound1(Integer humanoMentiuRound1) {
        this.humanoMentiuRound1 = humanoMentiuRound1;
    }

    public Integer getRoboMentiuRound2() {
        return roboMentiuRound2;
    }

    public void setRoboMentiuRound2(Integer roboMentiuRound2) {
        this.roboMentiuRound2 = roboMentiuRound2;
    }

    public Integer getHumanoMentiuRound2() {
        return humanoMentiuRound2;
    }

    public void setHumanoMentiuRound2(Integer humanoMentiuRound2) {
        this.humanoMentiuRound2 = humanoMentiuRound2;
    }

    public Integer getRoboMentiuRound3() {
        return roboMentiuRound3;
    }

    public void setRoboMentiuRound3(Integer roboMentiuRound3) {
        this.roboMentiuRound3 = roboMentiuRound3;
    }

    public Integer getHumanoMentiuRound3() {
        return humanoMentiuRound3;
    }

    public void setHumanoMentiuRound3(Integer humanoMentiuRound3) {
        this.humanoMentiuRound3 = humanoMentiuRound3;
    }

    public Attribute getIdAttribute() {
        return new Attribute("idMao", this.getClass());
    }

}
