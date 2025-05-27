package com.unimar.jornada_kids.mapper;

import com.unimar.jornada_kids.model.dto.crianca.CriancaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.crianca.CriancaNovaDTO;
import com.unimar.jornada_kids.model.dto.crianca.CriancaResumidaDTO;
import com.unimar.jornada_kids.model.entity.Crianca;

public interface CriancaMapper {
	Crianca paraEntity(CriancaNovaDTO dto);
	CriancaDetalhadaDTO paraDetalhadaDTO(Crianca crianca);
	CriancaResumidaDTO paraResumidaDTO(Crianca crianca);
}
