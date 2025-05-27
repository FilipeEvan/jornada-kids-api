package com.unimar.jornada_kids.mapper;

import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelDetalhadoDTO;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelNovoDTO;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelResumidoDTO;
import com.unimar.jornada_kids.model.entity.Responsavel;

public interface ResponsavelMapper {
	Responsavel paraEntity(ResponsavelNovoDTO dto);
	ResponsavelDetalhadoDTO paraDetalhadoDTO(Responsavel responsavel);
	ResponsavelResumidoDTO paraResumidoDTO(Responsavel responsavel);
}
