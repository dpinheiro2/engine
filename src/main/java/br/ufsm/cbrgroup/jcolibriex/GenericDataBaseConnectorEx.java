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
import java.util.*;

/**
 * Universidade Federal de Santa Maria
 * Pós-Graduação em Ciência da Computação
 * Tópicos em Computação Aplicada
 * Daniel Pinheiro Vargas
 * Criado em 01/07/2019.
 */


public class GenericDataBaseConnectorEx<D> implements Connector {

    private Class<D> descriptionType;

    public GenericDataBaseConnectorEx() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        descriptionType = (Class<D>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void initFromXMLfile(URL file) throws InitializingException {

    }

    @Override
    public void close() {

    }

    @Override
    public void storeCases(Collection<CBRCase> cases) {

        Iterator itr = cases.iterator();

        while(itr.hasNext()) {
            CBRCase c = (CBRCase) itr.next();
            Session session = HibernateConfig.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(c.getDescription());
            transaction.commit();
            session.close();

        }

        LogFactory.getLog(this.getClass()).info(descriptionType.getName() + ": " + cases.size() + " cases stored into the database.");
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
            CriteriaQuery<D> query = builder.createQuery(descriptionType);
            Root<D> root = query.from(descriptionType);
            query.select(root);
            Query<D> q = session.createQuery(query);

            List<D> maosList = q.getResultList();
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

        LogFactory.getLog(this.getClass()).info(descriptionType.getName() + ": " + cases.size() + " cases read from the database.");
        return cases;
    }

    @Override
    public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter filter) {
        return null;
    }

}
