package awagadro.studentApp.dao;

import java.util.List;

import awagadro.studentApp.entity.Applicant;
import awagadro.studentApp.entity.Profession;

public interface ApplicantDAO {
	public Long addApplicant(Applicant a);

	public void updateApplicant(Applicant a);

	public void deleteApplicant(Applicant a);

	public Applicant getApplicant(Long applicantId);

	public List<Applicant> findApplicant();

	public List<Applicant> findApplicantForProfession(Profession p);
}
