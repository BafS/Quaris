package ch.heigvd.quaris.repositories;

import ch.heigvd.quaris.models.Point;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Fabien Salathe & Henrik Akesson
 */
@Repository
public interface PointRepository extends CrudRepository<Point, Long> {
    //Point findByEndUserIdAndScaleId(Long endUserId, Long scaleId);

    //Point findByEndUserId(Long endUserId);

    //Point findByScaleId(Long scaleId);

    List<Point> findByEndUserId(Long endUserId); // ByOrderByPointsAsc

    List<Point> findTop10PointsAscByEndUserId(Long endUserId);

    List<Point> findAllByOrderByPointsDesc(); // TODO Top10

    //List<Point> findByApplicationNameByOrderByPointsAsc(String targetApplicationName);
}
