package awagadro.studentApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;

import awagadro.studentApp.entity.HibernateUtil;
import awagadro.studentApp.entity.Profession;

public class MainOld {

	// Данный метод просто показывает, как делается запрос при работе на уровне JDBC
	private void oldJDBC() {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {

			// insert into property-class
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			prop.put("serverTimezone", "GMT");
			prop.put("characterEncoding", "UTF-8");
			prop.put("useUnicode", "true");
			prop.put("autoReconnect", "true");
			prop.put("zeroDateTimeBehavior", "CONVERT_TO_NULL");

			Class.forName("com.mysql.cj.jdbc.Driver"); // driver class upload

			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_applicant", prop);
			statement = connection.createStatement();
			List<Profession> list = new ArrayList<Profession>();
			rs = statement.executeQuery(
					"select profession_id, profession_name from profession " + "order by profession_name");
			while (rs.next()) {
				Profession r = new Profession();
				r.setProfessionId(rs.getLong("profession_id"));
				r.setProfessionName(rs.getString("profession_name"));
				list.add(r);
				System.out.println(r.getProfessionId() + ":" + r.getProfessionName());
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println("Error SQL execution: " + ex.getMessage());
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.err.println("Error SQL execution: " + ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.err.println("Error: " + ex.getMessage());
			}
		}
	}

	// Метод добавляет новую запись в таблицу PROFESSION
	private void addProfession(String name) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Profession r = new Profession();
		r.setProfessionName(name);
		session.save(r);
		session.getTransaction().commit();
	}

	// Метод возвращает список профессий
	private List<Profession> listProfession() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Profession> result = session.createQuery("from Profession order by professionName").list();
		session.getTransaction().commit();
		return result;
	}

	// Метод удаляет по очереди все записи, которые ему переданы в виде списка
	private void deleteProfessions(List<Profession> result) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		for (Profession p : result) {
			System.out.println("Delete:" + p.getProfessionId() + ":" + p.getProfessionName());
			session.delete(p);
			// session.flush();
		}
		session.getTransaction().commit();
	}

	// Метод удаляет одну запись
	private void deleteEntity(Object o) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(o);
		session.flush();
		session.getTransaction().commit();
	}

	public static void main(String[] args) {
		MainOld main = new MainOld();

		// Вызов "старого стиля"
//		main.oldJDBC();

		// Добавление новых профессий
//		main.addProfession("Profession_1");
//		main.addProfession("Profession_2");
//		main.addProfession("Profession_3");
//		main.addProfession("Profession_4");
//		main.addProfession("Profession_5");

		// Вариант вызова списка
		List<Profession> result = main.listProfession();
		result.forEach(r -> System.out.println(r));

		// Вариант вызова удаления одной записи
//		result = main.listProfession();
//		main.deleteEntity(result.get(0));

		// Вариант вызова списка и последующее удаление
//		result = main.listProfession();
//		main.deleteProfessions(result);

	}

}
