package com.bhashasetu.service;

import static org.assertj.core.api.Assertions.assertThat; import static org.mockito.ArgumentMatchers.any; import static org.mockito.Mockito.*;
import com.bhashasetu.config.BhashaSetuProperties; import com.bhashasetu.model.Scheme; import com.bhashasetu.repository.SchemeRepository; import java.nio.file.Path; import java.util.Optional; import org.junit.jupiter.api.Test;

class DatasetImporterTest {
 @Test void source_keys_match_python_curated_identity_hashes(){assertThat(DatasetImporter.curatedSourceKey("central","All India","Pradhan Mantri Kisan Samman Nidhi (PM-KISAN)")).isEqualTo("curated:e3952d8dfee7328c7a2584b0f20f0cf71af4a0bb1c551b2562072e9b1a792001");assertThat(DatasetImporter.curatedSourceKey("state","Uttar Pradesh","Mukhyamantri Kanya Sumangala Yojana")).isEqualTo("curated:49b84c0682d1887705e04484fe23be247b268c234c468bfa03379f69f78f1df7");}
 @Test void existing_curated_records_are_not_written_without_overwrite() throws Exception {SchemeRepository repository=mock(SchemeRepository.class);when(repository.findBySourceKey(any())).thenReturn(Optional.of(new Scheme()));DatasetImporter importer=new DatasetImporter(repository,new BhashaSetuProperties());var report=importer.importDirectory(Path.of("..","database"),false);assertThat(report.created()).isZero();assertThat(report.updated()).isZero();assertThat(report.unchanged()).isEqualTo(297);verify(repository,never()).save(any());}
}
