package com.epi.exam.dao;

import com.epi.exam.entity.Examination;

import org.springframework.stereotype.Repository;

@Repository
//@Mapper
public interface ExaminationDao {
	int deleteByPrimaryKey(String id);

	int insert(Examination record);

	int insertSelective(Examination record);

	Examination selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Examination record);

	int updateByPrimaryKey(Examination record);
}