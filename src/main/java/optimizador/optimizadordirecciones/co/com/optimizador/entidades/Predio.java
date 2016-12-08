/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizador.optimizadordirecciones.co.com.optimizador.entidades;

import java.io.Serializable;

/**
 * Contiene los datos acerca de las direcciones que debe visitar el aforador
 * 
 * @author Yesid Ferrer
 */
public class Predio implements Serializable {

	private static final long serialVersionUID = 1L;
	private String idContrato;
	private String idPlan;
	private String localidad;
	private String suscritor;
	private String visitado;
	private String direccion;
	private String venAforo;
	private String numHabitacionales;
	private String numNoHabitaconales;
	private String prodBasura;
	private String numSemana;
	private String tipoAforo;
	private String frecuencia;
	private String horario;
	private String observaciones;
        private String codPOstal;
        private double longitud;
        private double latitud;

	/**
	 * Constructor por defecto.
	 */
	public Predio() {
	}

	/**
	 * @return the idContrato
	 */
	public String getIdContrato() {
		return idContrato;
	}

	/**
	 * @param idContrato
	 *            the idContrato to set
	 */
	public void setIdContrato(String idContrato) {
		this.idContrato = idContrato;
	}

	/**
	 * @return the idPlan
	 */
	public String getIdPlan() {
		return idPlan;
	}

	/**
	 * @param idPlan
	 *            the idPlan to set
	 */
	public void setIdPlan(String idPlan) {
		this.idPlan = idPlan;
	}

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad
	 *            the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return the suscritor
	 */
	public String getSuscritor() {
		return suscritor;
	}

	/**
	 * @param suscritor
	 *            the suscritor to set
	 */
	public void setSuscritor(String suscritor) {
		this.suscritor = suscritor;
	}

	/**
	 * @return the visitado
	 */
	public String getVisitado() {
		return visitado;
	}

	/**
	 * @param visitado
	 *            the visitado to set
	 */
	public void setVisitado(String visitado) {
		this.visitado = visitado;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the venAforo
	 */
	public String getVenAforo() {
		return venAforo;
	}

	/**
	 * @param venAforo
	 *            the venAforo to set
	 */
	public void setVenAforo(String venAforo) {
		this.venAforo = venAforo;
	}

	/**
	 * @return the numHabitacionales
	 */
	public String getNumHabitacionales() {
		return numHabitacionales;
	}

	/**
	 * @param numHabitacionales
	 *            the numHabitacionales to set
	 */
	public void setNumHabitacionales(String numHabitacionales) {
		this.numHabitacionales = numHabitacionales;
	}

	/**
	 * @return the numNoHabitaconales
	 */
	public String getNumNoHabitaconales() {
		return numNoHabitaconales;
	}

	/**
	 * @param numNoHabitaconales
	 *            the numNoHabitaconales to set
	 */
	public void setNumNoHabitaconales(String numNoHabitaconales) {
		this.numNoHabitaconales = numNoHabitaconales;
	}

	/**
	 * @return the prodBasura
	 */
	public String getProdBasura() {
		return prodBasura;
	}

	/**
	 * @param prodBasura
	 *            the prodBasura to set
	 */
	public void setProdBasura(String prodBasura) {
		this.prodBasura = prodBasura;
	}

	/**
	 * @return the numSemana
	 */
	public String getNumSemana() {
		return numSemana;
	}

	/**
	 * @param numSemana
	 *            the numSemana to set
	 */
	public void setNumSemana(String numSemana) {
		this.numSemana = numSemana;
	}

	/**
	 * @return the tipoAforo
	 */
	public String getTipoAforo() {
		return tipoAforo;
	}

	/**
	 * @param tipoAforo
	 *            the tipoAforo to set
	 */
	public void setTipoAforo(String tipoAforo) {
		this.tipoAforo = tipoAforo;
	}

	/**
	 * @return the frecuencia
	 */
	public String getFrecuencia() {
		return frecuencia;
	}

	/**
	 * @param frecuencia
	 *            the frecuencia to set
	 */
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	/**
	 * @return the horario
	 */
	public String getHorario() {
		return horario;
	}

	/**
	 * @param horario
	 *            the horario to set
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones
	 *            the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

    public String getCodPOstal() {
        return codPOstal;
    }

    public void setCodPOstal(String codPOstal) {
        this.codPOstal = codPOstal;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Predio [idContrato=" + idContrato + ", idPlan=" + idPlan
				+ ", localidad=" + localidad + ", suscritor=" + suscritor
				+ ", visitado=" + visitado + ", direccion=" + direccion
				+ ", venAforo=" + venAforo + ", numHabitacionales="
				+ numHabitacionales + ", numNoHabitaconales="
				+ numNoHabitaconales + ", prodBasura=" + prodBasura
				+ ", numSemana=" + numSemana + ", tipoAforo=" + tipoAforo
				+ ", frecuencia=" + frecuencia + ", horario=" + horario
				+ ", observaciones=" + observaciones + "]";
	}

}
