package me.dio.votacao.bbb.api.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import me.dio.votacao.bbb.api.model.ParticipanteModel;

@Service
public class VotacaoService {

	
    private static final String TOPICO_VOTACAO = "votacao";
    private final KafkaTemplate<Object, Object> template;
   
    public void adicionarEvento(ParticipanteModel participante) {
        template.send(TOPICO_VOTACAO, participante);
	}
    
	public VotacaoService(KafkaTemplate<Object, Object> template) {
		this.template = template;
	}
      
}