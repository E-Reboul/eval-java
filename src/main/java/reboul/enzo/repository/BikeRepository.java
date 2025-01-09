package reboul.enzo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import reboul.enzo.model.BikeModel;

public interface BikeRepository extends JpaRepository<BikeModel, Long> {}