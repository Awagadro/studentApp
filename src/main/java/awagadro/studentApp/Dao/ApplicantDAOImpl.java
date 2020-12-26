package awagadro.studentApp.dao;

import java.util.List;

import awagadro.studentApp.entity.Applicant;
import awagadro.studentApp.entity.Profession;

public class ApplicantDAOImpl extends BaseStudentDAO implements ApplicantDAO {

	@Override
	public Long addApplicant(Applicant a) {
		return (Long) template.save(a);
	}

	@Override
	public void updateApplicant(Applicant a) {
		template.saveOrUpdate(a);
	}

	@Override
	public void deleteApplicant(Applicant a) {
		template.delete(a);
	}

	@Override
	public Applicant getApplicant(Long applicantId) {
		return (Applicant) template.load(Applicant.class, applicantId);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Applicant> findApplicant() {
		return (List<Applicant>) template.find(
				"FROM Applicant ORDER BY lastName, firstName, middleName, profession.professionName, entranceYear");
	}

	@Override
	public List<Applicant> findApplicantForProfession(Profession p) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
