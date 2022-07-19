package me.dio.votacao.bbb.ms.service;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dio.votacao.bbb.ms.model.ParticipanteModel;
import me.dio.votacao.bbb.ms.model.VotacaoModel;
import me.dio.votacao.bbb.ms.repository.VotacaoRepository;

@Service
@Slf4j
@AllArgsConstructor
public class VotacaoService {

    private final VotacaoRepository repository;
    
    public VotacaoService(VotacaoRepository repository) {
		super();
		this.repository = repository;
	}

	@KafkaListener(topics = "votacao", groupId = "MicroServicoVotacao")
    private void executar(ConsumerRecord<String, String> registro) {

        String participanteStr = registro.value();
        System.out.format("Voto recebido = {%s} /n", participanteStr);

        ObjectMapper mapper = new ObjectMapper();
        ParticipanteModel participante = null;

        try {
            participante = mapper.readValue(participanteStr, ParticipanteModel.class);
        } catch (JsonProcessingException ex) {
        	System.out.format("Falha ao converter voto [{%s}] /n", participanteStr, ex);
            return;
        }

        VotacaoModel votacao = new VotacaoModel(null, participante, new Date());
        VotacaoModel entity = repository.save(votacao);

        System.out.format("Voto registrado com sucesso [id={%s}, dataHora={%s}] /n", entity.getId(), entity.getDataHora());
    }

}