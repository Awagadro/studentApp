package awagadro.studentApp;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import awagadro.studentApp.facade.ProfessionFacade;
import awagadro.studentApp.view.ProfessionView;

public class Starter {
	public static void main(String[] args) {
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(
				new String[] { "src/main/java/context.xml", "src/main/java/database.xml" });

		ProfessionFacade pf = (ProfessionFacade) context.getBean("professionFacade");
		ProfessionView pv = new ProfessionView();
		pv.setProfessionName("Java Developer");
		Long id = (Long) pf.addProfession(pv);
		pv.setProfessionId(id);
		pf.updateProfession(pv);
		pf.deleteProfession(pv);
		pf.findProfession();
	}
}
