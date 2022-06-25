package com.job.interview.mapper;

import com.job.interview.dto.OperationDTO;
import com.job.interview.model.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface OperationMapper extends IEntityMapper<OperationDTO, Operation>{
}
