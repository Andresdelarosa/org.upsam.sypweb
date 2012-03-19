package org.upsam.sypweb.view;

import java.io.Serializable;
import java.util.Date;

public class CitacionView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3754720511383675624L;
	/**
	 * Id de cita
	 */
	private Long id;
	/**
	 * Fecha de la cita
	 */
	private Date cita;
	/**
	 * Nombre del servicio
	 */
	private String servicio;
	/**
	 * Nombre del servicio
	 */
	private String responsable;
	/**
	 * Hora de la cita
	 */
	private String hora;
	/**
	 * Indica si se acudio a la cita o no
	 */
	private Boolean acudio;

	/**
	 * 
	 * @param id
	 * @param servicio
	 * @param responsable
	 * @param cita
	 * @param hora
	 * @param acudio
	 */
	public CitacionView(Long id, String servicio, String responsable,
			Date cita, String hora, Boolean acudio) {
		super();
		this.setId(id);
		this.cita = cita;
		this.servicio = servicio;
		this.responsable = responsable;
		this.hora = hora;
		this.acudio = acudio;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the cita
	 */
	public Date getCita() {
		return cita;
	}

	/**
	 * @param cita
	 *            the cita to set
	 */
	public void setCita(Date cita) {
		this.cita = cita;
	}

	/**
	 * @return the hora
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * @param hora
	 *            the hora to set
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}

	/**
	 * @return the servicio
	 */
	public String getServicio() {
		return servicio;
	}

	/**
	 * @param servicio
	 *            the servicio to set
	 */
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	/**
	 * @return the responsable
	 */
	public String getResponsable() {
		return responsable;
	}

	/**
	 * @param responsable
	 *            the responsable to set
	 */
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	/**
	 * @return the acudio
	 */
	public Boolean getAcudio() {
		return acudio;
	}

	/**
	 * @param acudio
	 *            the acudio to set
	 */
	public void setAcudio(Boolean acudio) {
		this.acudio = acudio;
	}

}
