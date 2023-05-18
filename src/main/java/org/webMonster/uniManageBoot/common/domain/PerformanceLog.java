package org.webMonster.uniManageBoot.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(of="logNo")
@ToString
@Entity
@Table(name="performance_log")
public class PerformanceLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long logNo;
	
	@Column(length = 50, nullable = false)
	private String signatureName;
	
	@Column(length = 100, nullable = false)
	private String signatureTypeName;
	
	private Long durationTime;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	@CreationTimestamp
	private Date regDate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	@UpdateTimestamp
	private Date updDate;

}
