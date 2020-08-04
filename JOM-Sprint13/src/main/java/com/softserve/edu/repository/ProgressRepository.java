package com.softserve.edu.repository;

import com.softserve.edu.model.Progress;
import com.softserve.edu.model.Sprint;
import com.softserve.edu.model.Task;
import com.softserve.edu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {

    Optional<Progress> getById(Long id);

    @Query(value = "SELECT P.ID, P.STARTED, P.STATUS, P.UPDATED, P.TASK_ID, P.TRAINEE_ID FROM PROGRESS P JOIN USERS U on P.TRAINEE_ID = U.ID JOIN MARATHON_USER MU on U.ID = MU.USER_ID WHERE U.ID = ?1 AND MU.MARATHON_ID = ?2", nativeQuery = true)
    List<Progress> findByUserIdAndMarathonId(Long userId, Long marathonId);

    List<Progress> findByTraineeAndTask_Sprint(User trainee, Sprint task_sprint);

    Optional<Progress> findByTraineeAndTask(User user, Task task);
}
