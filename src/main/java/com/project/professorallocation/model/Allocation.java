package com.project.professorallocation.model;

import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;


@Entity
@Table(name = "allocation")
public class Allocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column (nullable = false, name = "day")
	private DayOfWeek dayOfWeek;
	
	@JsonFormat (pattern = "HH:mmZ", timezone = "America/Recife")
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
	@Temporal(TemporalType.TIME)
	@Column (nullable = false)
	private Date startHour;
	
	@JsonFormat (pattern = "HH:mmZ", timezone = "America/Recife")
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
	@Temporal(TemporalType.TIME)
	@Column (nullable = false)
	private Date endHour;
	
	@Column (name = "professor_id", nullable = false)
	private Long professorId;
	
	@Column (name = "course_id", nullable = false)
	private Long CourseID;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "professor_id", nullable = false, insertable =  false, updatable = false)
	private Professor professor;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", nullable = false, insertable =  false, updatable = false)
	private Course course; 

	public Allocation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Date getStartHour() {
		return startHour;
	}

	public void setStartHour(Date startHour) {
		this.startHour = startHour;
	}

	public Date getEndHour() {
		return endHour;
	}

	public void setEndHour(Date endHour) {
		this.endHour = endHour;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}

	public Long getCourseID() {
		return CourseID;
	}

	public void setCourseID(Long courseID) {
		CourseID = courseID;
	}

	@Override
	public String toString() {
		return "Allocation [id=" + id + ", dayOfWeek=" + dayOfWeek + ", startHour=" + startHour + ", endHour=" + endHour
				+ ", professorId=" + professorId + ", CourseID=" + CourseID + "]";
	} 
	
	

}
