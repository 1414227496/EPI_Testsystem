package com.epi.exam.dao;

import com.epi.exam.entity.Score;
import org.springframework.stereotype.Repository;

@Repository
//@Mapper
public interface ScoreDao {
	int deleteByPrimaryKey(String id);

	int insert(Score record);

	int insertSelective(Score record);

	Score selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Score record);

	int updateByPrimaryKey(Score record);
}