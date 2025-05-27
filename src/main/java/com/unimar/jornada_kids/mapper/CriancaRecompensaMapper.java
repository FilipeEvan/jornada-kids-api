package com.unimar.jornada_kids.mapper;

import com.unimar.jornada_kids.model.dto.crianca_recompensa.CriancaRecompensaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.crianca_recompensa.CriancaRecompensaNovaDTO;
import com.unimar.jornada_kids.model.entity.CriancaRecompensa;

public interface CriancaRecompensaMapper {
	CriancaRecompensa paraEntity(CriancaRecompensaNovaDTO dto);
	CriancaRecompensaDetalhadaDTO paraDetalhadaDTO(CriancaRecompensa criancaRecompensa);
}
