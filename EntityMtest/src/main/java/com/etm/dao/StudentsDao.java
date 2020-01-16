package com.etm.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.etm.model.Students;


@Repository("studentsDao")
public class StudentsDao extends CommonDao {
	
	@Transactional
	public void saveModel(Students students) {
		super.entityManager.merge(students);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Students findbyId(String id) {
		List<Students> list = super.entityManager
                .createQuery("from Students where id=:id")
                .setParameter("id", id)
                .getResultList();
		if (list.size() == 0)
			return new Students();
		else
			return (Students)list.get(0);
		}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Students findbyname(String name) {
		List<Students> list = super.entityManager
                .createQuery("from Students where nama=:nama")
                .setParameter("nama", name)
                .getResultList();
		if (list.size() == 0)
			return new Students();
		else
			return (Students)list.get(0);
		}

	@Transactional
	public void deleteStudents(String id) {
		Students model = findbyId(id);
		super.entityManager.remove(model);
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Students> findAll(){
		List <Students> list = super.entityManager.createQuery("FROM Students").getResultList();
		return list;
	}
}
