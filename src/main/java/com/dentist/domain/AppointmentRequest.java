package com.dentist.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name="appointmentrequests")
public class AppointmentRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4417500461064293514L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appointmentRequestID;
	@ManyToOne
	@JoinColumn(name = "patientID",nullable=false)
	private Patient appointmentPatient;
	@Column(nullable=false)
	@Type(type = "encryptedString")
	private String note;
	@Column(nullable=false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime requestedInsertedTime;
	@Column(nullable=false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime appointmentStartTime;
	@Column(nullable=false)
	@Enumerated
	private AppointmentRequestStatus status;
	@OneToOne
	@JoinColumn(name="appointmentID",nullable=true)
	private Appointment appointment;
	
	public AppointmentRequest() {
		
	}

	public long getAppointmentRequestID() {
		return appointmentRequestID;
	}

	public void setAppointmentRequestID(long appointmentRequestID) {
		this.appointmentRequestID = appointmentRequestID;
	}

	public Patient getAppointmentPatient() {
		return appointmentPatient;
	}

	public void setAppointmentPatient(Patient appointmentPatient) {
		this.appointmentPatient = appointmentPatient;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public DateTime getRequestInsertedTime() {
		return requestedInsertedTime;
	}

	public void setRequestInsertedTime(DateTime requestInsertedTime) {
		this.requestedInsertedTime = requestInsertedTime;
	}

	public DateTime getAppointmentStartTime() {
		return appointmentStartTime;
	}

	public void setAppointmentStartTime(DateTime appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}

	public AppointmentRequestStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentRequestStatus status) {
		this.status = status;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	
	
	
	

}
