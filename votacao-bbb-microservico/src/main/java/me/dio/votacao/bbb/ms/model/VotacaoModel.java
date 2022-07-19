package me.dio.votacao.bbb.ms.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("votacao")
public class VotacaoModel {
	@Id
	private String id;
	private ParticipanteModel participante;
	private Date dataHora;
	
	public VotacaoModel(String id, ParticipanteModel participante, Date dataHora) {
		this.id = id;
		this.dataHora = dataHora;
		this.participante = participante;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public ParticipanteModel getParticipante() {
		return participante;
	}

	public void setParticipante(ParticipanteModel participante) {
		this.participante = participante;
	}
}
