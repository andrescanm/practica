/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizador.optimizadordirecciones.Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class PreguntasDAO {
	/*
    
  // private ArrayList <PreguntasVO> examPreguntas;
    ConexionDB conPreguntas;
        
    
    public ArrayList <PreguntasVO> getPregunta(int idPregunta){ 
        ArrayList examPreguntas = new ArrayList<>();
        PreguntasVO preg;
        
        ConexionDB conPreguntas;
        conPreguntas = new ConexionDB();
               
        try {
            PreparedStatement consulta = conPreguntas.getConnection().prepareStatement("SELECT * FROM PREGUNTAS where IDPREGUNTAS = ?");  //where IDPREGUNTAS = ?
            consulta.setInt(1, idPregunta);
            ResultSet resPreg = consulta.executeQuery();
            while (resPreg.next()) {
                preg = new PreguntasVO();
                preg.setIdPreguntas(Integer.parseInt(resPreg.getString("idPreguntas")));
                preg.setPregunta(resPreg.getString("Pregunta"));
                preg.setA(resPreg.getString("A"));
                preg.setB(resPreg.getString("B"));
                preg.setC(resPreg.getString("C"));
                preg.setD(resPreg.getString("D"));
                preg.setE(resPreg.getString("E"));
                preg.setF(resPreg.getString("F"));
                preg.setG(resPreg.getString("G"));
                preg.setExplicacion(resPreg.getString("Explicacion"));
                preg.setOpcion_A(resPreg.getBoolean("Opcion_A"));
                preg.setOpcion_B(resPreg.getBoolean("Opcion_B"));
                preg.setOpcion_C(resPreg.getBoolean("Opcion_C"));
                preg.setOpcion_D(resPreg.getBoolean("Opcion_D"));
                preg.setOpcion_E(resPreg.getBoolean("Opcion_E"));
                preg.setOpcion_F(resPreg.getBoolean("Opcion_F"));
                preg.setOpcion_G(resPreg.getBoolean("Opcion_G"));
                
                examPreguntas.add(preg);
            
            }
            resPreg.close();
            consulta.close();
            conPreguntas.desconectar();
            
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "no se no se encontro la Pregunta\n"+e);
        }
   
        return examPreguntas;
    }
    
    public PreguntasDAO() {
       // this.examPreguntas = new ArrayList <>();
        conPreguntas = new ConexionDB();
    }

    /*public ArrayList<PreguntasVO> getExamPreguntas() {
        return cuestionario;
    }*/
	
}
