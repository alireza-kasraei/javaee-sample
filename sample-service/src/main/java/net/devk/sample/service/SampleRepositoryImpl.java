package net.devk.sample.service;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.devk.sample.model.SampleEntity;

@Named("sampleRepository")
class SampleRepositoryImpl implements SampleRepository {

	@PersistenceContext(unitName = "pu")
	private EntityManager entityManager;

	@Override
	public void saveSample(SampleEntity sampleEntity) {
		entityManager.persist(sampleEntity);
	}

}
