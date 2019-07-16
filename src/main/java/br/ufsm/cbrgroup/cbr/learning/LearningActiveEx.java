package br.ufsm.cbrgroup.cbr.learning;

import br.ufsm.cbrgroup.description.GenericEnvido;
import br.ufsm.cbrgroup.description.GenericFlor;
import br.ufsm.cbrgroup.description.GenericPlayCard;
import br.ufsm.cbrgroup.description.GenericTruco;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCase;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCaseBase;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRQuery;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CaseComponent;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.RetrievalResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 04/07/2019.
 */


public class LearningActiveEx implements LearningStrategyEx {

    private final double THRESHOLD = 0.90;

    @Override
    public void learningCases(Collection<CBRCase> newCases, CBRCaseBase learningCaseBase) {
        learningCaseBase.learnCases(newCases);
    }

    @Override
    public void learningCriteriaEnvido(GenericEnvido newCase, CBRCaseBase learningCaseBase) {
        Collection<RetrievalResult> retrievedCases = null;
        CBRQuery cbrQuery = new CBRQuery();
        cbrQuery.setDescription((CaseComponent) newCase);
        retrievedCases = getMostSimilarCases(learningCaseBase, cbrQuery, getSimConfigEnvido(newCase), 1);

        RetrievalResult retrievedCase = null;

        Iterator i = retrievedCases.iterator();
        if (i.hasNext()) {
            retrievedCase = (RetrievalResult) i.next();
        }

        if (retrievedCase != null) {
            if (retrievedCase.getEval() < THRESHOLD) {
                CBRCase cbrCase = new CBRCase();
                cbrCase.setDescription(newCase);
                Collection<CBRCase> newCases = new ArrayList<>();
                newCases.add(cbrCase);
                learningCases(newCases, learningCaseBase);
            }
        } else {
            CBRCase cbrCase = new CBRCase();
            cbrCase.setDescription(newCase);
            Collection<CBRCase> newCases = new ArrayList<>();
            newCases.add(cbrCase);
            learningCases(newCases, learningCaseBase);
        }

    }

    @Override
    public void learningCriteriaFlor(GenericFlor newCase, CBRCaseBase learningCaseBase) {
        Collection<RetrievalResult> retrievedCases = null;
        CBRQuery cbrQuery = new CBRQuery();
        cbrQuery.setDescription((CaseComponent) newCase);
        retrievedCases = getMostSimilarCases(learningCaseBase, cbrQuery, getSimConfigFlor(newCase), 1);

        RetrievalResult retrievedCase = null;

        Iterator i = retrievedCases.iterator();
        if (i.hasNext()) {
            retrievedCase = (RetrievalResult) i.next();
        }

        if (retrievedCase != null) {
            if (retrievedCase.getEval() < THRESHOLD) {
                CBRCase cbrCase = new CBRCase();
                cbrCase.setDescription(newCase);
                Collection<CBRCase> newCases = new ArrayList<>();
                newCases.add(cbrCase);
                learningCases(newCases, learningCaseBase);
            }
        } else {
            CBRCase cbrCase = new CBRCase();
            cbrCase.setDescription(newCase);
            Collection<CBRCase> newCases = new ArrayList<>();
            newCases.add(cbrCase);
            learningCases(newCases, learningCaseBase);
        }
    }

    @Override
    public void learningCriteriaTruco(GenericTruco newCase, CBRCaseBase learningCaseBase) {
        Collection<RetrievalResult> retrievedCases = null;
        CBRQuery cbrQuery = new CBRQuery();
        cbrQuery.setDescription((CaseComponent) newCase);
        retrievedCases = getMostSimilarCases(learningCaseBase, cbrQuery, getSimConfigTruco(newCase), 1);

        RetrievalResult retrievedCase = null;

        Iterator i = retrievedCases.iterator();
        if (i.hasNext()) {
            retrievedCase = (RetrievalResult) i.next();
        }

        if (retrievedCase != null) {
            if (retrievedCase.getEval() < THRESHOLD) {
                CBRCase cbrCase = new CBRCase();
                cbrCase.setDescription(newCase);
                Collection<CBRCase> newCases = new ArrayList<>();
                newCases.add(cbrCase);
                learningCases(newCases, learningCaseBase);
            }
        } else {
            CBRCase cbrCase = new CBRCase();
            cbrCase.setDescription(newCase);
            Collection<CBRCase> newCases = new ArrayList<>();
            newCases.add(cbrCase);
            learningCases(newCases, learningCaseBase);
        }
    }

    @Override
    public void learningCriteriaPlayCard(GenericPlayCard newCase, CBRCaseBase learningCaseBase) {

        Collection<RetrievalResult> retrievedCases = null;
        CBRQuery cbrQuery = new CBRQuery();
        cbrQuery.setDescription((CaseComponent) newCase);
        retrievedCases = getMostSimilarCases(learningCaseBase, cbrQuery, getSimConfigPlayCard(newCase), 1);

        RetrievalResult retrievedCase = null;

        Iterator i = retrievedCases.iterator();
        if (i.hasNext()) {
            retrievedCase = (RetrievalResult) i.next();
        }

        if (retrievedCase != null) {
            if (retrievedCase.getEval() < THRESHOLD) {
                CBRCase cbrCase = new CBRCase();
                cbrCase.setDescription(newCase);
                Collection<CBRCase> newCases = new ArrayList<>();
                newCases.add(cbrCase);
                learningCases(newCases, learningCaseBase);
            }
        } else {
            CBRCase cbrCase = new CBRCase();
            cbrCase.setDescription(newCase);
            Collection<CBRCase> newCases = new ArrayList<>();
            newCases.add(cbrCase);
            learningCases(newCases, learningCaseBase);
        }
    }


}
