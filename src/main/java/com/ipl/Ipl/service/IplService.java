package com.ipl.Ipl.service;

import com.ipl.Ipl.entity.IplEntity;
import com.ipl.Ipl.repository.IplRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IplService {

    @Autowired
    public IplRepository iplRepository;

    public List<IplEntity> getIPLDataByTeamAndSeason(String team, String season) {
        System.out.println(season + " "  + team);
        return iplRepository.findByTeamAndSeason(team,season);
    }
    public List<IplEntity> getIPLDataBySeason(String season){
        return iplRepository.findBySeason(season);
    }

    public List<IplEntity> getIPLDataByTeam(String team){
        return iplRepository.findByTeam1OrTeam2(team,team);
    }

    public List<String> getIplTeams() {
        return iplRepository.findByTeams();
    }
    public List<String> getIplSeasons() {
        return iplRepository.findBySeasons();
    }
}
