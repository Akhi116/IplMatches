package com.ipl.Ipl.dataLoader;

import com.ipl.Ipl.entity.IplEntity;
import com.ipl.Ipl.repository.IplRepository;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class loadCSVData implements CommandLineRunner {

    @Autowired
    public IplRepository iplRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCsvData();
    }

    private void loadCsvData() throws Exception {
        List<IplEntity> iplEntities = new ArrayList<>();

        InputStream inputStream = new ClassPathResource("matches1.csv").getInputStream();

        CsvParserSettings setting = new CsvParserSettings();
        setting.setHeaderExtractionEnabled(true);

        CsvParser csvParser = new CsvParser(setting);
        List<Record> recordList = csvParser.parseAllRecords(inputStream);

        recordList.forEach(record -> {
            IplEntity iplEntity = new IplEntity();
            iplEntity.setSeason(record.getString("season"));
            iplEntity.setTeam1(record.getString("team1"));
            iplEntity.setTeam2(record.getString("team2"));
            iplEntity.setDate(record.getString("date"));
            iplEntity.setMatch_type(record.getString("match_type"));
            iplEntity.setTarget(record.getString("target_runs"));
            iplEntity.setWinner(record.getString("winner"));
            iplEntity.setResult(record.getString("result"));
            iplEntity.setResult_margin(record.getString("result_margin"));
            iplEntity.setPlayer_of_match(record.getString("player_of_match"));

            iplEntities.add(iplEntity);
        });

        iplRepository.saveAll(iplEntities);
    }

}