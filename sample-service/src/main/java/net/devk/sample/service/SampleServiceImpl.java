package net.devk.sample.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import net.devk.sample.model.SampleEntity;

@Named("sampleService")
class SampleServiceImpl implements SampleService {

	@Inject
	private SampleRepository sampleRepository;

	@Inject
	private UserTransaction userTransaction;

	@Override

	public void saveSample(String sampleName) {
		try {
			userTransaction.begin();
		} catch (NotSupportedException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SampleEntity sampleEntity = new SampleEntity();
		sampleEntity.setSampleName(sampleName);
		sampleRepository.saveSample(sampleEntity);
		try {
			userTransaction.commit();
		} catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
				| HeuristicRollbackException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
