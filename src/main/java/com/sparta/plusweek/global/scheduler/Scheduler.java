package com.sparta.plusweek.global.scheduler;

import com.sparta.plusweek.domain.post.repo.PostRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class Scheduler {

    private final PostRepository postRepository;

    //    @Scheduled(cron = "*/10 * * * * *") // 10초마다
    @Scheduled(cron = "0 0 1 * * *") // 매일 새벽 1시

    @Transactional
    public void deletePost() {
        postRepository.deleteAllByModifiedAtLessThanEqual(LocalDateTime.now().minusDays(90));
//        postRepository.deleteAllByModifiedAtLessThanEqual(LocalDateTime.now().minusSeconds(5));
    }

}
