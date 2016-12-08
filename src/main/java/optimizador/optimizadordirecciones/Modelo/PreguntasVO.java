/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizador.optimizadordirecciones.Modelo;

/**
 *
 * @author 
 */
public class PreguntasVO {
    private int idPreguntas;
    private String pregunta;
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String explicacion;
    private boolean opcion_A;
    private boolean opcion_B;
    private boolean opcion_C;
    private boolean opcion_D;
    private boolean opcion_E;
    private boolean opcion_F;
    private boolean opcion_G;

    public PreguntasVO(int idPreguntas, String pregunta, String A, String B, String C, String D, String E, String F, String G, String explicacion, boolean opcion_A, boolean opcion_B, boolean opcion_C, boolean opcion_D, boolean opcion_E, boolean opcion_F, boolean opcion_G) {
        this.idPreguntas = idPreguntas;
        this.pregunta = pregunta;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.E = E;
        this.F = F;
        this.G = G;
        this.explicacion = explicacion;
        this.opcion_A = opcion_A;
        this.opcion_B = opcion_B;
        this.opcion_C = opcion_C;
        this.opcion_D = opcion_D;
        this.opcion_E = opcion_E;
        this.opcion_F = opcion_F;
        this.opcion_G = opcion_G;
    }

    public int getIdPreguntas() {
        return idPreguntas;
    }

    public void setIdPreguntas(int idPreguntas) {
        this.idPreguntas = idPreguntas;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    public String getD() {
        return D;
    }

    public void setD(String D) {
        this.D = D;
    }

    public String getE() {
        return E;
    }

    public void setE(String E) {
        this.E = E;
    }

    public String getF() {
        return F;
    }

    public void setF(String F) {
        this.F = F;
    }

    public String getG() {
        return G;
    }

    public void setG(String G) {
        this.G = G;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    public boolean isOpcion_A() {
        return opcion_A;
    }

    public void setOpcion_A(boolean opcion_A) {
        this.opcion_A = opcion_A;
    }

    public boolean isOpcion_B() {
        return opcion_B;
    }

    public void setOpcion_B(boolean opcion_B) {
        this.opcion_B = opcion_B;
    }

    public boolean isOpcion_C() {
        return opcion_C;
    }

    public void setOpcion_C(boolean opcion_C) {
        this.opcion_C = opcion_C;
    }

    public boolean isOpcion_D() {
        return opcion_D;
    }

    public void setOpcion_D(boolean opcion_D) {
        this.opcion_D = opcion_D;
    }

    public boolean isOpcion_E() {
        return opcion_E;
    }

    public void setOpcion_E(boolean opcion_E) {
        this.opcion_E = opcion_E;
    }

    public boolean isOpcion_F() {
        return opcion_F;
    }

    public void setOpcion_F(boolean opcion_F) {
        this.opcion_F = opcion_F;
    }

    public boolean isOpcion_G() {
        return opcion_G;
    }

    public void setOpcion_G(boolean opcion_G) {
        this.opcion_G = opcion_G;
    }

    public PreguntasVO() {
    }
    
    
    
}
