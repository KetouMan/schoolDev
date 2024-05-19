package com.luna.school.noyaupartage;

import java.util.UUID;

/**
 * <p>Paramètre pour exporter un document avec l'id de l'entité et le format supporté.</p>
 *
 * @author Anderson Ouattara 2023-11-03
 */
public record ParametresExportAvecIdEtFormat(UUID id, FormatsSupportes format) {

}
