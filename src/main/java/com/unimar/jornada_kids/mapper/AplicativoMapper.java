package com.unimar.jornada_kids.mapper;

import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoDetalhadoDTO;
import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoNovoDTO;
import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoResumidoDTO;
import com.unimar.jornada_kids.model.entity.Aplicativo;

public interface AplicativoMapper {
	Aplicativo paraEntity(AplicativoNovoDTO dto);
	AplicativoDetalhadoDTO paraDetalhadoDTO(Aplicativo aplicativo);
	AplicativoResumidoDTO paraResumidoDTO(Aplicativo aplicativo);
}
