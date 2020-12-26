package awagadro.studentApp.dao;

import java.util.List;

import awagadro.studentApp.entity.Profession;
import awagadro.studentApp.entity.Subject;

public interface ProfessionDAO {
	 public Long addProfession(Profession p);

	    public void updateProfession(Profession p);

	    public void updateSubjectList(Profession p, List<Subject> sList);

	    public void deleteProfession(Profession p);

	    public Profession getProfession(Long professionId);

	    public List<Profession> findProfession();
}
