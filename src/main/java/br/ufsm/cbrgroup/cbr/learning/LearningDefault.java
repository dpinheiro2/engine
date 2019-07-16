package br.ufsm.cbrgroup.cbr.learning;

import br.ufsm.cbrgroup.description.GenericDescription;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCase;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCaseBase;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.RetrievalResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 10/06/2019.
 */


public class LearningDefault implements LearningStrategy {

    private final double THRESHOLD = 0.90;

    @Override
    public void learningCases(Collection<CBRCase> newCases, CBRCaseBase learningCaseBase) {

        learningCaseBase.learnCases(newCases);

    }

    @Override
    public void learningCriteria(GenericDescription newCase, CBRCaseBase learningCaseBase) {

        Collection<RetrievalResult> retrievedCases = null;
        retrievedCases = getMostSimilarCases(learningCaseBase, newCase, getSimConfig(newCase), 1);

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
