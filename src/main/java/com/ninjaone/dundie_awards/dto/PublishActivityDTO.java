package com.ninjaone.dundie_awards.dto;

import com.ninjaone.dundie_awards.enums.DundieAward;
import com.ninjaone.dundie_awards.model.Employee;

public record PublishActivityDTO(Employee em, DundieAward award) {
}
