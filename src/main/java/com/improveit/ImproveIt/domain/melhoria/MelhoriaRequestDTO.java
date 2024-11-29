package com.improveit.ImproveIt.domain.melhoria;

import java.util.Date;
import java.util.UUID;

public record MelhoriaRequestDTO(String desc_melhoria, String desc_problema, Date data, Boolean status,Boolean aprovacao, UUID id_pilar, UUID id_usuario) {
}
