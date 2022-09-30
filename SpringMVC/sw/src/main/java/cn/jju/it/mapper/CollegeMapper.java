package cn.jju.it.mapper;

import java.util.List;
import java.util.Map;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import cn.jju.it.model.College;

public interface CollegeMapper {

	public  List<College> getAll();
	 
	public  College getById(Integer id);
	
	public  int  add(College obj);
	
	public int   delete(Integer id);
	
}
