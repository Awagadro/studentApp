package awagadro.studentApp.dao;

import java.util.List;

import awagadro.studentApp.entity.Profession;
import awagadro.studentApp.entity.Subject;

public class ProfessionDAOImpl extends BaseStudentDAO implements ProfessionDAO {

	@Override
	public Long addProfession(Profession p) {
		return (Long) template.save(p);
	}

	@Override
	public void updateProfession(Profession p) {
		template.saveOrUpdate(p);
	}

	@Override
	public void updateSubjectList(Profession p, List<Subject> sList) {
		p.getSubjectList().clear();
		p.getSubjectList().addAll(sList);
	}

	@Override
	public void deleteProfession(Profession p) {
		template.delete(p);
	}

	@Override
	public Profession getProfession(Long professionId) {
		return (Profession) template.load(Profession.class, professionId);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Profession> findProfession() {
		return (List<Profession>) template.find("FROM Profession ORDER BY professionName");
	}

}
