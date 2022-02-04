package dev.jihun.member.domain;

import dev.jihun.team.domain.Team;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @ManyToOne
    private Team team;

    @Builder
    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addTeam(Team team) {
        this.team = team;
        team.addMember(this);
    }
}
