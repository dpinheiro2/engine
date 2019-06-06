package br.ufsm.cbrgroup.jcolibriex;


import br.ufsm.cbrgroup.hibernate.HibernateConfig;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRCase;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CaseBaseFilter;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CaseComponent;
import es.ucm.fdi.gaia.jcolibri.cbrcore.Connector;
import es.ucm.fdi.gaia.jcolibri.exception.InitializingException;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 19/04/2019.
 */


public class GenericDataBaseConnector<T> implements Connector {

    private Class<T> descriptionType;

    public GenericDataBaseConnector() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        descriptionType = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void initFromXMLfile(URL file) throws InitializingException {

    }

    @Override
    public void close() {

    }

    @Override
    public void storeCases(Collection<CBRCase> cases) {

    }

    @Override
    public void deleteCases(Collection<CBRCase> cases) {

    }

    @Override
    public Collection<CBRCase> retrieveAllCases() {
        ArrayList<CBRCase> cases = new ArrayList<>();
        try {
            CaseComponent caseComponent;

            Session session = HibernateConfig.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(descriptionType);
            Root<T> root = query.from(descriptionType);
            query.select(root);
            Query<T> q = session.createQuery(query);

            List<T> maosList = q.getResultList();
            transaction.commit();
            session.close();

            CBRCase _case;
            for(Iterator iter = maosList.iterator(); iter.hasNext(); cases.add(_case)) {
                _case = new CBRCase();
                caseComponent = (CaseComponent)iter.next();
                _case.setDescription(caseComponent);
            }

        }
        catch (Exception var12) {
            LogFactory.getLog(this.getClass()).error(var12);
        }

        LogFactory.getLog(this.getClass()).info(cases.size() + " cases read from the database.");
        return cases;
    }

    @Override
    public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter filter) {
        return null;
    }
}
