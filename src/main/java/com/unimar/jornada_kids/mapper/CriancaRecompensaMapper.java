package com.unimar.jornada_kids.mapper;

import com.unimar.jornada_kids.model.dto.crianca_recompensa.CriancaRecompensaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.crianca_recompensa.RecompensaResgatadaDTO;
import com.unimar.jornada_kids.model.entity.CriancaRecompensa;

public interface CriancaRecompensaMapper {
	CriancaRecompensa paraEntity(RecompensaResgatadaDTO dto);
	CriancaRecompensaDetalhadaDTO paraDetalhadaDTO(CriancaRecompensa criancaRecompensa);
}
