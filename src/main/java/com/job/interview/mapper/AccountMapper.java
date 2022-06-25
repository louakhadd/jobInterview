package com.job.interview.mapper;

import com.job.interview.dto.AccountDTO;
import com.job.interview.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface AccountMapper extends IEntityMapper<AccountDTO, Account>{
}
