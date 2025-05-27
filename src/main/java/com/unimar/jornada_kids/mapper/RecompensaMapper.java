package com.unimar.jornada_kids.mapper;

import com.unimar.jornada_kids.model.dto.recompensa.RecompensaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaNovaDTO;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaResumidaDTO;
import com.unimar.jornada_kids.model.entity.Recompensa;

public interface RecompensaMapper {
	Recompensa paraEntity(RecompensaNovaDTO dto);
	RecompensaDetalhadaDTO paraDetalhadaDTO(Recompensa recompensa);
	RecompensaResumidaDTO paraResumidaDTO(Recompensa Recompensa);
}
