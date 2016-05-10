package mx.tiid.smartconstruction.util.batch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.persistence.Query;
import javax.sql.DataSource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.SimpleAliasRegistry;

import mx.tiid.smartconstruction.model.Actividades;
import mx.tiid.smartconstruction.model.Empresas;
import mx.tiid.smartconstruction.model.FactoresIncumplimiento;
import mx.tiid.smartconstruction.model.Project;
import mx.tiid.smartconstruction.model.Proyectos;
import mx.tiid.smartconstruction.model.RolUsuarios;
import mx.tiid.smartconstruction.model.Usuarios;

public class BatchLoad {

	public static void main(String[] args) throws IOException, ParseException {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");

		FileInputStream fis = new FileInputStream(new File("toreo.xlsx"));
		XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		Iterator<Row> rowIterator = mySheet.iterator();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		int rowNum;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			rowNum = 0;

			Project activityProject = new Project();
			Actividades actividad = new Actividades();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				switch (rowNum) {
				case 0:
					activityProject.setIdProject(Integer.parseInt(cell.getStringCellValue()));
					break;
				case 1:
					activityProject.setNombre(cell.getStringCellValue());
					break;
				case 2:
					activityProject.setActividad(cell.getNumericCellValue() == 1 ? true : false);
					break;
				case 3:
					activityProject.setHito(cell.getNumericCellValue() == 1 ? true : false);
					break;
				case 4:

					String stringDate = cell.getStringCellValue();
					stringDate = stringDate.replace("\'", "");
					System.out.println(stringDate);
					SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = sp.parse(stringDate);
					activityProject.setFechaComienzo(date);

					actividad.setFechaComienzo(date);
					break;
				case 5:
					String stringDate2 = cell.getStringCellValue();
					stringDate2 = stringDate2.replace("\'", "");

					SimpleDateFormat sp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date2 = sp2.parse(stringDate2);
					activityProject.setFechaTermino(date2);

					actividad.setFechaTermino(date2);
					break;
				case 6:

					String indice = cell.getStringCellValue();
					indice = indice.replace("\'", "");
					activityProject.setIndice(indice);
					break;
				case 7:

					String idProyecto = cell.getStringCellValue();
					Proyectos proyecto = (Proyectos) session.load(Proyectos.class, idProyecto);

					activityProject.setProyectos(proyecto);
					System.out.println(activityProject.toString());
					session.save(activityProject);
					break;

				case 8:

					actividad.setFechaAsignada(new Date());
					actividad.setProject(activityProject);
					actividad.setIdActividad(UUID.randomUUID().toString());

					String idEmpresa = cell.getStringCellValue();

					Empresas empresa = (Empresas) session.load(Empresas.class, idEmpresa);

					actividad.setEmpresas(empresa);
					break;

				case 9:

					String idUsurio = cell.getStringCellValue();

					Usuarios usuario = (Usuarios) session.load(Usuarios.class, idUsurio);

					actividad.setUsuarios(usuario);
					break;
				case 10:

					String idFactorIncumplimiento = cell.getStringCellValue();

					FactoresIncumplimiento factoresIncumplimiento = (FactoresIncumplimiento) session
							.load(FactoresIncumplimiento.class, idFactorIncumplimiento);

					actividad.setFactoresIncumplimiento(factoresIncumplimiento);
					break;
				default:
				}
				rowNum++;
			}
			System.out.println(actividad.toString());
			session.save(actividad);
			System.out.println("");

		}
		session.getTransaction().commit();

	}

}
