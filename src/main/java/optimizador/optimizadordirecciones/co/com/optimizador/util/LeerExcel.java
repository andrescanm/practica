/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizador.optimizadordirecciones.co.com.optimizador.util;

import java.awt.geom.Point2D;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import optimizador.optimizadordirecciones.co.com.optimizador.constante.ConstantesInterfaz;
import optimizador.optimizadordirecciones.co.com.optimizador.entidades.Predio;

/**
 * 
 * @author Yesid Ferrer
 * 
 */
public class LeerExcel {

	private int idRow = 0;
	/**
	 * Logger de la clase.
	 */
	private static final Logger LOGGER = Logger.getLogger(LeerExcel.class);
	private static final String XLS = ".xls";
	private static final String XLSX = ".xlsx";

	/**
	 * Lee un archivo y lo convierte en objetos RuteroVO.
	 * 
	 * @param fileName
	 *            el nombre del archivo.
	 * @return la lista de objetos.
	 */
	public ArrayList<Predio> readExcelData(String fileName) {
		// Se crea un arraylist para guadar las consulta de las celdas
		// del archivo excel.
		// Y un objeto ruteroVO par guardadr la imagen exacta del archivo
		ArrayList<Predio> ruteros = new ArrayList<>();
		Predio ruteroIni;
		FileInputStream fis = null;

		try {
			// Crea stream de entrada para un archivo xlsx/xls
			fis = new FileInputStream(fileName);
			// Se crea una instancia Workbook para manejar el archivo xlsx/xls
			// Se pregunta si el archivo a leer es xlsx o xls para instanciar
			// la clase correspondiente
			Workbook workbook = getWorkbook(fis, fileName);

			// Se obtiene la cantidad de libros que tiene el archivo excel
			int numberOfSheets = workbook.getNumberOfSheets();

			// interacion a traves de cada libro
			for (int i = 0; i < numberOfSheets; i++) {

				// Se obtiene el libro
				Sheet sheet = (Sheet) workbook.getSheetAt(i);

				// Se crear iterador para seleccionar las filas de la
				// hoja del libro seleccionado
				Iterator<Row> rowIterator = sheet.iterator();

				while (rowIterator.hasNext()) {
					if (idRow == 0) { // Para quitar lafila de titulos
						idRow = 1;
						rowIterator.next();
					} else {
						// Se ontiene la fila dentro de un objeto Row
						Row row = rowIterator.next();
						// Se crea iterador para las columnas resultando
						// una celda
						Iterator<Cell> cellIterator = row.cellIterator();
						ruteroIni = new Predio();
						while (cellIterator.hasNext()) {
							// Se obtiene una celda dentro de un objeto
							// Cell
							Cell cell = cellIterator.next();
							asignarDatos(ruteroIni, cell);
						} // Final del iterador de celda
						ruteros.add(ruteroIni);
                                                ruteros = obtenerCoordenadas(ruteros);
                                                
					}
				} // Final del iterador fila
			} // Final del Loop hoja
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
		}
		idRow = 0;
                
		return ruteros;
	}

	/**
	 * Obtiene el workbook segun su extension.
	 * 
	 * @param is
	 * @param excelFilePath
	 * @return
	 */
	private Workbook getWorkbook(FileInputStream is, String excelFilePath) {
		Workbook workbook = null;
		try {
			if (excelFilePath.toLowerCase().endsWith(XLSX)) {
				workbook = (is != null ? new XSSFWorkbook(is)
						: new XSSFWorkbook());
			} else if (excelFilePath.toLowerCase().endsWith(XLS)) {
				workbook = (is != null ? new HSSFWorkbook(is)
						: new HSSFWorkbook());
			} else {
				throw new IllegalArgumentException(ConstantesInterfaz.I_MSJ_EXT);
			}
			return workbook;
		} catch (IOException ioe) {
			LOGGER.error(ioe.toString(), ioe);
			return null;
		}
	}

	/**
	 * Asigna los datos al objeto.
	 * 
	 * @param vo
	 * @param cell
	 */
	private void asignarDatos(Predio vo, Cell cell) {
		switch (cell.getColumnIndex()) {
		case 0:
			double con = cell.getNumericCellValue();
			vo.setIdContrato(String.valueOf(con));
			break;
		case 1:
			double plan = cell.getNumericCellValue();
			vo.setIdPlan(String.valueOf(plan));
			break;
		case 2:
			vo.setLocalidad(cell.getStringCellValue());
			break;
		case 3:
			vo.setSuscritor(cell.getStringCellValue());
			break;
		case 4:
			vo.setVisitado(cell.getStringCellValue());
			break;
		case 5:
			vo.setDireccion(cell.getStringCellValue());
			break;
		case 6:
			double v = cell.getNumericCellValue();
			vo.setVenAforo(String.valueOf(v));
			break;
		case 7:
			vo.setNumHabitacionales(cell.getStringCellValue());
			break;
		case 8:
			vo.setNumNoHabitaconales(cell.getStringCellValue());
			break;
		case 9:
			String tmp = cell.getStringCellValue();
			// vo.setProdBasura(Double.parseDouble(tmp));
			vo.setProdBasura(tmp);
			break;
		case 10:
			double ns = cell.getNumericCellValue();
			vo.setNumSemana(String.valueOf(ns));
			break;
		case 11:
			vo.setTipoAforo(cell.getStringCellValue());
			break;
		case 12:
			vo.setFrecuencia(cell.getStringCellValue());
			break;
		case 13:
			vo.setHorario(cell.getStringCellValue());
			break;
		}
	}

	/**
	 * Constructor por defecto.
	 */
	public LeerExcel() {

	}
        
        private ArrayList<Predio> obtenerCoordenadas (ArrayList<Predio> rut)throws UnsupportedEncodingException, MalformedURLException, NullPointerException{
        
        Iterator<Predio> itList = rut.iterator();
        ArrayList rutero1;
        rutero1 = new ArrayList<>();
        
        while (itList.hasNext()) {
            //Para guardar las filas que se extrajo del excel anadiendo las coordenadas de la direccion
            Predio ruta1 = itList.next();
            
            Geocoding geo = new Geocoding();
            Point2D coor;
            
            String direccion = ruta1.getDireccion();
            coor = geo.getCoordinates(direccion+"Bogota,Colombia");
            String pos = geo.getPostalcode();
            double longitud = coor.getX();
            double latitud = coor.getY();
            
            ruta1.setCodPOstal(pos);
            ruta1.setLongitud(longitud);
            ruta1.setLatitud(latitud);
            rutero1.add(ruta1);
            
        }
        
        
        return rutero1;
    }
        
        public ArrayList<Predio> ordenarDirecciones (ArrayList<Predio> excelOrdenado){
            Collections.sort(excelOrdenado, OrdenDatosEnum.ascending(OrdenDatosEnum.getComparator(OrdenDatosEnum.LONGITUD_SORT,OrdenDatosEnum.LATITUD_SORT)));
            return excelOrdenado;
        }

}
