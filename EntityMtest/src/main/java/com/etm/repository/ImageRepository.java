package com.etm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etm.model.ImageModel;

@Repository
public interface ImageRepository extends JpaRepository<ImageModel, Long> {

}
