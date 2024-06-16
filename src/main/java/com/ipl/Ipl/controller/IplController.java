package com.ipl.Ipl.controller;

import com.ipl.Ipl.entity.IplEntity;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ipl.Ipl.service.IplService;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ipl")
public class IplController {
    @Autowired
    public IplService iplService;
    @GetMapping("/season/{season}")
    public List<IplEntity> getDataBySeason(@PathVariable String season){
        return iplService.getIPLDataBySeason(season);
    }
    @GetMapping("/team/{team}")
    public List<IplEntity> getDataByTeam(@PathVariable String team){
        return iplService.getIPLDataByTeam(team);
    }

    @GetMapping("/teams")
    public List<String> getTeams(){
        return iplService.getIplTeams();
    }

    @GetMapping("/seasons")
    public List<String> getSeasons() {
        return iplService.getIplSeasons();
    }

    @GetMapping("/team/{team}/season/{season}")
    public List<IplEntity> getIPLData(@PathVariable String team, @PathVariable String season){
        return iplService.getIPLDataByTeamAndSeason(team,season);
    }
}
