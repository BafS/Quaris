package ch.heigvd.quaris.repositories;

import ch.heigvd.quaris.models.Point;
import ch.heigvd.quaris.models.Scale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Fabien Salathe & Henrik Akesson
 */
@Repository
public interface PointRepository extends CrudRepository<Point, Long> {
    Point findByEndUserIdAndScaleId(Long endUserId, Long scaleId);

    Point findByEndUserId(Long endUserId);

    Point findByScaleId(Long scaleId);
}
