package com.ipl.Ipl.repository;

import com.ipl.Ipl.entity.IplEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IplRepository extends JpaRepository<IplEntity, Long> {

    List<IplEntity> findBySeason(String season);
    List<IplEntity> findByTeam1OrTeam2(String team1,String team2);
    @Query("select m from IplEntity m where (m.team1 = :team or m.team2 = :team) and m.season = :season")
    List<IplEntity> findByTeamAndSeason(String team,String season);

    @Query("select DISTINCT i.team1 from IplEntity i ")
    List<String> findByTeams();

    @Query("select DISTINCT i.season from IplEntity i")
    List<String> findBySeasons();
}
