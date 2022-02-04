package dev.jihun;

import dev.jihun.member.domain.Member;
import dev.jihun.team.domain.Team;
import dev.jihun.team.domain.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitDataBase implements ApplicationRunner {

    private final TeamRepository teamRepository;

    @Override
    public void run(ApplicationArguments args) {
        Team team = new Team("토트넘");
        Member member = Member.builder()
                .name("손흥민")
                .age(29)
                .build();
        Member member1 = Member.builder()
                .name("해리 케인")
                .age(28)
                .build();
        Member member2 = Member.builder()
                .name("델레 알리")
                .age(25)
                .build();
        Member member3 = Member.builder()
                .name("이메르송")
                .age(22)
                .build();
        member.addTeam(team);
        member1.addTeam(team);
        member2.addTeam(team);
        member3.addTeam(team);

        teamRepository.save(team);
    }
}
